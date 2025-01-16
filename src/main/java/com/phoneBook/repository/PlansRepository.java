package com.phoneBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
import org.springframework.stereotype.Repository;

import com.phoneBook.entity.Plans;

@Repository
public class PlansRepository implements JpaRepository<Plans,Long> {
    List<Plans> findAll();
}
