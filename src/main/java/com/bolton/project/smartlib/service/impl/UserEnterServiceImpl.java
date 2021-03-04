package com.bolton.project.smartlib.service.impl;

import com.bolton.project.smartlib.common.Common;
import com.bolton.project.smartlib.dto.UserDTO;
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

    // Common classs object
    Common common = new Common();

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public int openDoor(String userid) throws SQLException {
        int userActive = 0;
        int retStatus = 0;

        try {
            List<Users> user = usersRepository.findByUserid(userid);
            List<UserDTO> userDTOS = new ArrayList<>();
            for (Users users : user) {
                UserDTO userDTO = new UserDTO(users.getUserid(), users.getUserfname(), users.getUsermail(),
                        users.getUserlname(), users.getUseraddress(), users.getUsermobile(), users.getUserenteretatus(),
                        users.getUseractivestatus(), users.getUserpassword(), users.getGender(), users.getAuth());
                userDTOS.add(userDTO);

                userActive = users.getUseractivestatus();

            }
            if (userActive == 0) {
                throw new Exception("invalid user !");
            } else {
                if (usersRepository.updateuserenteretatus(userid) == 1) {
                    retStatus = 1;
                }
            }

            return retStatus;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    @Transactional
    public int exit(String userid) throws SQLException {
        int ret = 0;
        try {
            if (usersRepository.updateByuserenteretatus(userid) == 1) {
                ret = 1;
            }
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
            return ret;
        }
    }

    @Override
    public boolean retBook(String bookId) throws SQLException {
        return false;
    }
}
