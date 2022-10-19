package com.hongdou.cvs.service.impl;

import com.hongdou.cvs.mapper.CvsMapper;
import com.hongdou.cvs.pojo.Phone;
import com.hongdou.cvs.service.AttendanceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: HongDou
 * @Create: 2022/10/19 22:40
 * @Description:
 */
@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Resource
    CvsMapper cvsMapper;
    @Override
    public List<String> csvImport(List<List<String>> lists) {
        for (List<String> list : lists) {
            String s = list.get(1);
            Phone phone=new Phone();
                long phoneNumber = Long.parseLong(s);
                phone.setPhoneNumber(phoneNumber);
                cvsMapper.savePhone(phone);
        }
        List<String> list=new ArrayList<>();
        return list;
    }
}
