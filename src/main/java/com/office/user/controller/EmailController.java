package com.office.user.controller;


import com.office.user.entity.EmailUtil;
import com.office.user.utils.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Hyper-Li
 * @title: EmailController
 * @projectName office-user
 * @description: 邮箱
 * @date 2019.06.22.002215:40
 */
@RestController
@RequestMapping("/api/email")
public class EmailController {
    private static Logger logger = LoggerFactory.getLogger(EmailController.class);

    public EmailController() {
        logger.info("邮箱验证码接口");
    }

    @RequestMapping("/code")
    public ResponseResult<Void> emailCode(@RequestBody EmailUtil email) {
        logger.info("接收参数：" + email.getMeail());
        ResponseResult<Void> rr = new ResponseResult<>();
        return rr;
    }
}
