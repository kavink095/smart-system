package com.bolton.project.smartlib.service;

import com.bolton.project.smartlib.dto.UserDTO;
import com.bolton.project.smartlib.dto.UserlogDTO;

import java.util.ArrayList;

public interface UserlogService {

    void saveUserLog(UserlogDTO userlogDTO);
    public ArrayList<UserlogDTO> getAllUsers();
}
