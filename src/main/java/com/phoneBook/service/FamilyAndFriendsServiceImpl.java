package com.phoneBook.service;

import com.phoneBook.dto.FamilyAndFriendsDto;
import com.phoneBook.dto.FamilyAndFriendsRequestDto;
import com.phoneBook.entity.FamilyAndFriends;
import com.phoneBook.entity.User;
import com.phoneBook.repository.FamilyAndFriendsRepository;
import com.phoneBook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class FamilyAndFriendsServiceImpl implements FamilyAndFriendsService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    FamilyAndFriendsRepository familyAndFriendsRepository;
    @Override
    public List<FamilyAndFriendsDto> getListByUserId(Long id) {
        Optional<User> user= userRepository.findById(id);
        List<FamilyAndFriendsDto> familyAndFriendsDtoList=new ArrayList<>();
        if(user.isPresent()){
            User existingUser=user.get();
            if(!existingUser.getFamilyAndFriend().isEmpty()) {
                List<FamilyAndFriends> familyAndFriendsExisting=existingUser.getFamilyAndFriend();
                for(FamilyAndFriends  fnf: familyAndFriendsExisting ) {
                    FamilyAndFriendsDto familyAndFriendsDto = FamilyAndFriendsDto.builder()
                            .id(fnf.getId())
                            .firstName(fnf.getFirstName())
                            .lastName(fnf.getLastName())
                            .mobileNumber(fnf.getMobileNumber())
                            .addressLine1(fnf.getAddressLine1())
                            .addressLine2(fnf.getAddressLine2())
                            .build();
                    familyAndFriendsDtoList.add(familyAndFriendsDto);
                }
            }
        }
        return familyAndFriendsDtoList;
    }

    @Override
    public Long addFamilyAndFriend(FamilyAndFriendsRequestDto familyAndFriendsRequestDto,Long id) {
       Optional<User> existing=userRepository.findById(id);
       if(existing.isPresent()){
           FamilyAndFriends familyAndFriends=FamilyAndFriends.builder()
                   .user(existing.get())
                   .firstName(familyAndFriendsRequestDto.getFirstName())
                   .lastName(familyAndFriendsRequestDto.getLastName())
                   .mobileNumber(familyAndFriendsRequestDto.getMobileNumber())
                   .addressLine1(familyAndFriendsRequestDto.getAddressLine1())
                   .addressLine2(familyAndFriendsRequestDto.getAddressLine2())
                   .build();
        FamilyAndFriends familyAndFriends1New= familyAndFriendsRepository.save(familyAndFriends);
        return familyAndFriends1New.getId();
       }else{
           throw new RuntimeException("User is not exist with id:"+id);
       }
    }

    @Override
    public FamilyAndFriendsDto getContactsByContactId(Long id) {
       Optional<FamilyAndFriends> familyAndFriends=familyAndFriendsRepository.findById(id);
       if(familyAndFriends.isPresent()){
        FamilyAndFriends existingFamilyAndFriends=familyAndFriends.get();
        return  FamilyAndFriendsDto.builder()
        .id(existingFamilyAndFriends.getId())
        .firstName(existingFamilyAndFriends.getFirstName())
        .lastName(existingFamilyAndFriends.getLastName())
        .mobileNumber(existingFamilyAndFriends.getMobileNumber())
        .addressLine1(existingFamilyAndFriends.getAddressLine1())
        .addressLine2(existingFamilyAndFriends.getAddressLine2())
                            .build();
       }
       return null;
    }

    @Override
    public Long updateContact(Long id, FamilyAndFriendsRequestDto familyAndFriendsRequestDto) {
        Optional<FamilyAndFriends> familyAndFriends= familyAndFriendsRepository.findById(id);
        if(familyAndFriends.isPresent()){
            FamilyAndFriends exixtingFamilyAndFriends=familyAndFriends.get();
            FamilyAndFriends updatedValue=FamilyAndFriends.builder()
            .id(id)
            .firstName(Optional.ofNullable(familyAndFriendsRequestDto.getFirstName()).orElse(exixtingFamilyAndFriends.getFirstName()))
            .lastName(Optional.ofNullable(familyAndFriendsRequestDto.getLastName()).orElse(exixtingFamilyAndFriends.getLastName()))
            .mobileNumber(Optional.ofNullable(familyAndFriendsRequestDto.getMobileNumber()).orElse(exixtingFamilyAndFriends.getMobileNumber()))
            .addressLine1(Optional.ofNullable(familyAndFriendsRequestDto.getAddressLine1()).orElse(exixtingFamilyAndFriends.getAddressLine1()))
            .addressLine1(Optional.ofNullable(familyAndFriendsRequestDto.getAddressLine2()).orElse(exixtingFamilyAndFriends.getAddressLine2()))
            .user(exixtingFamilyAndFriends.getUser())
            .build();
            updatedValue=familyAndFriendsRepository.save(updatedValue);
            return updatedValue.getId();
        }
        return null;
    }
}
