package com.phoneBook.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ProfileResponseDto {
    private PlansResponseDto plans;
    private List<FamilyAndFriendsDto> familyAndFriends;
    private UserDto user;
}
