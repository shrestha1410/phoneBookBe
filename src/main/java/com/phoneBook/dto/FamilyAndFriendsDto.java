package com.phoneBook.dto;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class FamilyAndFriendsDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Long mobileNumber;
    private String addressLine1;
    private String addressLine2;
}
