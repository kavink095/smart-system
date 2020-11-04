package com.bolton.project.smartlib.repository;

import com.bolton.project.smartlib.entity.UserRBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRBookRepository extends JpaRepository<UserRBook, Integer> {
//    public interface ReceiptheaderRepository extends JpaRepository<Receiptheader, Long> {
//    @Query(value = "select u.mark from userbook u where u.userid='userid'", nativeQuery = true)
//    String findBookByUser(@Param("userid") String userid);

    @Query(value = "select * from userbook u where u.userid= ?1", nativeQuery = true)
    UserRBook findUserRBookByUserAndUserbookid(String userid);

//    UserRBook findByUserUserid(String id);
//    UserRBook findUserRBooksBy;

//    @Query(value = "select * from userbook u ", nativeQuery = true)
//    String findBookByUser();

    @Query(value = "select userbookid,mark,rackmark,retdate,txndate,bookrefid,userid from userbook where bookrefid=:bookId and mark=:marks", nativeQuery = true)
    UserRBook findBookByUserMark(@Param("bookId") String userRefId, @Param("marks") int marks);

    @Modifying
    @Query(value = "update userbook b set b.mark=0 where b.bookrefid=:bookId", nativeQuery = true)
    int updateMark(@Param("bookId") String bookId);

    @Modifying
    @Query(value = "update userbook b set b.bookcategory where b.bookrefid=:bookId", nativeQuery = true)
    int updateRackMark(@Param("bookId") String bookId);

}
