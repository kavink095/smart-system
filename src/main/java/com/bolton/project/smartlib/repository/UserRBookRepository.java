package com.bolton.project.smartlib.repository;

import com.bolton.project.smartlib.entity.UserRBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRBookRepository extends JpaRepository<UserRBook, Integer> {

    @Query(value = "SELECT u.mark FROM userbook u WHERE u.userid = ?1", nativeQuery = true)
    String findUserRBooksByUser(@Param("userid")String userid);

    @Query(value = "SELECT * FROM  userbook u WHERE u.userid = ?1", nativeQuery = true)
    UserRBook findUserRBooksByUserAndRetdate(@Param("userid")String userid);

    @Query(value = "select * from userbook u where u.userid= ?1", nativeQuery = true)
    UserRBook findUserRBookByUserAndUserbookid(@Param("userid")String userid);



    @Query(value = "select userbookid,mark,rackmark,retdate,txndate,bookrefid,userid from userbook where bookrefid=:bookId and mark=:marks", nativeQuery = true)
    UserRBook findBookByUserMark(@Param("bookId") String userRefId, @Param("marks") int marks);

    @Modifying
    @Query(value = "update userbook b set b.bookcategory where b.bookrefid=:bookId", nativeQuery = true)
    int updateRackMark(@Param("bookId") String bookId);


}
