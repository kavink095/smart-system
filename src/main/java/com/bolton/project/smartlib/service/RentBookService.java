package com.bolton.project.smartlib.service;

import com.bolton.project.smartlib.dto.UserBookDTO;

import java.io.IOException;

public interface RentBookService {

    public int newRent(UserBookDTO userBookDTO) throws IOException;


}
