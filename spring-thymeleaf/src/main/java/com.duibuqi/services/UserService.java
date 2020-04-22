package com.duibuqi.services;

import com.duibuqi.bean.User;
import com.duibuqi.dao.primary.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public List<User> userList(){
        return userMapper.getAllUser();
    }

    public int insert(User user){
        return userMapper.InsertUser(user);
    }

    public int delete(Integer id){
        return userMapper.delUserById(id);
    }

    public int update(User user){
        return userMapper.UpdateUser(user);
    }

    public User getById(Integer id){
        return userMapper.getUserById(id);
    }
}
