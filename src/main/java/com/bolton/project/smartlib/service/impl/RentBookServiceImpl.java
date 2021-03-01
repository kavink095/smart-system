package com.bolton.project.smartlib.service.impl;

import com.bolton.project.smartlib.common.Common;
import com.bolton.project.smartlib.dto.UserBookDTO;
import com.bolton.project.smartlib.entity.Book;
import com.bolton.project.smartlib.entity.UserRBook;
import com.bolton.project.smartlib.repository.BookRepository;
import com.bolton.project.smartlib.repository.UserRBookRepository;
import com.bolton.project.smartlib.repository.UsersRepository;
import com.bolton.project.smartlib.service.RentBookService;

import java.util.Date;

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

	Common common = new Common();

	@Override
	@Transactional
	public boolean newRent(UserBookDTO userBookDTO){
		int markSet = 1;
		boolean value = true;
		try {		
			
			java.util.Date utilDate = new java.util.Date();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

			UserRBook userRBook = new UserRBook();
			userRBook.getUserbookid();
			userRBook.setTxndate(sqlDate);
			userRBook.setRetdate(sqlDate);
			userRBook.setMark(markSet);
			userRBook.setUser(usersRepository.getOne(userBookDTO.getUserid()));
			userRBook.setBook(bookRepository.getOne(userBookDTO.getBookrefid()));
//			userRBookRepository.save(userRBook);
			if (userRBookRepository.save(userRBook) == null) {
				value = false;
			}
			
		} catch (Exception e) {
			e.getMessage();
		}
		return value;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public int rentBook(String userid) throws Exception {
		int returnSts = 1;
		int dateSts = 0;

		try {

			String markGetById = userRBookRepository.findUserRBooksByUser(userid);

			UserRBook userRBook1 = userRBookRepository.findUserRBooksByUserAndRetdate(userid);

			Date dtf = new Date();
			dtf.getDate();

			/*
			 * call common class month between method for calculation return date A month
			 * between is equal or grater than 1,dateStatus is 1.
			 */
			if (common.betweenDates(userRBook1.getTxndate(), userRBook1.getRetdate()) >= 30) {
				dateSts = 1;
			}
			String eMark = markGetById;

			if (dateSts == 1) {
				throw new Exception("Please return old books now!");
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

			return returnSts;

		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw e;
		}
	}
}
