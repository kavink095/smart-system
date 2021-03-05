package com.bolton.project.smartlib.service;

import com.bolton.project.smartlib.dto.UserBookDTO;

import java.io.IOException;
import java.util.ArrayList;

public interface RentBookService {

    int newRent(UserBookDTO userBookDTO) throws IOException;
    ArrayList<UserBookDTO> getAllWrong();


}
