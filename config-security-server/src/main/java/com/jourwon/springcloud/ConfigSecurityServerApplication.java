package com.jourwon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Description:
 * 
 * @author JourWon
 * @date 2019/12/21 15:00
 */
@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigSecurityServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigSecurityServerApplication.class, args);
    }

}
