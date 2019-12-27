package com.jourwon.springcloud.service;

import com.jourwon.springcloud.pojo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "seata-storage-service")
public interface StorageService {

    /**
     * 扣减库存
     */
    @GetMapping(value = "/storage/decrease")
    Result decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
