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
import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyper-Li
 * @title: ExportDataController
 * @projectName office-user
 * @description: Excel表格导出
 * @date 2019.06.1.000117:22
 */
@RestController
@RequestMapping("/api/utils/excel")
public class ExportDataController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    public ExportDataController() {
        logger.info("Excel");
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
        String sheetName = "Sheet1";
        String fileName = Help.date() + "_user" + ".xls";
        ExcelUtil.exportExcel(response, excelData, sheetName, fileName, 15);
    }
}
