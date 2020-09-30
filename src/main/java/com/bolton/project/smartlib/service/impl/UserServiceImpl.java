package com.bolton.project.smartlib.service.impl;

import com.bolton.project.smartlib.dto.UserDTO;
import com.bolton.project.smartlib.entity.User;
import com.bolton.project.smartlib.repository.UserRepository;
import com.bolton.project.smartlib.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int CreateUser(UserDTO userDTO) {


            User user = new User();

            user.setUserid(userDTO.getUserid());
            user.setUserfname(userDTO.getUserfname());
            user.setUserlname(userDTO.getUserlname());
            user.setUseraddress(userDTO.getUseraddress());
            user.setUsermobile(userDTO.getUsermobile());
            user.setUserEnterStatus(userDTO.getUserEnterStatus());
            user.setUseractivestatus(userDTO.getUseractivestatus());

            userRepository.save(user);

            return 1;



    }

    @Override
    public List<User> getAll(Pageable pageable) throws Exception {
        try {
            return userRepository.findAll(pageable).toList();
        } catch (Exception e) {
            logger.debug(e.getMessage(), e);
            throw e;
        }
    }


    @Override
    public boolean deleteUser(String nic) {
        userRepository.deleteById(nic);
        return true;
    }

    @Override
    public UserDTO findUser(String nic) {
        return null;
    }


}
