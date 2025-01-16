package com.phoneBook.service;

import com.phoneBook.dto.FamilyAndFriendsDto;
import com.phoneBook.dto.PlansResponseDto;
import com.phoneBook.dto.ProfileResponseDto;
import com.phoneBook.dto.UserDto;
import com.phoneBook.entity.FamilyAndFriends;
import com.phoneBook.entity.Plans;
import com.phoneBook.entity.User;
import com.phoneBook.repository.PlansRepository;
import com.phoneBook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PlansRepository plansRepository;
    @Override
    public ProfileResponseDto getProfile(Long mobileNumber) {
    Optional<User> userOptional=userRepository.findByMobileNumber(mobileNumber);
    ProfileResponseDto responseDto = null;
    PlansResponseDto plansResponseDto=null;
    UserDto userDto=null;
    List<FamilyAndFriendsDto> familyAndFriendsDtoList=new ArrayList<>();
    if(userOptional.isPresent()){
        List<FamilyAndFriends> familyAndFriends=userOptional.get().getFamilyAndFriend();
        Plans plans= userOptional.get().getPlan();
        if(plans!=null){
            plansResponseDto= PlansResponseDto.builder()
                    .id(plans.getId())
                    .amount(plans.getAmount())
                    .planName(plans.getPlanName())
                    .subscription(plans.getSubscription())
                    .build();
        }
        if(!familyAndFriends.isEmpty()){
            for(FamilyAndFriends f:familyAndFriends){
               FamilyAndFriendsDto familyAndFriendsDto= FamilyAndFriendsDto.builder()
                       .id(f.getId())
                       .firstName(f.getFirstName())
                       .lastName(f.getLastName())
                       .mobileNumber(f.getMobileNumber())
                       .addressLine1(f.getAddressLine1())
                       .addressLine2(f.getAddressLine2())
                       .build();
                familyAndFriendsDtoList.add(familyAndFriendsDto);
            }
        }
        UserDto user= UserDto.builder()
                .id(userOptional.get().getId())
                .firstName(userOptional.get().getFirstName())
                .lastName(userOptional.get().getLastName())
                .mobileNumber(String.valueOf(userOptional.get().getMobileNumber()))
                .addressLine1(userOptional.get().getAddressLine1())
                .addressLine2(userOptional.get().getAddressLine2())
                .build();
        responseDto= ProfileResponseDto.builder()
                .plans(plansResponseDto)
                .familyAndFriends(familyAndFriendsDtoList)
                .user(user)
                .build();
    }
        return responseDto;
    }
}
