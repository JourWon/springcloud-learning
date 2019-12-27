package com.jourwon.springcloud.controller;


import com.jourwon.springcloud.pojo.Result;
import com.jourwon.springcloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/storage")
public class StorageController {

    @Autowired
    private StorageService storageService;

    /**
     * 扣减库存
     */
    @RequestMapping("/decrease")
    public Result decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return new Result("扣减库存成功！",200);
    }
}
