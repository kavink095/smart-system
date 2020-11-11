package com.bolton.project.smartlib.service;

import com.bolton.project.smartlib.dto.UserDTO;
import com.bolton.project.smartlib.entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public interface UserService {
    public boolean CreateUser(UserDTO userDTO);

<<<<<<< HEAD
//        public ArrayList<UserDTO> getAllUsers();
//    List<Users> getAll(Pageable pageable) throws Exception;
=======
    List<Users> getAll(Pageable pageable) throws Exception;
>>>>>>> 2698a82738debbb125d2d6cc891dfe52036d17be

    public boolean deleteUser(String nic);

    public UserDTO findUser(String nic);

    public List<UserDTO> login(String usermail,String password);

}
