package com.bolton.project.smartlib.service;

import com.bolton.project.smartlib.dto.UserBookDTO;

public interface RentBookService {

    public boolean newRent(UserBookDTO userBookDTO);

    public int rentBook(String bookRefId)throws Exception;
}
