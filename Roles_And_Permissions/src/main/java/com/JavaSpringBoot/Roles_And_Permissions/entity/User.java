package com.JavaSpringBoot.Roles_And_Permissions.entity;

import com.JavaSpringBoot.Roles_And_Permissions.entity.type.AuthProviderType;
import com.JavaSpringBoot.Roles_And_Permissions.entity.type.RoleType;
import com.JavaSpringBoot.Roles_And_Permissions.security.RolePermissionMapping;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(indexes = {
        @Index(name = "idx_provider_id_provider_type", columnList = "providerId, providerType")
})

public class User implements UserDetails
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(unique = true)
    private String username;

    private String password;

    private String providerId;

    @Enumerated(EnumType.STRING)
    private AuthProviderType providerType;

    //Store RoleType
    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    Set<RoleType> roles = new HashSet<>();


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
//        return roles.stream()
//              .map(role -> new SimpleGrantedAuthority("ROLE_"+role.name()))
//              .collect(Collectors.toSet());

        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        roles.forEach(
                role -> {
                    Set<SimpleGrantedAuthority> permissions = RolePermissionMapping.getAuthoritiesForRole(role);
                    authorities.addAll(permissions);  //Adding All Permissions.
                    authorities.add(new SimpleGrantedAuthority("ROLE_"+role.name()));
                }
        );
        return authorities;
    }
}
