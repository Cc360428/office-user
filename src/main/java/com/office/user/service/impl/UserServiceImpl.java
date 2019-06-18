package com.office.user.service.impl;

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
        insert(record);
        //TODO 需要异常处理、之后完善
        logger.info("添加要异常处理");
        return 1;
    }

    @Override
    public void insert(User record) {
        String salt = Help.getRandomSalt();
        String saltMD5 = Help.getMD5(salt);
        record.setSalt(saltMD5);
        String passwordMD5 = Help.getMD5(record.getPassword());
        String passwordAndSaltMd5 = Help.encrypt(passwordMD5, saltMD5);
        record.setPassword(passwordAndSaltMd5);
        userMapper.insert(record);
    }

    @Override
    public List<User> userAll() {
        List<User> user = userMapper.userAll();
        return user;
    }
}
