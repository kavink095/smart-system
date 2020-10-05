package com.bolton.project.smartlib.controller;

import com.bolton.project.smartlib.service.UserEnterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@CrossOrigin("*")
@RequestMapping(value = "api/v1/enter")
@RestController
public class UserEnterController {

    @Autowired
    private UserEnterService userEnterService;

    @PutMapping("/open")
    public int enterCheck(String refid) throws SQLException {
        refid = "U1";
        return userEnterService.openDoor(refid);
    }
}
