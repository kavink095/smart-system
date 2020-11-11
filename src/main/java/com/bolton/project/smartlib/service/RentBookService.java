package com.bolton.project.smartlib.service;

import com.bolton.project.smartlib.dto.UserBookDTO;

public interface RentBookService {

    public int newRent(UserBookDTO userBookDTO);

    public int retBook(String bookRefId);
}
