package com.office.user.controller;

import com.office.user.entity.User;
import com.office.user.service.UserService;
import com.office.user.utils.ResponseResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("office/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/reg")
    public ResponseResult<Integer> reg(@RequestBody User user) {
        user.setCreateName(user.getAccount());
        user.setIsDelete(1);
        Integer a =  userService.insert(user);
        ResponseResult<Integer> rr = new ResponseResult<Integer>();
        rr.setMessage("注册成功");
        rr.setData(a);
        return rr;
    }
}