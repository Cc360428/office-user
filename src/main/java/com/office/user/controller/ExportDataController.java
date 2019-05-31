package com.office.user.controller;

import com.office.user.utils.ExcelUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/utils/excel")
public class ExportDataController {
    /**
     * Excel表格导出接口
     * http://localhost:8080/ExcelDownload
     * @param response response对象
     * @throws IOException 抛IO异常
     */
    @PostMapping("/download")
    public void excelDownload(HttpServletResponse response) throws IOException {

        List<List<String>> excelData = new ArrayList<>();

        List<String> head = new ArrayList<>();
        head.add("第一列");
        head.add("第二列");
        head.add("第三列");

        List<String> data1 = new ArrayList<>();
        data1.add("123");
        data1.add("234");
        data1.add("345");

        List<String> data2 = new ArrayList<>();
        data2.add("abc");
        data2.add("bcd");
        data2.add("cde");

        excelData.add(head);
        excelData.add(data1);
        excelData.add(data2);

        String sheetName = "测试";
        String fileName = "ExcelTest.xls";

        ExcelUtil.exportExcel(response, excelData, sheetName, fileName, 15);
    }


}
