package com.bolton.project.smartlib.controller;

import com.bolton.project.smartlib.dto.BookDTO;
import com.bolton.project.smartlib.dto.UserBookDTO;
import com.bolton.project.smartlib.entity.Users;
import com.bolton.project.smartlib.service.impl.RentBookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

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
            case 4:
                val = 4;
                break;
            case 5:
                val = 5;
                break;
        }
        return val;
    }

    @GetMapping("/getWrong")
    public ArrayList<UserBookDTO> getAllWrong() {
        return rentBookService.getAllWrong();
    }

}
