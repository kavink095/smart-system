package com.bolton.project.smartlib.controller;

import com.bolton.project.smartlib.dto.UserBookDTO;
import com.bolton.project.smartlib.entity.Users;
import com.bolton.project.smartlib.service.impl.RentBookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "api/v1/rents")
public class RentController {

	@Autowired
	private RentBookServiceImpl rentBookService;

//	@PostMapping("/new")
//	public ResponseEntity<?> borrowBook(@RequestBody UserBookDTO userRBookDTO) {
//		try {
//			System.out.println("Rent : "+userRBookDTO.toString());
//			return new ResponseEntity<Object>(rentBookService.newRent(userRBookDTO), HttpStatus.OK);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new ResponseEntity<Object>(rentBookService.newRent(userRBookDTO), HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}

	@PostMapping("/new")
	public boolean rentBook(@RequestBody UserBookDTO userRBookDTO) {
		System.out.println("Rent : " + userRBookDTO.toString());
		return rentBookService.newRent(userRBookDTO);
//		 true;
	}

	@GetMapping("/rentCheck")
	public int checkOldRentStatus(@RequestBody Users user) throws Exception {
		return rentBookService.rentBook(user.getUserid());
	}
}
