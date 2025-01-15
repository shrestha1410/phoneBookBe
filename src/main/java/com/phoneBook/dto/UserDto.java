package com.phoneBook.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String pinCode;
}
