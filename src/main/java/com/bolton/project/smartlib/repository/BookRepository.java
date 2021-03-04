package com.bolton.project.smartlib.repository;

import com.bolton.project.smartlib.entity.Book;
import com.bolton.project.smartlib.entity.Users;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

	List<Book> findBybookrefid(String bookrefid);

	@Modifying()
	@Query(value = "update book b set b.booknowsts=:rackid where b.bookrefid =:bookrefid", nativeQuery = true)
//	    String userenteretatusUpdate(@Param("userid") Integer val);
	Integer updateBooknowsts(@Param("rackid") String rackid, @Param("bookrefid") String bookrefid);
}
