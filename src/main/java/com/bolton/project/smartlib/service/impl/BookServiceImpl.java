package com.bolton.project.smartlib.service.impl;

import com.bolton.project.smartlib.dto.BookDTO;
import com.bolton.project.smartlib.dto.UserDTO;
import com.bolton.project.smartlib.dto.UserlogDTO;
import com.bolton.project.smartlib.entity.Book;
import com.bolton.project.smartlib.entity.Userlog;
import com.bolton.project.smartlib.entity.Users;
import com.bolton.project.smartlib.repository.BookRepository;
import com.bolton.project.smartlib.repository.RackRepository;
import com.bolton.project.smartlib.repository.UserRBookRepository;
import com.bolton.project.smartlib.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class BookServiceImpl implements BookService {
	Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private RackRepository rackRepository;

	@Autowired
	private UserRBookRepository userBookRepository;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int CreateBook(BookDTO bookDTO) {

		int ret = 0;
		try {

			List<Book> bookList = bookRepository.findBybookrefid(bookDTO.getBookrefid());

			if (!bookList.isEmpty()) {
				//cannot create user is here..
				ret = 2;
			} else {
				Book book = new Book();
				book.setBookrefid(bookDTO.getBookrefid());
				book.setBookname(bookDTO.getBookname());
				book.setBookwriter(bookDTO.getBookwriter());
				book.setBookdesc(bookDTO.getBookdesc());
				book.setBookisstatus("1");
                book.setRackid(rackRepository.getOne(bookDTO.getRackid()));

				Object obj =bookRepository.save(book);
				if (obj == null) {
					//failed creation
					ret = 0;
				} else {
					//success
					ret = 1;
				}
			}

			return ret;
		} catch (Exception e) {
			logger.debug(e.getMessage(), e);
			return ret;
		}
	}

	@Override
	public List<Book> getAll(Pageable pageable) throws Exception {
		try {
			return bookRepository.findAll(pageable).toList();
		} catch (Exception e) {
			logger.debug(e.getMessage(), e);
			throw e;
		}
	}

	@Override
	public boolean deleteBook(String id) {
		return false;
	}

	@Override
	@Transactional
	public List<BookDTO> checkBook(String bookrefid) {
		List<Book> book = bookRepository.findBybookrefid(bookrefid);
		List<BookDTO> all = new ArrayList<>();
		for (Book book1 : book) {
			BookDTO bookDTO = new BookDTO(book1.getBookrefid(), book1.getBookname(), book1.getBookwriter(),
					book1.getBookdesc(), book1.getBookisstatus(), book1.getBooknowsts(), book1.getRackid().toString());
			all.add(bookDTO);
		}
		return all;
	}

	@Override
	@Transactional
	public int rackPosition(String rackId,String bookrefid) {
		boolean val = false;
		int ret = 0;
		if (bookRepository.updateBooknowsts(rackId,bookrefid) == 1) {
			ret = 1;
		} else {
			ret = 0;
		}

		if (ret == 1) {
			if (val = userBookRepository.updateMark(bookrefid) == 1) {
				ret = 1;
			}else {
				ret = 0;
			}
		}
		return ret;

	}

	@Override
	public ArrayList<BookDTO> getAllBooks() {
		List<Book> bookList = bookRepository.findAll();
		ArrayList<BookDTO> bookDTOs = new ArrayList<>();
		bookList.forEach(book -> bookDTOs.add(new BookDTO(book.getBookrefid(),book.getBookname(),book.getBookwriter(),book.getBookdesc(),
				book.getBookisstatus(),book.getBooknowsts(),book.getRackid().getRacid())));
		return bookDTOs;
	}

	@Override
	@Transactional
	public ArrayList<BookDTO> getAllWrong() {
		List<Book> bookList = bookRepository.getAllByBookrefidAndUser();
		ArrayList<BookDTO> bookDTOs = new ArrayList<>();
		for (Book books : bookList) {
			BookDTO bookDTO = new BookDTO(books.getBookrefid(), books.getBookname(), books.getBookwriter(), books.getBookdesc(), books.getBookisstatus(),
					books.getBooknowsts(), books.getRackid().getRacid());

			bookDTOs.add(bookDTO);

		}
		return bookDTOs;

	}
}
