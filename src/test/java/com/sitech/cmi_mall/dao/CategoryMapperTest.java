package com.sitech.cmi_mall.dao;

import com.sitech.cmi_mall.pojo.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryMapperTest {

    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    public void queryById() {

    Category category=categoryMapper.selectByPrimaryKey(100001);
        System.out.println(category.toString());

    }

    @Test
    public void selectAll(){
        List<Category> category=categoryMapper.selectAll();
        category.toString();
    }
}