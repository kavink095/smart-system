package com.bolton.project.smartlib.service.impl;

import com.bolton.project.smartlib.common.Common;
import com.bolton.project.smartlib.dto.UserDTO;
import com.bolton.project.smartlib.entity.UserRBook;
import com.bolton.project.smartlib.entity.Users;
import com.bolton.project.smartlib.repository.UserRBookRepository;
import com.bolton.project.smartlib.repository.UsersRepository;
import com.bolton.project.smartlib.service.UserEnterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class UserEnterServiceImpl implements UserEnterService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UserRBookRepository userRBookRepository;

    //Common classs object
    Common common = new Common();

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public int openDoor(String userid) throws SQLException {

        try {
            List<Users> user = usersRepository.findByUserid(userid);
            List<UserDTO> userDTOS = new ArrayList<>();
            for (Users users : user) {
                UserDTO userDTO = new UserDTO(
                        users.getUserid(),
                        users.getUserfname(),
                        users.getUserfname(),
                        users.getUsermail(),
                        users.getUserlname(),
                        users.getUseraddress(),
                        users.getUserenteretatus(),
                        users.getUseractivestatus(),
                        users.getUserpassword(),
                        users.getLibrary().getLibid());
                userDTOS.add(userDTO);

            }

//            String activeStatus = userDTOS.get(7).toString();
//            if (activeStatus.equals("0")) {
//                throw new Exception("Invalid User !");
//            }

            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }


    @Override
    public boolean retBook(String bookId) throws SQLException {
        return false;
    }
}
