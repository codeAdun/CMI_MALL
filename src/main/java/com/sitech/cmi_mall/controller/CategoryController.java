package com.sitech.cmi_mall.controller;

import com.sitech.cmi_mall.service.ICategoryService;
import com.sitech.cmi_mall.vo.CategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 廖师兄
 */
@RestController
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/categories")
    public List<CategoryVo> selectAll() {
        return categoryService.selectAll();
    }

    //测试新增测试
}
