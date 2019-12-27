package com.jourwon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Description:
 * 
 * @author JourWon
 * @date 2019/12/25 9:37
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class SentinelServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentinelServiceApplication.class, args);
    }

}
