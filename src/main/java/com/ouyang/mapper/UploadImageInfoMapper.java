package com.ouyang.mapper;

import com.ouyang.model.UploadImageInfo;

public interface UploadImageInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(UploadImageInfo record);

    int insertSelective(UploadImageInfo record);

    UploadImageInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UploadImageInfo record);

    int updateByPrimaryKey(UploadImageInfo record);
}