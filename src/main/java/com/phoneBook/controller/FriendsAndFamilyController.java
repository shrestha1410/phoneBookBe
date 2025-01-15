package com.phoneBook.controller;

import com.phoneBook.dto.FamilyAndFriendsDto;
import com.phoneBook.dto.FamilyAndFriendsRequestDto;
import com.phoneBook.service.FamilyAndFriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/familyAndFriends")

public class FriendsAndFamilyController {
    @Autowired
    FamilyAndFriendsService friendsAndFamilyService;
  @GetMapping("/{id}")
    public List<FamilyAndFriendsDto> getListOfFamily(@PathVariable Long id){
      return friendsAndFamilyService.getListByUserId(id);
  }
  @GetMapping("/contact/{id}")
  public FamilyAndFriendsDto getDetailsOfContact(@PathVariable Long id){
    return friendsAndFamilyService.getListByContactId(id);
}
  @PostMapping("/add/{id}")
    public Long addFamilyAndFriendContact(@RequestBody FamilyAndFriendsRequestDto familyAndFriendsRequestDto,@PathVariable Long id ){
      return friendsAndFamilyService.addFamilyAndFriend(familyAndFriendsRequestDto,id);
  }
  @PutMapping("/update/{id}")
  public Long getDetailsOfContact(@RequestBody FamilyAndFriendsRequestDto  fAndFriendsRequestDto,@PathVariable Long id){
    return friendsAndFamilyService.updateContact(id,fAndFriendsRequestDto);
}

}
