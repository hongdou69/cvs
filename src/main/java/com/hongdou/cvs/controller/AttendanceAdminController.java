package com.hongdou.cvs.controller;


import com.hongdou.cvs.service.AttendanceService;
import com.hongdou.cvs.utils.CsvImportUtil;
import com.hongdou.cvs.utils.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

/**
 * @Author: HongDou
 * @Create: 2022/10/19 22:22
 * @Description:
 */


@RestController
@RequestMapping("/admin/attendance")
public class AttendanceAdminController {

    @Resource
    AttendanceService attendanceService;

    @PostMapping("/csv/import")
    public R csvImport(@RequestParam MultipartFile file){
        // 使用CSV工具类，生成file文件
        File csvFile = CsvImportUtil.uploadFile(file);
        // 将文件内容解析，存入List容器，List<String>为每一行内容的集合，2为CSV文件每行的总列数
        List<List<String>> lists = CsvImportUtil.readCSV(csvFile.getPath(), 2);
        if (lists.size()<1){
            return R.error("上传失败");
        }
        List<String> errorMsg = attendanceService.csvImport(lists);
        // 删 除文件
        csvFile.delete();
        if (errorMsg.size()==0){
            return R.ok("文件上传成功");
        }
        return R.error("上传失败");

    }
}