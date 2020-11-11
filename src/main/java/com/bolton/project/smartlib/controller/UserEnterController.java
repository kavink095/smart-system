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
    public int enterCheck(@PathVariable  String refid) throws SQLException {
        return userEnterService.openDoor(refid);
    }

    @PutMapping("/bookmark")
    public boolean enterBookUpdate(String bookid) throws SQLException {
        return userEnterService.retBook(bookid);
    }
}
