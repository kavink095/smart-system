package com.bolton.project.smartlib.controller;

import com.bolton.project.smartlib.dto.UserBookDTO;
import com.bolton.project.smartlib.entity.Users;
import com.bolton.project.smartlib.service.impl.RentBookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "api/v1/rents")
public class RentController {

    @Autowired
    private RentBookServiceImpl rentBookService;

    @PostMapping("/new")
    public boolean rentBook(@RequestBody UserBookDTO userRBookDTO) {
        rentBookService.newRent(userRBookDTO);
        return true;
    }

    @GetMapping("/rentCheck")
    public int checkOldRentStatus(@RequestBody Users user)throws Exception {
        return rentBookService.rentBook(user.getUserid());
    }
}
