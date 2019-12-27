package com.jourwon.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Description:
 * 
 * @author JourWon
 * @date 2019/12/25 17:24
 */
@EnableFeignClients
@EnableDiscoveryClient
@MapperScan(basePackages = {"com.jourwon.springcloud.mapper"})
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SeataAccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataAccountServiceApplication.class, args);
    }

}
