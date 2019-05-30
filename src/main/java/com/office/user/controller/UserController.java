package com.office.user.controller;

import com.office.user.entity.OfficeUser;
import com.office.user.service.OfficeUserService;
import com.office.user.utils.ResponseResult;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("office/user")
public class UserController {
    @Resource
    private OfficeUserService officeUserService;

    @PostMapping("/reg")
    public ResponseResult<Integer> reg(@RequestBody OfficeUser user) {
        Integer a;
        a = officeUserService.insert(user);
        ResponseResult<Integer> rr = new ResponseResult<Integer>();
        rr.setMessage("注册成功");
        rr.setData(a);
        return rr;
    }
}