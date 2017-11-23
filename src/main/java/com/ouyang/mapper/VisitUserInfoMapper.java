package com.ouyang.mapper;

import com.ouyang.model.VisitUserInfo;

public interface VisitUserInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(VisitUserInfo record);

    int insertSelective(VisitUserInfo record);

    VisitUserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VisitUserInfo record);

    int updateByPrimaryKey(VisitUserInfo record);
}