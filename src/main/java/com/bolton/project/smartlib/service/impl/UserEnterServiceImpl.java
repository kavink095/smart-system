package com.bolton.project.smartlib.service.impl;

import com.bolton.project.smartlib.entity.UserRBook;
import com.bolton.project.smartlib.entity.Users;
import com.bolton.project.smartlib.repository.UserRBookRepository;
import com.bolton.project.smartlib.repository.UsersRepository;
import com.bolton.project.smartlib.service.UserEnterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.joda.LocalDateParser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sun.nio.ch.Util;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class UserEnterServiceImpl implements UserEnterService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UserRBookRepository userRBookRepository;

    @Override
    public int openDoor(String userid) throws SQLException {
        int returnSts = 1;
        int dateSts = 0;
        try {

            String userRBook = userRBookRepository.findUserRBooksByUser(userid);

            UserRBook userRBook1 = userRBookRepository.findUserRBooksByUserAndRetdate(userid);

            Date dtf = new Date();
            dtf.getDate();

            //check one month period
            if (monthsBetween(userRBook1.getTxndate(),dtf) >= 1) {
                dateSts = 1;
            }
            String eMark = userRBook;

            if (dateSts != 1) {
                if (eMark.equals("1")) {
                    returnSts = 1;
                } else {
                    returnSts = 0;
                }
            }

            return returnSts;

        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    //calculated between two days , 30days
    public static int monthsBetween(Date d1, Date d2) {
        if (d2 == null || d1 == null) {
            return -1;//Error
        }
        Calendar m_calendar = Calendar.getInstance();
        m_calendar.setTime(d1);
        int nMonth1 = 12 * m_calendar.get(Calendar.YEAR) + m_calendar.get(Calendar.MONTH);
        m_calendar.setTime(d2);
        int nMonth2 = 12 * m_calendar.get(Calendar.YEAR) + m_calendar.get(Calendar.MONTH);
        System.out.println("Date - " +java.lang.Math.abs(nMonth2 - nMonth1));
        return java.lang.Math.abs(nMonth2 - nMonth1);
    }

    @Override
    @Transactional
    public boolean retBook(String bookId) throws SQLException {
        int mark = 1;

//        try {
//
//            UserRBook userRBook = userRBookRepository.findBookByUserMark(bookId, mark);
//
//            if (!String.valueOf(userRBook.getBook().getBookrefid()).equals(bookId)) {
//                throw new RuntimeException("invalid book try again..");
//            } else {
//                mark = 0;
//                userRBookRepository.updateMark(bookId);
//            }
//
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
        return false;
//        }
    }
}
