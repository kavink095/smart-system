package com.bolton.project.smartlib.service.impl;

import com.bolton.project.smartlib.dto.UserlogDTO;
import com.bolton.project.smartlib.entity.Userlog;
import com.bolton.project.smartlib.repository.UserlogRepository;
import com.bolton.project.smartlib.service.UserlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserlogServiceImpl implements UserlogService {

    @Autowired
    private UserlogRepository userlogRepository;

    @Override
    @Transactional
    public void saveUserLog(UserlogDTO userlogDTO) {
        try {
            Userlog userlog = new Userlog();
            userlog.setLogid(userlogDTO.getLogid());
            userlog.setUserid(userlogDTO.getUserid());
            userlog.setMark(userlogDTO.getMark());
            userlog.setEnterdate(userlogDTO.getEnterdate());
            userlog.setEntertime(userlogDTO.getEntertime());
            userlog.setExittime(null);

            userlogRepository.save(userlog);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
