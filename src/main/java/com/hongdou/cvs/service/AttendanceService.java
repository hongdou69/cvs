package com.hongdou.cvs.service;

import java.util.List;

/**
 * @Author: HongDou
 * @Create: 2022/10/19 22:30
 * @Description:
 */
public interface AttendanceService {
    List<String> csvImport(List<List<String>> lists);
}
