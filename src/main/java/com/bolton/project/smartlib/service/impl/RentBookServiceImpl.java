package com.bolton.project.smartlib.service.impl;

import com.bolton.project.smartlib.dto.UserBookDTO;
import com.bolton.project.smartlib.entity.UserRBook;
import com.bolton.project.smartlib.repository.BookRepository;
import com.bolton.project.smartlib.repository.UserRBookRepository;
import com.bolton.project.smartlib.repository.UsersRepository;
import com.bolton.project.smartlib.service.RentBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class RentBookServiceImpl implements RentBookService {

    @Autowired
    private UserRBookRepository userRBookRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public boolean newRent(UserBookDTO userBookDTO) {
        try {
            UserRBook userRBook = new UserRBook();

            String sDate1 = "00/00/0000";
            Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);

            userRBook.setTxndate(userBookDTO.getTxndate());
//        userRBook.setRetdate(userBookDTO.getRetdate());
            userRBook.setRetdate(date1);
            userRBook.setMark(userBookDTO.getMark());

            userRBook.setUser(usersRepository.getOne(userBookDTO.getUserDTO().getUserid()));
            userRBook.setBook(bookRepository.getOne(userBookDTO.getBookDTO().getBookrefid()));
            userRBookRepository.save(userRBook);

            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
