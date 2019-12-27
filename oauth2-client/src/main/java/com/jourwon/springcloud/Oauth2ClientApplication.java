package com.jourwon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

/**
 * Description: 在启动类上添加@EnableOAuth2Sso注解来启用单点登录功能
 * 
 * @author JourWon
 * @date 2019/12/24 14:42
 */
@EnableOAuth2Sso
@SpringBootApplication
public class Oauth2ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2ClientApplication.class, args);
    }

}
