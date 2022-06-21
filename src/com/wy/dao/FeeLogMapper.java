package com.wy.dao;

import com.wy.model.FeeLog;
import com.wy.model.FeeLogExample;

import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface FeeLogMapper {
    long countByExample(FeeLogExample example);

    int deleteByExample(FeeLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FeeLog record);

    int insertSelective(FeeLog record);

    List<FeeLog> selectByExample(FeeLogExample example);

    FeeLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record")
    FeeLog record, @Param("example")
    FeeLogExample example);

    int updateByExample(@Param("record")
    FeeLog record, @Param("example")
    FeeLogExample example);

    int updateByPrimaryKeySelective(FeeLog record);

    int updateByPrimaryKey(FeeLog record);
}

