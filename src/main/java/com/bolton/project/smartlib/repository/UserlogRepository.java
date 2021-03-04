package com.bolton.project.smartlib.repository;

import com.bolton.project.smartlib.entity.Userlog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserlogRepository extends JpaRepository<Userlog,Integer> {
}
