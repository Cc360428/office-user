package com.office.user.controller;

import com.office.user.entity.User;
import com.office.user.service.UserService;
import com.office.user.utils.ExcelUtil;
import com.office.user.utils.Help;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/utils/excel")
public class ExportDataController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    public ExportDataController() {
        logger.info("进入此类");
    }

    /**
     * Excel表格导出接口
     *
     * @param response response对象
     * @throws IOException 抛IO异常
     */
    @GetMapping("/download")
    public void excelDownload(HttpServletResponse response) throws IOException {
        List<User> user = userService.userAll();
        List<List<String>> excelData = new ArrayList<>();
//        设置excel表头
        List<String> head = new ArrayList<>();
        head.add("id");
        head.add("account");
        head.add("mobile");
        head.add("email");
        excelData.add(head);
//       遍历数据库查询的数据
        for (int i = 0; i < user.size(); i++) {
            List<String> a = new ArrayList<>();
            a.add(user.get(i).getId().toString());
            a.add(user.get(i).getAccount());
            a.add(user.get(i).getMobile());
            a.add(user.get(i).getEmail());
            excelData.add(a);
        }
//        设置工作谱
        String sheetName = "Sheet1";

        String fileName = Help.date() + "_user" + ".xls";
        ExcelUtil.exportExcel(response, excelData, sheetName, fileName, 15);
    }


}
