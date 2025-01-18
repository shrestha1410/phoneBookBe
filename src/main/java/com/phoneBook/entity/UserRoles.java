package com.phoneBook.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="user_roles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserRoles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="role_id")
    private Role role;
}
