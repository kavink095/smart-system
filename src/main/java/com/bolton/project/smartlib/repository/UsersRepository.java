package com.bolton.project.smartlib.repository;

import com.bolton.project.smartlib.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.transaction.Transactional;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {

    @Query(value = "select u.userid,u.libid,u.useraddress,u.userfname,u.userlname,u.usermobile, " +
            "u.userenteretatus,u.useractivestatus,b.mark from users u  " +
            "inner join userbook b on u.userid=b.userid where u.userid=:userRefId", nativeQuery = true)
    Users findUserByEnter(@Param("userRefId") String userRefId);

    @Query(value = "select * from users u where u.usermail= ?1 and u.userpassword= ?2", nativeQuery = true)
    List<Users> findByAndUsermailAndUserpassword(@Param("usermail") String usermail, @Param("userpassword") String userpassword);

    @Query(value = "select * from users u where u.userenteretatus=1", nativeQuery = true)
    List<Users> findByUserenteretatus();
    
    List<Users> findByUserid(String userid);
    
    
    @Modifying()
    @Query(value="update users u set u.userenteretatus=1 where u.userid =:userid", nativeQuery = true)
//    String userenteretatusUpdate(@Param("userid") Integer val);
    int updateuserenteretatus(@Param("userid") String userid);

}
