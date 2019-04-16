package com.lihao.diancaisystem.dao;

import com.lihao.diancaisystem.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> selectUser();

    User getUserById(@Param(value = "id") Integer id);

    User getUserByUserName(@Param(value = "userName") String userName);
}
