package com.jourwon.springcloud;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Description:
 * 
 * @author JourWon
 * @date 2019/12/23 14:00
 */
@EnableAdminServer
@EnableDiscoveryClient
@SpringBootApplication
public class AdminSecurityServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminSecurityServerApplication.class, args);
    }

}
