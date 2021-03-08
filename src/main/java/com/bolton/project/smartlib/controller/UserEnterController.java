package com.bolton.project.smartlib.controller;

import com.bolton.project.smartlib.service.UserEnterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@CrossOrigin("*")
@RequestMapping(value = "api/v1/enter")
@RestController
public class UserEnterController {

	@Autowired
	private UserEnterService userEnterService;

	@PutMapping("/open/{refid}")
	public int enterCheck(@PathVariable String refid) throws SQLException {
		int ret = 0;
		if (userEnterService.openDoor(refid) != 0){
			ret = 1;
		}
		return ret;
	}

	@PutMapping("/exit/{refid}")
	public int exitCheck(@PathVariable String refid) throws SQLException {
		int ret = 0;
		if (userEnterService.exit(refid) != 0){
			ret = 1;
		}
		return ret;
	}

	@PutMapping("/exitBook/{bookrefid}")
	public int exitCheckBook(@PathVariable String bookrefid) throws SQLException {
		int ret = 0;
		if (userEnterService.exitBook(bookrefid) != 0){
			ret = 1;
		}
		return ret;
	}

	@PutMapping("/bookmark")
	public boolean enterBookUpdate(String bookid) throws SQLException {
		return userEnterService.retBook(bookid);
	}
}
