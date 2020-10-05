package com.bolton.project.smartlib.service.impl;

import com.bolton.project.smartlib.entity.UserRBook;
import com.bolton.project.smartlib.entity.Users;
import com.bolton.project.smartlib.repository.UserRBookRepository;
import com.bolton.project.smartlib.repository.UsersRepository;
import com.bolton.project.smartlib.service.UserEnterService;
import org.hibernate.internal.SessionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class UserEnterServiceImpl implements UserEnterService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UserRBookRepository userRBookRepository;

    @Override
    public int openDoor(String userRefId) throws SQLException {
        int returnSts = 0;
        try {
            Users user = usersRepository.findUserByEnter(userRefId);
            UserRBook userRBook = userRBookRepository.findBookByUser(userRefId);

            if (user.getUserenteretatus().equals("E") || Integer.valueOf(user.getUseractivestatus()).equals("1")) {
                returnSts = 1;
            } else if (Integer.valueOf(userRBook.getMark()).equals("1")) {
                returnSts = 1;
            } else {
                returnSts = 0;
            }

            return returnSts;

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
