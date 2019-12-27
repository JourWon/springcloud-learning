package com.jourwon.springcloud.controller;

import com.jourwon.springcloud.pojo.Order;
import com.jourwon.springcloud.pojo.Result;
import com.jourwon.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 创建订单
     */
    @GetMapping("/create")
    public Result create(Order order) {
        orderService.create(order);
        return new Result<>("订单创建成功!", 200);
    }
}
