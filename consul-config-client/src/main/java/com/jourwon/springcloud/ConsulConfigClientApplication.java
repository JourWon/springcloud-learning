package com.jourwon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Description:
 * 
 * @author JourWon
 * @date 2019/12/22 18:27
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ConsulConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsulConfigClientApplication.class, args);
    }

}
