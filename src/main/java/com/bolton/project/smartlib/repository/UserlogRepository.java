package com.bolton.project.smartlib.repository;

import com.bolton.project.smartlib.entity.Userlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Time;

public interface UserlogRepository extends JpaRepository<Userlog,Integer> {

    @Modifying
    @Query(value = "update userlog u set u.exittime=:exittime , u.mark='0' where u.userid=:userid and u.mark='1'", nativeQuery = true)
    int updateExittime(@Param("exittime") Time exittime, @Param("userid") String userid);
}
