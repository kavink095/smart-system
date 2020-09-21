package com.bolton.project.smartlib.service;

import com.bolton.project.smartlib.dto.BookDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    public boolean CreateBook(BookDTO bookDTO);

    //    public ArrayList<UserDTO> getAllUsers();
    List<BookDTO> getAll(Pageable pageable) throws Exception;

    public boolean deleteBook(String id);
}
