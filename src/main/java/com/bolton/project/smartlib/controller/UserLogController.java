package com.bolton.project.smartlib.controller;

import com.bolton.project.smartlib.dto.UserlogDTO;
import com.bolton.project.smartlib.repository.UserlogRepository;
import com.bolton.project.smartlib.service.UserlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
@CrossOrigin
@RequestMapping("api/v1/logs")
public class UserLogController {

    @Autowired
    private UserlogService userlogService;

    @GetMapping("/getAll")
    public ArrayList<UserlogDTO> getAllLogs() {
        return userlogService.getAllUsers();
    }
}
