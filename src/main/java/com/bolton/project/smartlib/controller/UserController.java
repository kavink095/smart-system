package com.bolton.project.smartlib.controller;

import com.bolton.project.smartlib.dto.UserDTO;
import com.bolton.project.smartlib.entity.Users;
import com.bolton.project.smartlib.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> 2698a82738debbb125d2d6cc891dfe52036d17be

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

<<<<<<< HEAD
///    @GetMapping("/getAll")
//    public ArrayList<UserDTO> getAllUsers(){
//        return userService.getAllUsers();
//    }
//}
=======
    @PostMapping("/login")
    public List<UserDTO> login(@RequestBody UserDTO userDTO) {
        return userService.login(userDTO.getUsermail(),userDTO.getUserpassword());
    }

    public Page<Users> showUsers(@RequestParam(defaultValue = "0") int page){
        return null;
    }
>>>>>>> 2698a82738debbb125d2d6cc891dfe52036d17be
}
