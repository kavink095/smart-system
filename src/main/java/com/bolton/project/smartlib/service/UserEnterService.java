package com.bolton.project.smartlib.service;

import com.bolton.project.smartlib.dto.UserDTO;

import java.sql.SQLException;

public interface UserEnterService {
    public int openDoor(String userRefId) throws SQLException;
}
