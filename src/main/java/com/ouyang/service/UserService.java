package com.ouyang.service;

import com.ouyang.mapper.UserMapper;
import com.ouyang.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by Duning Ouyang on 2017/4/9.
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public List<User> getAll() {
        return userMapper.selectAll();
    }
}
