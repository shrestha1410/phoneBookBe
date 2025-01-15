package com.phoneBook.dto;

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
}
