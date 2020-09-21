package com.bolton.project.smartlib.repository;

import com.bolton.project.smartlib.entity.UserEnter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEnterRepository extends JpaRepository<UserEnter, Integer> {
}
