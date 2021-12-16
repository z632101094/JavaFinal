package com.example.javafinal.service;

import com.example.javafinal.bean.UserEntity;
import com.example.javafinal.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserDao userDao;

    public UserEntity createUser(String username, String password) {
        return userDao.createUser(username, password);
    }
}
