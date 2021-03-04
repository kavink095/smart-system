package com.bolton.project.smartlib.controller;

import com.bolton.project.smartlib.dto.UserBookDTO;
import com.bolton.project.smartlib.entity.Users;
import com.bolton.project.smartlib.service.impl.RentBookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "api/v1/rents")
public class RentController {

    @Autowired
    private RentBookServiceImpl rentBookService;

    @PostMapping("/new")
    public int rentBook(@RequestBody UserBookDTO userRBookDTO) {
        int val = rentBookService.newRent(userRBookDTO);
        switch (val) {
            case 0:
                val = 0;
                break;
            case 1:
                val = 1;
                break;
            case 2:
                val = 2;
                break;
            case 3:
                val = 3;
                break;
        }
        return val;
    }

    @GetMapping("/rentCheck")
    public int checkOldRentStatus(@RequestBody Users user) throws Exception {
        return rentBookService.rentBook(user.getUserid());
    }
}
