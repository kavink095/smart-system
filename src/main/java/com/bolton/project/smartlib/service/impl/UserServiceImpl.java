package com.bolton.project.smartlib.service.impl;

import com.bolton.project.smartlib.dto.UserDTO;
import com.bolton.project.smartlib.entity.Users;
import com.bolton.project.smartlib.repository.UsersRepository;
import com.bolton.project.smartlib.service.UserService;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UsersRepository usersRepository;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @ExceptionHandler(value = {Exception.class})
    public int CreateUser(UserDTO userDTO) {
        int ret = 0;
        try {

            List<Users> uselist = usersRepository.findByUserid(userDTO.getUserid());

            if (!uselist.isEmpty()) {
                //cannot create user is here..
                ret = 2;
            } else {
                Users user = new Users();

                user.setUserid(userDTO.getUserid());
                user.setUserfname(userDTO.getUserfname());
                user.setUserlname(userDTO.getUserlname());
                user.setUseraddress(userDTO.getUseraddress());
                user.setUsermobile(userDTO.getUsermobile());
                user.setUserenteretatus("0");
                user.setUseractivestatus(userDTO.getUseractivestatus());
                user.setUsermail(userDTO.getUsermail());
                user.setUserpassword(userDTO.getUserpassword());

                Object obj = usersRepository.save(user);
                if (obj == null) {
                    //failed creation
                    ret = 0;
                } else {
                    //success
                    ret = 1;
                }
            }

            return ret;
        } catch (Exception e) {
            logger.debug(e.getMessage(), e);
            return ret;
        }
    }


    @Override
    public List<Users> getAll(Pageable pageable) throws Exception {
        try {
            return usersRepository.findAll(pageable).toList();
        } catch (Exception e) {
            logger.debug(e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public boolean deleteUser(String nic) {
        usersRepository.deleteById(nic);
        return true;
    }

    @Override
    public UserDTO findUser(String nic) {
        usersRepository.findAll();
        return null;
    }

    @Override
    public List<UserDTO> login(String usermail, String password) {
        List<Users> users = usersRepository.findByAndUsermailAndUserpassword(usermail, password);
        List<UserDTO> all = new ArrayList<>();
        for (Users users1 : users) {
            UserDTO userDTO = new UserDTO(users1.getUserid(), users1.getUserfname(), users1.getUsermail(),
                    users1.getUserlname(), users1.getUseraddress(), users1.getUsermobile(), users1.getUserenteretatus(),
                    users1.getUseractivestatus(), users1.getUserpassword(), users1.getGender(), users1.getAuth());
            all.add(userDTO);
        }
        return all;
    }

    @Override
    public ArrayList<UserDTO> getAllUsers() {
        List<Users> userList = usersRepository.findAll();
        ArrayList<UserDTO> userDTOs = new ArrayList<>();
        userList.forEach(user -> userDTOs.add(new UserDTO(user.getUserid(), user.getUserfname(), user.getUsermail(),
                user.getUserlname(), user.getUseraddress(), user.getUsermobile(), user.getUserenteretatus(),
                user.getUseractivestatus(), user.getUserpassword(), user.getGender(), user.getAuth())));
        return userDTOs;
    }

    @Override
    public ArrayList<UserDTO> getAllActiveUsers() {
        List<Users> userList = usersRepository.findByUserenteretatus();
        ArrayList<UserDTO> userDTOs = new ArrayList<>();
        userList.forEach(user -> userDTOs.add(new UserDTO(user.getUserid(), user.getUserfname(), user.getUsermail(),
                user.getUserlname(), user.getUseraddress(), user.getUsermobile(), user.getUserenteretatus(),
                user.getUseractivestatus(), user.getUserpassword(), user.getGender(), user.getAuth())));
        return userDTOs;
    }

    @Override
    public List<UserDTO> checkUser(String userId) {
        List<Users> users = usersRepository.findByUserid(userId);
        System.out.println("List :" + users.toString());
        List<UserDTO> all = new ArrayList<>();
        for (Users users1 : users) {
            UserDTO userDTO = new UserDTO(users1.getUserid(), users1.getUserfname(), users1.getUsermail(),
                    users1.getUserlname(), users1.getUseraddress(), users1.getUsermobile(), users1.getUserenteretatus(),
                    users1.getUseractivestatus(), users1.getUserpassword(), users1.getGender(), users1.getAuth());
            all.add(userDTO);
        }
        return all;
    }
}
