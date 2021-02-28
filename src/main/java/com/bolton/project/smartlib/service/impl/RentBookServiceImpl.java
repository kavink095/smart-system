package com.bolton.project.smartlib.service.impl;

import com.bolton.project.smartlib.common.Common;
import com.bolton.project.smartlib.dto.UserBookDTO;
import com.bolton.project.smartlib.entity.UserRBook;
import com.bolton.project.smartlib.repository.BookRepository;
import com.bolton.project.smartlib.repository.UserRBookRepository;
import com.bolton.project.smartlib.repository.UsersRepository;
import com.bolton.project.smartlib.service.RentBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

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
	@Transactional(propagation = Propagation.SUPPORTS)
	public boolean newRent(UserBookDTO userBookDTO) {
		int markSet = 1;
		try {

			java.util.Date utilDate = new java.util.Date();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

			UserRBook userRBook = new UserRBook();
			userRBook.setTxndate(sqlDate);
			userRBook.setRetdate(sqlDate);
			userRBook.setMark(markSet);
			userRBook.setUser(usersRepository.getOne(userBookDTO.getUser()));
			userRBook.setBook(bookRepository.getOne(userBookDTO.getBook()));
			userRBookRepository.save(userRBook);

			return true;
		} catch (Exception e) {
			logger.debug(e.getMessage(), e);
			throw e;
		}
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
