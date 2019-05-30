package com.office.user.controller;

import com.office.user.entity.User;
import com.office.user.service.UserService;
import com.office.user.utils.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;


@RestController
@RequestMapping("office/user")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    @PostMapping("/reg")
    public ResponseResult<Integer> reg(@RequestBody User user) {
        logger.info("注册开始 user = {}", user.toString());
        user.setCreateName(user.getAccount());
        user.setIsDelete(1);
        Integer a = userService.insert(user);
        ResponseResult<Integer> rr = new ResponseResult<>();
        rr.setMessage("注册成功");
        logger.info("注册结束");
        rr.setData(a);
        return rr;
    }
}