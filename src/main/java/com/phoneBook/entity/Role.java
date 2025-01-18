package com.phoneBook.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name="role")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="role_name")
    private String roleName;
    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<UserRoles> user_roles;
}
