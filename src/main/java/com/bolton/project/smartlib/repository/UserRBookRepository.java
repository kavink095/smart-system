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

    @Modifying
    @Query(value = "update userbook b set b.mark='1' where b.bookrefid=:bookrefid", nativeQuery = true)
    int updateMark(@Param("bookrefid") String bookrefid);

    List<UserRBook> findAllByUser_UseridAndMark(@Param("userid") String userid,@Param("mark") int mark);

    @Query(value = "select u.userbookid,u.mark,u.rackmark,u.retdate,u.txndate,u.bookrefid,u.userid,b.racid,b.booknowsts ,case when b.booknowsts IS NOT NUll and b.racid=b.booknowsts then b.racid\n" +
            "end\n" +
            "from userbook u INNER JOIN book b ON u.bookrefid=b.bookrefid group by b.bookrefid",
            nativeQuery = true)
    List<UserRBook> getAllByBookrefidAndUser();

    @Query(value = "select * from userbook where bookrefid=:bookrefid and userid=:userid",nativeQuery = true)
    List<UserRBook> getAllByBookrefidAndUser_Userid(@Param("bookrefid") String bookrefid,@Param("userid") String userid);

}
