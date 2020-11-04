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

    @PutMapping("/open")
    public int enterCheck(@RequestBody String userid) throws SQLException {
//        refid = "U1";
        return userEnterService.openDoor(userid);
    }

    @PutMapping("/bookmark")
    public boolean enterBookUpdate(String bookid) throws SQLException {
//        bookid = "BF1";
        return userEnterService.retBook(bookid);
    }
}
