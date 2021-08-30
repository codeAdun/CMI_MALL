package com.sitech.cmi_mall.service.impl;

import com.sitech.cmi_mall.vo.CategoryVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private  CategoryServiceImpl categoryService;

    @Test
    public void selectAll() {

        List<CategoryVo> categoryVoList=categoryService.selectAll();



    }
}