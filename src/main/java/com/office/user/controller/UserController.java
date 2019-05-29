package com.office.user.controller;

import com.office.user.entity.OfficeUser;
import com.office.user.service.OfficeUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("office/user")
public class UserController {
    @Resource
    private OfficeUserService officeUserService;

    public UserController() {
        System.out.println("asdfasdfasdf");
    }

    @PostMapping("/reg")
    public Integer reg(OfficeUser user) {
        int a ;
        a = officeUserService.insert(user);
        return a;
    }
}