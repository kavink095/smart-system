package com.bolton.project.smartlib.service.impl;

import com.bolton.project.smartlib.common.Common;
import com.bolton.project.smartlib.dto.UserBookDTO;
import com.bolton.project.smartlib.entity.UserRBook;
import com.bolton.project.smartlib.entity.Users;
import com.bolton.project.smartlib.repository.BookRepository;
import com.bolton.project.smartlib.repository.UserRBookRepository;
import com.bolton.project.smartlib.repository.UsersRepository;
import com.bolton.project.smartlib.service.RentBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RentBookServiceImpl implements RentBookService {

    @Autowired
    private UserRBookRepository userRBookRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UsersRepository usersRepository;

    Common common = new Common();

    @Override
    public int newRent(UserBookDTO userBookDTO) {
        int returnSts = 1;
        int dateSts = 0;

        try {

            UserRBook userRBook = new UserRBook();
            userRBook.setTxndate(userBookDTO.getTxndate());
            userRBook.setRetdate(userBookDTO.getRetdate());
            userRBook.setMark(userBookDTO.getMark());
            userRBook.setUser(usersRepository.getOne(userBookDTO.getUserDTO().getUserid()));
            userRBook.setBook(bookRepository.getOne(userBookDTO.getBookDTO().getBookrefid()));

            //get userid
            String userid = userRBook.getUser().getUserid();

            String markGetById = userRBookRepository.findUserRBooksByUser(userid);

            UserRBook userRBook1 = userRBookRepository.findUserRBooksByUserAndRetdate(userid);

            Date dtf = new Date();
            dtf.getDate();

            /* call common class month between method for calculation return date
             *  A month between is equal or grater than 1,dateStatus is 1.
             *  */
            if (common.monthBetween(userRBook1.getTxndate(), userRBook1.getRetdate()) >= 1) {
                dateSts = 1;
            }
            String eMark = markGetById;

            if (dateSts != 1) {
                if (eMark.equals(1)) {
                    returnSts = 1;
                } else {
                    returnSts = 0;
                }
            }

            UserRBook userB = userRBookRepository.findUserRBookByUserAndUserbookid(userid);

            if (userB == null) {
                throw new Exception("invalid user !");
            }
            if (userB.getMark() == 1) {
                returnSts = 1;
            } else {
                returnSts = 0;
            }

            if (returnSts == 0) {
                userRBookRepository.save(userRBook);
            } else {
                throw new Exception("cannot rent new book !");
            }


            return returnSts;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    @Override
    public int retBook(String bookRefId) {
        return 0;
    }
}
