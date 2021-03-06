package com.office.user.service;

import com.office.user.entity.User;

import java.util.List;

public interface UserService {
    /**
     * reg
     *
     * @param record 实体
     * @return
     */
    Integer reg(User record);

    /**
     * 插入
     *
     * @param record
     */
    void insert(User record);


    User getOneByAccount(String account);

    /**
     * 获取所有数据
     *
     * @return 返回所有数据
     */
    List<User> userAll();


    User selectByPrimaryKey(Integer id);

}
