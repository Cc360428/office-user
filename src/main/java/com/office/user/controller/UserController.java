package com.office.user.controller;

import com.office.user.entity.Login;
import com.office.user.entity.User;
import com.office.user.service.UserService;
import com.office.user.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/api/user")
@Api(value = "用户操作接口", tags = {"用户操作接口"})
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController() {
        logger.info("User");
    }

    @Resource
    private UserService userService;

    @ApiOperation(value = "添加用户", notes = "test")
    @PostMapping("/reg")
    public ResponseResult<Integer> reg(@RequestBody User user) {
        logger.info("注册开始 user = {}", user.toString());
        user.setCreateName(user.getAccount());
        user.setIsDelete(1);
        Integer a = userService.reg(user);
        ResponseResult<Integer> rr = new ResponseResult<>();
        rr.setMessage("注册成功");
        logger.info("注册结束");
        rr.setData(a);
        return rr;
    }

    @PostMapping("/all")
    public ResponseResult<List<User>> userAll() {
        logger.info("获取所有数据");
        ResponseResult<List<User>> rr = new ResponseResult<>();
        rr.setData(userService.userAll());
        rr.setMessage("成功！");
        logger.info("获取所有数据成功！");
        return rr;
    }

    /**
     * 登录接口
     * @param login 登录参数
     * @return
     */
    @PostMapping("/login")
    public ResponseResult<String> login(@RequestBody Login login) {
        ResponseResult<String> rr = new ResponseResult<>();
        logger.info("获取登录参数："+login.toString());
        rr.setData("login.toString()");
        rr.setMessage("登录成功！");
        logger.info("获取所有数据成功！");
        return rr;
    }
}