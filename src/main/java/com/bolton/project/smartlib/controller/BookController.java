package com.bolton.project.smartlib.controller;

import java.util.ArrayList;
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
	public int saveUser(@RequestBody BookDTO bookDTO) {
        int valBook = bookService.CreateBook(bookDTO);

        switch (valBook) {
            case 0:
                valBook = 0;
                break;
            case 1:
                valBook = 1;
                break;
            case 2:
                valBook = 2;
        }
        return valBook;
	}

	@PostMapping("/chkbook")
	public List<BookDTO> checkBook(@RequestBody String bookrefid) {
		System.out.println("Book : " + bookrefid);
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

	@GetMapping("/getAll")
	public ArrayList<BookDTO> getAllUsers() {
		return bookService.getAllBooks();
	}

	@GetMapping("/getWrong")
	public ArrayList<BookDTO> getAllWrong() {
		return bookService.getAllWrong();
	}
}
