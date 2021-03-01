package com.bolton.project.smartlib.repository;

import com.bolton.project.smartlib.entity.Book;
import com.bolton.project.smartlib.entity.Users;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,String> {
	
	List<Book> findBybookrefid(String bookrefid);
}
