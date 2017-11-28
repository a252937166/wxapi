package com.ouyang.mapper;

import com.ouyang.model.UploadImageInfo;

public interface UploadImageInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UploadImageInfo record);

    int insertSelective(UploadImageInfo record);

    UploadImageInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UploadImageInfo record);

    int updateByPrimaryKeyWithBLOBs(UploadImageInfo record);

    int updateByPrimaryKey(UploadImageInfo record);
}