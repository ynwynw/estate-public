package com.wy.dao;

import com.wy.model.ComplainInfo;
import com.wy.model.ComplainInfoExample;

import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ComplainInfoMapper {
    long countByExample(ComplainInfoExample example);

    int deleteByExample(ComplainInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ComplainInfo record);

    int insertSelective(ComplainInfo record);

    List<ComplainInfo> selectByExample(ComplainInfoExample example);

    ComplainInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record")
    ComplainInfo record, @Param("example")
    ComplainInfoExample example);

    int updateByExample(@Param("record")
    ComplainInfo record, @Param("example")
    ComplainInfoExample example);

    int updateByPrimaryKeySelective(ComplainInfo record);

    int updateByPrimaryKey(ComplainInfo record);
}

