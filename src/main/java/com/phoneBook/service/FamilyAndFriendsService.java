package com.phoneBook.service;

import com.phoneBook.dto.FamilyAndFriendsDto;
import com.phoneBook.dto.FamilyAndFriendsRequestDto;
import java.util.List;

public interface FamilyAndFriendsService {
    public List<FamilyAndFriendsDto> getListByUserId(Long id);
    public Long addFamilyAndFriend(FamilyAndFriendsRequestDto familyAndFriendsRequestDto,Long id);
    public FamilyAndFriendsDto getListByContactId(Long id);
    public Long updateContact(Long id,FamilyAndFriendsRequestDto familyAndFriendsRequestDto);
}
