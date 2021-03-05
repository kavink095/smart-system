package com.bolton.project.smartlib.repository;

import com.bolton.project.smartlib.entity.Book;

import java.util.List;

import com.bolton.project.smartlib.entity.UserRBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

	List<Book> findBybookrefid(@Param("bookrefid") String bookrefid);

	@Modifying()
	@Query(value = "update book b set b.booknowsts=:rackid where b.bookrefid =:bookrefid", nativeQuery = true)
	Integer updateBooknowsts(@Param("rackid") String rackid, @Param("bookrefid") String bookrefid);

	@Query(value = "select b.bookrefid,b.racid,b.booknowsts,\n" +
			"b.bookdesc,b.bookisstatus,b.bookwriter,b.bookname , case when racid=booknowsts then racid end from book b where b.booknowsts IS NOT NUll group by b.booknowsts",
			nativeQuery = true)
	List<Book> getAllByBookrefidAndUser();
}
