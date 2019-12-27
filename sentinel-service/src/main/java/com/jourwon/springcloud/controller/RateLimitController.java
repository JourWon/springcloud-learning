package com.jourwon.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.jourwon.springcloud.handler.CustomBlockHandler;
import com.jourwon.springcloud.pojo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author JourWon
 * @date 2019/12/24 22:10
 */
@RestController
@RequestMapping("/rateLimit")
public class RateLimitController {

    /**
     * 按资源名称限流，需要指定限流处理逻辑
     *
     * @return
     */
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public Result byResource() {
        return new Result("按资源名称限流", 200);
    }

    /**
     * 按url限流，有默认的限流处理逻辑
     *
     * @return
     */
    @GetMapping("byUrl")
    @SentinelResource(value = "byUrl", blockHandler = "handleException")
    public Result byUrl() {
        return new Result("按url限流", 200);
    }

    public Result handleException(BlockException exception) {
        return new Result(exception.getClass().getCanonicalName(), 200);
    }

    @GetMapping("/customBlockHandler")
    @SentinelResource(value = "customBlockHandler", blockHandler = "handleException", blockHandlerClass = CustomBlockHandler.class)
    public Result blockHandler() {
        return new Result("限流成功", 200);
    }


}
