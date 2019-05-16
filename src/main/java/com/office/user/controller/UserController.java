package com.office.user.controller;

import com.office.user.entity.OfficeUser;
import com.office.user.service.OfficeUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RequestMapping("office/user")
@RestController
public class UserController {
    @Resource
    private OfficeUserService officeUserService;

    @PostMapping("/reg")
    public Integer reg(@RequestBody OfficeUser officeUser) {
        Integer s;
        s = 10;
        Integer userId = officeUserService.insert(officeUser);
        return s;
    }
}