package com.ouyang.service;

import com.ouyang.mapper.UploadImageInfoMapper;
import com.ouyang.model.UploadImageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Package: com.ouyang.service
 *
 * @Author: Ouyang
 * @Date: 2017/11/23
 */
@Service
public class UploadImageInfoService {
    @Autowired
    UploadImageInfoMapper uploadImageInfoMapper;

    public Integer add(UploadImageInfo uploadImageInfo) {
        return uploadImageInfoMapper.insertSelective(uploadImageInfo);
    }

}
