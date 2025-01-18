package com.phoneBook.dto;

import com.phoneBook.utils.RoleType;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RegisterUser {
    private String firstName;
    private String lastName;
    private Long mobileNumber;
    private String password;
    private String addressLine1;
    private String addressLine2;
    private RoleType role;
}
