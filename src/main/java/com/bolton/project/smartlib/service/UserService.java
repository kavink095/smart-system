package com.bolton.project.smartlib.service;

import com.bolton.project.smartlib.dto.UserDTO;
import com.bolton.project.smartlib.entity.Users;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    public boolean CreateUser(UserDTO userDTO);

    //    public ArrayList<UserDTO> getAllUsers();
    List<Users> getAll(Pageable pageable) throws Exception;

    public boolean deleteUser(String nic);

    public UserDTO findUser(String nic);

}
