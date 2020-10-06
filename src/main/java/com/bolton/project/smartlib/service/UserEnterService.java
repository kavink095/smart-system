package com.bolton.project.smartlib.service;

import java.sql.SQLException;

public interface UserEnterService {

    public int openDoor(String userRefId) throws SQLException;

    public boolean retBook(String bookId) throws SQLException;
}
