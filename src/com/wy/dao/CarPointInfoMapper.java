package com.wy.dao;

import com.wy.model.CarPointInfo;
import com.wy.model.CarPointInfoExample;

import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface CarPointInfoMapper {
    long countByExample(CarPointInfoExample example);

    int deleteByExample(CarPointInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CarPointInfo record);

    int insertSelective(CarPointInfo record);

    List<CarPointInfo> selectByExample(CarPointInfoExample example);

    CarPointInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record")
    CarPointInfo record, @Param("example")
    CarPointInfoExample example);

    int updateByExample(@Param("record")
    CarPointInfo record, @Param("example")
    CarPointInfoExample example);

    int updateByPrimaryKeySelective(CarPointInfo record);

    int updateByPrimaryKey(CarPointInfo record);
}

