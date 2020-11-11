package com.bolton.project.smartlib.service.impl;

import com.bolton.project.smartlib.common.Common;
import com.bolton.project.smartlib.entity.UserRBook;
import com.bolton.project.smartlib.repository.UserRBookRepository;
import com.bolton.project.smartlib.repository.UsersRepository;
import com.bolton.project.smartlib.service.UserEnterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;

import java.util.Calendar;
import java.util.Date;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class UserEnterServiceImpl implements UserEnterService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UserRBookRepository userRBookRepository;

    //Common classs object
    Common common = new Common();

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public int openDoor(String userid) throws SQLException {

        try {


        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
        return 0;
    }


    @Override
    public boolean retBook(String bookId) throws SQLException {
        return false;
    }
}
