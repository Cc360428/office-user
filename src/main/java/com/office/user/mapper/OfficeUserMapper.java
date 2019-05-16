package com.office.user.mapper;

import com.office.user.entity.OfficeUser;


public interface OfficeUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OfficeUser record);

    int insertSelective(OfficeUser record);

    OfficeUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OfficeUser record);

    int updateByPrimaryKey(OfficeUser record);
}