package com.bolton.project.smartlib.service;

import com.bolton.project.smartlib.dto.UserDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    public boolean CreateUser(UserDTO userDTO);

    //    public ArrayList<UserDTO> getAllUsers();
    List<UserDTO> getAll(Pageable pageable) throws Exception;

    public boolean deleteUser(String nic);
}
