package com.phoneBook.repository;

import com.phoneBook.entity.FamilyAndFriends;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyAndFriendsRepository extends JpaRepository<FamilyAndFriends,Long> {
}
