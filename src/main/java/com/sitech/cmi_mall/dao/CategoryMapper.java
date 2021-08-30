package com.sitech.cmi_mall.dao;

import com.sitech.cmi_mall.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    List<Category> selectAll();
}