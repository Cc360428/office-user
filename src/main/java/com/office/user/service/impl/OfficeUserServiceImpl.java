package com.office.user.service.impl;

import com.office.user.entity.OfficeUser;
import com.office.user.mapper.OfficeUserMapper;
import com.office.user.service.OfficeUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OfficeUserServiceImpl implements OfficeUserService {

    @Resource
    private OfficeUserMapper officeUserMapper;

    @Override
    public int insert(OfficeUser record) {
        System.out.println("Service"+record.toString());
        return officeUserMapper.insert(record);
    }
}
