package com.ouyang.service;

import com.ouyang.mapper.VisitUserInfoMapper;
import com.ouyang.model.VisitUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Package: com.ouyang.service
 *
 * @Author: Ouyang
 * @Date: 2017/11/23
 */
@Service
public class VisitUserInfoService {
    @Autowired
    VisitUserInfoMapper visitUserInfoMapper;
    public Integer add(VisitUserInfo visitUserInfo) {
        return visitUserInfoMapper.insertSelective(visitUserInfo);
    }

    public void test() {
        System.out.println("service test");
    }
}
