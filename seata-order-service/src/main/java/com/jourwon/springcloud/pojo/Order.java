package com.jourwon.springcloud.pojo;


import lombok.Data;

import java.math.BigDecimal;

/**
 * Description:
 * 
 * @author JourWon
 * @date 2019/12/25 16:28
 */
@Data
public class Order {

    private Long id;

    private Long userId;

    private Long productId;

    private Integer count;

    private BigDecimal money;

    /**
     * 订单状态：0：创建中；1：已完结
     */
    private Integer status;

}
