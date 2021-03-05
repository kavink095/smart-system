package com.bolton.project.smartlib.service.impl;

import com.bolton.project.smartlib.common.Common;
import com.bolton.project.smartlib.dto.UserBookDTO;
import com.bolton.project.smartlib.entity.Book;
import com.bolton.project.smartlib.entity.UserRBook;
import com.bolton.project.smartlib.repository.BookRepository;
import com.bolton.project.smartlib.repository.UserRBookRepository;
import com.bolton.project.smartlib.repository.UsersRepository;
import com.bolton.project.smartlib.service.RentBookService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class RentBookServiceImpl implements RentBookService {
    Logger logger = LoggerFactory.getLogger(RentBookServiceImpl.class);

    @Autowired
    private UserRBookRepository userRBookRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    @Transactional
    public int newRent(UserBookDTO userBookDTO) {
        int markSet = 1;
        int value = 0;

        /*
         * return values what for.... ?
         * value 0 == error not save
         * value 1 == save new
         * value 2 == not return old book. date expired
         * value 3 == user one month get 3 time borrowing books
         */

        try {

            java.util.Date utilDate = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            String userfnd = userBookDTO.getUserid();
            List<UserRBook> user = userRBookRepository.findAllByUser_UseridAndMark(userfnd, 1);

            if (user != null) {

                if (user.size() >= 3) {
                    value = 3;
                } else {
                    List<UserBookDTO> userDTOS = new ArrayList<>();
                    for (UserRBook users : user) {
                        UserBookDTO userDTO = new UserBookDTO(users.getUserbookid(), users.getTxndate(), users.getRetdate(), users.getMark(), users.getRackmark(), users.getBook().getBookrefid(),
                                users.getBook().getBookrefid());
                        userDTOS.add(userDTO);

                        long dt = Common.betweenDates(users.getTxndate(), utilDate);

                        if (dt >= 30) {
                            value = 2;
                        } else {
                            value = 1;
                        }
                    }
                }

                if (value == 1) {
                    UserRBook userRBook = new UserRBook();
                    userRBook.getUserbookid();
                    userRBook.setTxndate(sqlDate);
                    userRBook.setRetdate(sqlDate);
                    userRBook.setMark(markSet);
                    userRBook.setUser(usersRepository.getOne(userBookDTO.getUserid()));
                    userRBook.setBook(bookRepository.getOne(userBookDTO.getBookrefid()));
                    if (userRBookRepository.save(userRBook) == null) {
                        value = 0;
                    } else {
                        value = 1;
                    }
                }

            }
            return value;
        } catch (
                Exception e) {
            e.printStackTrace();
            return value;
        }
    }

    @Override
    public ArrayList<UserBookDTO> getAllWrong() {
        List<UserRBook> bookList = userRBookRepository.getAllByBookrefidAndUser();
        ArrayList<UserBookDTO> bookDTOs = new ArrayList<>();
        for (UserRBook users : bookList) {
            UserBookDTO userDTO = new UserBookDTO(users.getUserbookid(), users.getTxndate(), users.getRetdate(), users.getMark(), users.getRackmark(), users.getUser().getUserid(),
                    users.getBook().getBookrefid());
            bookDTOs.add(userDTO);

        }
        return bookDTOs;
    }
}
