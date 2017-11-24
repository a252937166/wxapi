package com.ouyang.mapper;

import com.ouyang.model.VisitUserInfo;

public interface VisitUserInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(VisitUserInfo record);

    int insertSelective(VisitUserInfo record);

    VisitUserInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(VisitUserInfo record);

    int updateByPrimaryKey(VisitUserInfo record);
}