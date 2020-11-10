package com.bolton.project.smartlib.service.impl;

import com.bolton.project.smartlib.entity.UserRBook;
import com.bolton.project.smartlib.entity.Users;
import com.bolton.project.smartlib.repository.UserRBookRepository;
import com.bolton.project.smartlib.repository.UsersRepository;
import com.bolton.project.smartlib.service.UserEnterService;
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

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public int openDoor(String userid) throws SQLException {
        int returnSts = 0;
        try {
            UserRBook userB = userRBookRepository.findUserRBookByUserAndUserbookid(userid);

            if (userB == null) {
                throw new RuntimeException("invalid user !");
            }

            if (userB.getMark()==1) {
                returnSts = 1;
            } else {
                returnSts = 0;
            }

            return returnSts;

        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    @Override
    @Transactional
    public boolean retBook(String bookId) throws SQLException {
        int mark = 1;

        try {

            UserRBook userRBook = userRBookRepository.findBookByUserMark(bookId, mark);

            if (!String.valueOf(userRBook.getBook().getBookrefid()).equals(bookId)) {
                throw new RuntimeException("invalid book try again..");
            } else {
                mark = 0;
                userRBookRepository.updateMark(bookId);
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
