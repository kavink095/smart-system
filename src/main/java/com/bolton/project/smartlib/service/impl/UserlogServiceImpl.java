package com.bolton.project.smartlib.service.impl;

import com.bolton.project.smartlib.dto.RackDTO;
import com.bolton.project.smartlib.dto.UserDTO;
import com.bolton.project.smartlib.dto.UserlogDTO;
import com.bolton.project.smartlib.entity.Rack;
import com.bolton.project.smartlib.entity.Userlog;
import com.bolton.project.smartlib.repository.UserlogRepository;
import com.bolton.project.smartlib.service.UserlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public ArrayList<UserlogDTO> getAllUsers() {
        List<Userlog> logList = userlogRepository.findAll();
        ArrayList<UserlogDTO> logDTOs = new ArrayList<>();
        logList.forEach(log -> logDTOs.add(new UserlogDTO(log.getLogid(),log.getUserid(),log.getMark(),log.getEnterdate(),log.getEntertime(),log.getExittime())));
        return logDTOs;
    }
}
