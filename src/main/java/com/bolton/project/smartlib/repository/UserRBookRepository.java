package com.bolton.project.smartlib.repository;

import com.bolton.project.smartlib.entity.UserRBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRBookRepository extends JpaRepository<UserRBook, Integer> {

    @Query(value = "select userbookid,mark,retdate,txndate,bookrefid,userid from userbook where userid=:userRefId", nativeQuery = true)
    UserRBook findBookByUser(@Param("userRefId") String userRefId);

    @Query(value = "select userbookid,mark,retdate,txndate,bookrefid,userid from userbook where bookrefid=:bookId and mark=:marks", nativeQuery = true)
    UserRBook findBookByUserMark(@Param("bookId") String userRefId, @Param("marks") int marks);

    @Modifying
    @Query(value = "update userbook b set b.mark=0 where b.bookrefid=:bookId", nativeQuery = true)
    int updateMark(@Param("bookId") String bookId);

}
