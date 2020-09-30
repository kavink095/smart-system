package com.bolton.project.smartlib.service.impl;

import com.bolton.project.smartlib.dto.RentDTO;
import com.bolton.project.smartlib.entity.Rent;
import com.bolton.project.smartlib.repository.BookRepository;
import com.bolton.project.smartlib.repository.RentRepository;
import com.bolton.project.smartlib.repository.UserRepository;
import com.bolton.project.smartlib.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class RentServiceImpl implements RentService {

    @Autowired
    private RentRepository rentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public boolean RentBook(RentDTO rentDTO) {

        Rent rent = new Rent();
        rent.setRentid(rentDTO.getRentid());
        rent.setIssuedate(rentDTO.getIssuedate());
        rent.setReturndate(rentDTO.getReturndate());
        rent.setReturnstatus(rentDTO.getReturnstatus());
        rent.setRackpositionstatus(rentDTO.getRackpositionstatus());

        rent.setBook(bookRepository.getOne(String.valueOf(rentDTO.getBookDTO().getBookrefid())));

        rent.setUser(userRepository.getOne(String.valueOf(rentDTO.getUserDTO().getUserid())));

        rentRepository.save(rent);

        return true;
    }

    @Override
    public List<Rent> getAll(Pageable pageable) throws Exception {
        try {
            return rentRepository.findAll(pageable).toList();
        } catch (Exception e) {
            throw e;
        }
    }


}
