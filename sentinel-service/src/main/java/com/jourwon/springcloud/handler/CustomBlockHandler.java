package com.jourwon.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.jourwon.springcloud.pojo.Result;

/**
 * Description:
 *
 * @author JourWon
 * @date 2019/12/25 9:40
 */
public class CustomBlockHandler {

    public Result handleException(BlockException exception) {
        return new Result("自定义限流信息", 200);
    }

}
