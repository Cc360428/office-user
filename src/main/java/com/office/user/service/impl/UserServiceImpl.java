package com.office.user.service.impl;

import com.office.user.entity.User;
import com.office.user.mapper.UserMapper;
import com.office.user.service.UserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    public Integer insert(User record) {
        int rowNumber;
        rowNumber = userMapper.insert(record);
        return rowNumber;
    }
}
