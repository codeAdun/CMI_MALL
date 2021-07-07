package com.sitech.cmi_mall.dao;

import com.sitech.cmi_mall.pojo.Order;
import org.apache.ibatis.annotations.Mapper;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);




    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}