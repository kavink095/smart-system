package com.bolton.project.smartlib.service;

import com.bolton.project.smartlib.dto.BookDTO;
import com.bolton.project.smartlib.entity.Book;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    public boolean CreateBook(BookDTO bookDTO);

    //    public ArrayList<UserDTO> getAllUsers();
    List<Book> getAll(Pageable pageable) throws Exception;

    public boolean deleteBook(String id);
	public List<BookDTO> checkBook(String bookrefid);
	public void rackPosition(String bookrefid,String rackId);
}
