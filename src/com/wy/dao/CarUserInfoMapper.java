package com.wy.dao;

import com.wy.model.CarUserInfo;
import com.wy.model.CarUserInfoExample;

import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface CarUserInfoMapper {
    long countByExample(CarUserInfoExample example);

    int deleteByExample(CarUserInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CarUserInfo record);

    int insertSelective(CarUserInfo record);

    List<CarUserInfo> selectByExample(CarUserInfoExample example);

    CarUserInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record")
    CarUserInfo record, @Param("example")
    CarUserInfoExample example);

    int updateByExample(@Param("record")
    CarUserInfo record, @Param("example")
    CarUserInfoExample example);

    int updateByPrimaryKeySelective(CarUserInfo record);

    int updateByPrimaryKey(CarUserInfo record);
}

