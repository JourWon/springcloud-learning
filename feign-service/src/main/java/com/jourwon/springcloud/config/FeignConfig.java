package com.jourwon.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description:
 *
 * @author JourWon
 * @date 2019/12/20 18:39
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level level() {
        return Logger.Level.FULL;
    }

}
