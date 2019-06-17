package com.office.user.service.impl;

import com.office.user.controller.UserController;
import com.office.user.entity.User;
import com.office.user.mapper.UserMapper;
import com.office.user.service.UserService;
import com.office.user.utils.Help;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Resource
    private UserMapper userMapper;

    @Override
    public Integer reg(User record) {
        int rowNumber;
        rowNumber = userMapper.insert(record);
        return rowNumber;
    }

    @Override
    public void insert(User record) {
        //获取随机盐值
        String salt;
        salt = Help.getRandomSalt();
        logger.info("获取随机盐值" + salt);

    }

    @Override
    public List<User> userAll() {
        List<User> user = userMapper.userAll();
        return user;
    }
}
