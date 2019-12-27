package com.jourwon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Description:
 * 
 * @author JourWon
 * @date 2019/12/18 10:49
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaSecurityServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaSecurityServerApplication.class, args);
    }

}
