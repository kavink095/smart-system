package com.bolton.project.smartlib.service.impl;

import com.bolton.project.smartlib.dto.UserEnterDTO;
import com.bolton.project.smartlib.entity.UserEnter;
import com.bolton.project.smartlib.repository.UserEnterRepository;
import com.bolton.project.smartlib.repository.UserRepository;
import com.bolton.project.smartlib.service.UserEnterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserEnterServiceImpl implements UserEnterService {

    @Autowired
    private UserEnterRepository userEnterRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public boolean UserEnter(UserEnterDTO userEnterDTO) {
        UserEnter userEnter = new UserEnter();
        userEnter.setEnterid(userEnterDTO.getEnterid());
        userEnter.setEnterdate(userEnterDTO.getEnterdate());
        userEnter.setEnterstatus(userEnterDTO.getEnterstatus());

        userEnter.setUser(userRepository.getOne(userEnterDTO.getUserDTO().getUserid()));

        userEnterRepository.save(userEnter);

        return true;
    }
}
