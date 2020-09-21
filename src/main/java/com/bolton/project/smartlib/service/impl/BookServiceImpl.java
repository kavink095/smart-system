package com.bolton.project.smartlib.service.impl;

import com.bolton.project.smartlib.dto.BookDTO;
import com.bolton.project.smartlib.entity.Book;
import com.bolton.project.smartlib.repository.BookRepository;
import com.bolton.project.smartlib.repository.RackRepository;
import com.bolton.project.smartlib.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private RackRepository rackRepository;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public boolean CreateBook(BookDTO bookDTO) {

        Book book = new Book();
        book.setBookrefid(bookDTO.getBookrefid());
        book.setBookcategory(bookDTO.getBookcategory());
        book.setBookname(bookDTO.getBookname());
        book.setBookisstatus(bookDTO.getBookisstatus());

        book.setRack(rackRepository.getOne(String.valueOf(bookDTO.getRackDTO().getRackid())));

        bookRepository.save(book);

        return true;
    }

    @Override
    public List<BookDTO> getAll(Pageable pageable) throws Exception {
        return null;
    }

    @Override
    public boolean deleteBook(String id) {
        return false;
    }
}
