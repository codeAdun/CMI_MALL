package com.sitech.cmi_mall.service;


import com.sitech.cmi_mall.pojo.Category;
import com.sitech.cmi_mall.vo.CategoryVo;

import java.util.List;

/*
* 查询类目：
* */
public interface ICategoryService {

    List<CategoryVo> selectAll();

    int updateByPrimaryKey(Category record);

}
