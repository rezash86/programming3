package com.jac.springboot.demosecurity.dao;

import com.jac.springboot.demosecurity.entity.User;

public interface UserDao {

    User findByUserName(String userName);
    
}
