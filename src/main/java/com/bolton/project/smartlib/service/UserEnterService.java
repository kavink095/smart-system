package com.bolton.project.smartlib.service;

import java.sql.SQLException;

public interface UserEnterService {

    public int openDoor(String userid) throws SQLException;

    public boolean retBook(String bookId) throws SQLException;
}
