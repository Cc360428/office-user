package com.office.user.Controller;

import com.office.user.entity.OfficeUser;
import com.office.user.service.OfficeUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/office/user")
public class UserController {
    @Resource
    private OfficeUserService officeUserService;

    @PostMapping
    public Integer reg(@RequestBody OfficeUser officeUser) {
        Integer userId = officeUserService.insert(officeUser);
        return userId;
    }


}