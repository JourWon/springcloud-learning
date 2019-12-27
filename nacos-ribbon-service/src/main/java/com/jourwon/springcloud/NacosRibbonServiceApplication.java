package com.jourwon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Description:
 * 
 * @author JourWon
 * @date 2019/12/24 20:45
 */
@EnableDiscoveryClient
@SpringBootApplication
public class NacosRibbonServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosRibbonServiceApplication.class, args);
    }

}
