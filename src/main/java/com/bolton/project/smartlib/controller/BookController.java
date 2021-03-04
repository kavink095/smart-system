package com.bolton.project.smartlib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
		bookService.CreateBook(bookDTO);
		return true;
	}

	@PostMapping("/chkbook")
	public List<BookDTO> checkBook(@RequestBody String bookrefid) {
		System.out.println("User : " + bookrefid);
		return bookService.checkBook(bookrefid);
	}

	@PutMapping("/racks/{rackid}/{bookrefid}")
	public int upDateReBorrow(@PathVariable String rackid,@PathVariable String bookrefid) {
		int ret = 0;
		if (bookService.rackPosition(rackid,bookrefid) != 0) {
			ret = 1;
		} else {
			ret = 0;
		}
		return ret;
	}

}
