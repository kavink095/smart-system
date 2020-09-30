package com.bolton.project.smartlib.service;

import com.bolton.project.smartlib.dto.RentDTO;
import com.bolton.project.smartlib.entity.Rent;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface RentService {
    public boolean RentBook(RentDTO rentDTO);

    List<Rent> getAll(Pageable pageable) throws Exception;
}
