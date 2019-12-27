package com.jourwon.springcloud.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageMapper {

    /**
     * 扣减库存
     */
    void decrease(@Param("id") Long productId, @Param("ct") Integer count);
}
