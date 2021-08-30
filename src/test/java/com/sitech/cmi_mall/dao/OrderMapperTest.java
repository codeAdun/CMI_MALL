package com.sitech.cmi_mall.dao;

import com.sitech.cmi_mall.pojo.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMapperTest {

    @Autowired
    private  OrderMapper orderMapper;

    @Test
    public void insert() {
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByPrimaryKey() {     

        Order order=orderMapper.selectByPrimaryKey(10001);
        System.out.println(order.toString());
    }
}