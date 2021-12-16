package com.example.javafinal.dao;

import com.example.javafinal.bean.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

@Repository(value = "UserDao")
public class UserDao {

    public UserEntity createUser(String username, String password) {

        SessionFactory sf = new Configuration().configure().buildSessionFactory();

        Session session = sf.openSession();
        session.beginTransaction();

        //Create new Employee object
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        userEntity.setPassword(password);

        //Save employee
        session.save(userEntity);

        session.getTransaction().commit();
        session.close();
        sf.close();

        return userEntity;
    }
}
