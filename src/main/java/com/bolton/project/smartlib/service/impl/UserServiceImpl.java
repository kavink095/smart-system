package com.bolton.project.smartlib.service.impl;

import com.bolton.project.smartlib.dto.UserDTO;
import com.bolton.project.smartlib.entity.User;
import com.bolton.project.smartlib.repository.AccountRepository;
import com.bolton.project.smartlib.repository.LibraryRepository;
import com.bolton.project.smartlib.repository.UserRepository;
import com.bolton.project.smartlib.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public boolean CreateUser(UserDTO userDTO) {

        User user = new User();
        user.setUserid(userDTO.getUserid());
        user.setUserfname(userDTO.getUserfname());

        user.setUserlname(userDTO.getUserlname());
        user.setUseraddress(userDTO.getUseraddress());
        user.setUsermobile(userDTO.getUsermobile());
        user.setUseractivestatus(userDTO.getUseractivestatus());

        userRepository.save(user);

        return true;

    }

    @Override
    public List<User> getAll(Pageable pageable) throws Exception {
        return null;
    }


    @Override
    public boolean deleteUser(String nic) {
        return false;
    }

    @Override
    public UserDTO findUser(String nic) {
        User user = userRepository.findById(nic).get();
        return new UserDTO(user.getUserid(), user.getUserfname(), user.getUserlname(), user.getUseraddress(), user.getUsermobile(), user.getUserEnterStatus(), user.getUseractivestatus());
    }
}
