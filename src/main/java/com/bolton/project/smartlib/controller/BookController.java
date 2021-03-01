package com.bolton.project.smartlib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bolton.project.smartlib.dto.BookDTO;
import com.bolton.project.smartlib.dto.UserDTO;
import com.bolton.project.smartlib.service.BookService;
import com.bolton.project.smartlib.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/book")
public class BookController {
	
    @Autowired
    private BookService bookService;

    @PostMapping("/create")
    public boolean saveUser(@RequestBody BookDTO bookDTO) {
    	System.out.println("book "+ bookDTO.toString());
    	bookService.CreateBook(bookDTO);
        return true;
    }

    @PostMapping("/chkbook")
	public List<BookDTO> checkBook(@RequestBody String bookrefid) {
		System.out.println("User : " + bookrefid);
		return bookService.checkBook(bookrefid);
	}

}
