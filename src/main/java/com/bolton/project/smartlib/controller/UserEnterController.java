package com.bolton.project.smartlib.controller;

import com.bolton.project.smartlib.service.UserEnterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.RequestContextUtils;

import java.sql.SQLException;

@CrossOrigin("*")
@RequestMapping(value = "api/v1/enter")
@RestController
public class UserEnterController {

    @Autowired
    private UserEnterService userEnterService;

    @PutMapping("/open")
    public int enterCheck(@RequestBody String refid) throws SQLException {
//        refid = "U1";
        System.out.println(refid);
        return userEnterService.openDoor(refid);
    }

    @PutMapping("/bookmark")
    public boolean enterBookUpdate(String bookid) throws SQLException {
//        bookid = "BF1"/;
        System.out.println("book "+bookid);
        return userEnterService.retBook(bookid);
    }
}
