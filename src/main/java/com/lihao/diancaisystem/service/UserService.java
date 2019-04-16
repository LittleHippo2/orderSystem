package com.lihao.diancaisystem.service;

import com.lihao.diancaisystem.po.User;

import java.util.List;


public interface UserService {

    List<User> selectUser();

    User getUserById(Integer id);

    User getUserByUserName(String userName);
}
