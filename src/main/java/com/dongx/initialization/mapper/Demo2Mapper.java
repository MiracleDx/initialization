package com.dongx.initialization.mapper;

import com.dongx.initialization.entity.Demo2;

public interface Demo2Mapper {
    int deleteByPrimaryKey(Long id);

    int insert(Demo2 record);

    int insertSelective(Demo2 record);

    Demo2 selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Demo2 record);

    int updateByPrimaryKey(Demo2 record);
}