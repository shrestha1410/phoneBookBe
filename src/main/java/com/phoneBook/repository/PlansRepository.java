package com.phoneBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.phoneBook.entity.Plans;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlansRepository extends JpaRepository<Plans,Long> {
    @Query(value = "select * from plans",nativeQuery = true)
    List<Plans> findAllPans();
    Optional<Plans> findById(Long id);
}
