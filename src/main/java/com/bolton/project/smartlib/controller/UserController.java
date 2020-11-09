package com.bolton.project.smartlib.controller;

import com.bolton.project.smartlib.dto.UserDTO;
import com.bolton.project.smartlib.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public boolean saveUser(@RequestBody UserDTO userDTO) {
        userService.CreateUser(userDTO);
        return true;
    }

///    @GetMapping("/getAll")
//    public ArrayList<UserDTO> getAllUsers(){
//        return userService.getAllUsers();
//    }
//}
}
