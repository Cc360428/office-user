package com.office.user.service;

import com.office.user.entity.User;

public interface UserService {
    /**
     * reg
     * @param record 实体
     * @return
     */
    Integer insert(User record);
}
