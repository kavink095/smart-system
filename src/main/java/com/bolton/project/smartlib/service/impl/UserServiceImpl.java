package com.bolton.project.smartlib.service.impl;

import com.bolton.project.smartlib.dto.UserDTO;
import com.bolton.project.smartlib.entity.Users;
import com.bolton.project.smartlib.repository.LibraryRepository;
import com.bolton.project.smartlib.repository.UsersRepository;
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
    private UsersRepository usersRepository;

    @Autowired
    private LibraryRepository libraryRepository;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public boolean CreateUser(UserDTO userDTO) {

        try {
            Users user = new Users();

            user.setUserid(userDTO.getUserid());
            user.setUserfname(userDTO.getUserfname());
            user.setUserlname(userDTO.getUserlname());
            user.setUseraddress(userDTO.getUseraddress());
            user.setUsermobile(userDTO.getUsermobile());
            user.setUserenteretatus(userDTO.getUserenteretatus());
            user.setUseractivestatus(userDTO.getUseractivestatus());

            user.setLibrary(libraryRepository.getOne(Integer.valueOf(userDTO.getLibraryDTO().getLibid())));

            usersRepository.save(user);

        } catch (Exception e) {
            logger.debug(e.getMessage(), e);
            throw e;
        }
        return true;
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
        return null;
    }


}
