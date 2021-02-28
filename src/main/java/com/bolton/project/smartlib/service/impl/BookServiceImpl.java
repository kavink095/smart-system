package com.bolton.project.smartlib.service.impl;

import com.bolton.project.smartlib.dto.BookDTO;
import com.bolton.project.smartlib.entity.Book;
import com.bolton.project.smartlib.repository.BookRepository;
import com.bolton.project.smartlib.repository.RackRepository;
import com.bolton.project.smartlib.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class BookServiceImpl implements BookService {
    Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private RackRepository rackRepository;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public boolean CreateBook(BookDTO bookDTO) {

        Book book = new Book();
        book.setBookrefid(bookDTO.getBookrefid());
        book.setBookname(bookDTO.getBookname());
        book.setBookwriter(bookDTO.getBookwriter());
        book.setBookdesc(bookDTO.getBookdesc());
        book.setBookisstatus(bookDTO.getBookisstatus());
//        book.setCell(rackRepository.getOne(bookDTO.getRackid()));
        book.setCell(rackRepository.getOne("R1"));

        bookRepository.save(book);
        return true;
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
}
