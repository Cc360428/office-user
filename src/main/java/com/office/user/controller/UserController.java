package com.office.user.controller;

import com.office.user.annotation.UserLoginToken;
import com.office.user.entity.Login;
import com.office.user.entity.User;
import com.office.user.service.TokenServer;
import com.office.user.service.UserService;
import com.office.user.utils.Help;
import com.office.user.utils.RedisUtil;
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
import java.util.Date;
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
        user.setCreateTime(new Date());
        Integer a = userService.reg(user);
        ResponseResult<Integer> rr = new ResponseResult<>();
        rr.setMessage("注册成功");
        logger.info("注册结束");
        rr.setData(a);
        return rr;
    }

    //使用token判断用户是登录
    @UserLoginToken
    @PostMapping("/all")
    public ResponseResult<List<User>> userAll() {
        logger.info("获取所有数据");
        ResponseResult<List<User>> rr = new ResponseResult<>();
        rr.setData(userService.userAll());
        rr.setMessage("成功！");
        logger.info("获取所有数据成功！");
        return rr;
    }

    @Resource
    private RedisUtil redisUtil;
    @Resource
    private TokenServer tokenServer;


    /**
     * 登录接口
     *
     * @param login 登录参数
     * @return
     */
    @PostMapping("/login")
    public ResponseResult<String> login(@RequestBody Login login) {
        ResponseResult<String> rr = new ResponseResult<>();
        String account = login.getAccount();
        //判断用户名是否存在
        User user = userService.getOneByAccount(account);
        if (user == null) {
            rr.fail("没有用户名", null);
            return rr;
        }
        //判断两次输入的密码是否一致
        if (!login.getPassword().equals(login.getConfirmPassword())) {
            rr.fail("两次输入的密码不一致！", null);
            return rr;
        }
        //判断用户名密码是否正确
        //操作明文，与数据库的密码比较
        String lPassword = Help.getMD5(login.getConfirmPassword());
        String p = Help.encrypt(lPassword, user.getSalt());
        if (!p.equals(user.getPassword())) {
            rr.fail("密码输出错误，登录失败!", null);
            return rr;
        }
        //生成token 登录成共保存token
        String token = tokenServer.getToken(user);
////
//        redisUtil.setKey("redis", token);

        // TODO 测试redis
        rr.success("登录成功", token);
        //登录成功发送token
        //把token 保存到redis中
        return rr;
    }


}