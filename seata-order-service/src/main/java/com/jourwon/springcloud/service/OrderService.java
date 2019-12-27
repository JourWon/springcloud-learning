package com.jourwon.springcloud.service;


import com.jourwon.springcloud.pojo.Order;

public interface OrderService {

    /**
     * 创建订单
     */
    void create(Order order);
}
