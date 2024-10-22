package com.bolton.project.smartlib.service.impl;

import com.bolton.project.smartlib.common.Common;
import com.bolton.project.smartlib.dto.UserDTO;
import com.bolton.project.smartlib.dto.UserlogDTO;
import com.bolton.project.smartlib.entity.Book;
import com.bolton.project.smartlib.entity.Userlog;
import com.bolton.project.smartlib.entity.Users;
import com.bolton.project.smartlib.repository.BookRepository;
import com.bolton.project.smartlib.repository.UserRBookRepository;
import com.bolton.project.smartlib.repository.UserlogRepository;
import com.bolton.project.smartlib.repository.UsersRepository;
import com.bolton.project.smartlib.service.UserEnterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class UserEnterServiceImpl implements UserEnterService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRBookRepository userRBookRepository;

    @Autowired
    private UserlogRepository userlogRepository;

    // Common classs object
    Common common = new Common();

    java.util.Date utilDate = new java.util.Date();
    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

    //Get SQL time instance
    java.sql.Time sqlTime = new Time(sqlDate.getTime());

    //Get LocalTime from SQL time
    LocalTime localTime = sqlTime.toLocalTime();

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

                    //add user enter data to user log table
                    Userlog userlog = new Userlog();
                    UserlogDTO userlogDTO = new UserlogDTO();

                    userlog.setLogid(userlogDTO.getLogid());
                    userlog.setUserid(userid);
                    userlog.setMark(1);
                    userlog.setEnterdate(sqlDate);
                    userlog.setEntertime(sqlTime);
                    userlog.setExittime(null);

                    Object obj = userlogRepository.save(userlog);

                    if (obj != null){
                        retStatus = 1;
                    }else {
                        retStatus = 0;
                    }
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
                userlogRepository.updateExittime(sqlTime,userid);
                ret = 1;
            }
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
            return ret;
        }
    }

    @Override
    public int exitBook(String bookrefid) throws SQLException {
        int ret = 0;
        try {
            List<Book> bookList = bookRepository.getBookBybookisstatus(bookrefid);
            if (bookList.isEmpty()) {
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
