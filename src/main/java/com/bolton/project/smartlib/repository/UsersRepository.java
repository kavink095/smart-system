package com.bolton.project.smartlib.repository;

import com.bolton.project.smartlib.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {

    @Query(value = "select u.userenteretatus,u.useractivestatus,b.mark from users u  inner join userbook b on u.userid=b.userid where u.userid=:userid",nativeQuery = true)
    Users findUserByEnter(@Param("userid") String userid);
}