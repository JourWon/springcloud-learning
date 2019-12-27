package com.jourwon.springcloud.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.jourwon.springcloud.pojo.Result;
import com.jourwon.springcloud.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

/**
 * Description:
 *
 * @author JourWon
 * @date 2019/12/18 16:16
 */
@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.user-service}")
    private String userServiceUrl;

    @HystrixCommand(fallbackMethod = "fallbackMethod1")
    public Result getUser(Long id) {
        return restTemplate.getForObject(userServiceUrl + "/user/{1}", Result.class, id);
    }

    /**
     * 声明的参数需要包含controller的声明参数
     *
     * @param id
     * @return
     */
    public Result fallbackMethod1(@PathVariable Long id) {
        return new Result("服务调用失败", 500);
    }

    @HystrixCommand(fallbackMethod = "fallbackMethod2", ignoreExceptions = {NullPointerException.class})
    public Result getUserException(Long id) {
        if (id == 1) {
            throw new IndexOutOfBoundsException();
        } else if (id == 2) {
            throw new NullPointerException();
        }

        return restTemplate.getForObject(userServiceUrl + "/user/{1}", Result.class, id);
    }

    public Result fallbackMethod2(@PathVariable Long id, Throwable e) {
        LOGGER.error("id {},throwable class:{}", id, e.getClass());
        return new Result("服务调用失败", 500);
    }

    @HystrixCommand(fallbackMethod = "fallbackMethod1",
            commandKey = "getUserCommand",
            groupKey = "getUserGroup",
            threadPoolKey = "getUserThreadPool")
    public Result getUserCommand(Long id) {
        return restTemplate.getForObject(userServiceUrl + "/user/{1}", Result.class, id);
    }


    @CacheResult(cacheKeyMethod = "getCacheKey")
    @HystrixCommand(fallbackMethod = "fallbackMethod1", commandKey = "getUserCache")
    public Result getUserCache(Long id) {
        LOGGER.info("getUserCache id:{}", id);
        return restTemplate.getForObject(userServiceUrl + "/user/{1}", Result.class, id);
    }

    /**
     * 为缓存生成key的方法
     *
     * @return
     */
    public String getCacheKey(Long id) {
        return String.valueOf(id);
    }

    @HystrixCommand
    @CacheRemove(commandKey = "getUserCache", cacheKeyMethod = "getCacheKey")
    public Result removeCache(Long id) {
        LOGGER.info("removeCache id:{}", id);
        return restTemplate.postForObject(userServiceUrl + "/user/delete/{1}", null, Result.class, id);
    }

    @HystrixCollapser(batchMethod = "listUsersByIds",collapserProperties = {
            @HystrixProperty(name = "timerDelayInMilliseconds",value = "100")
    })
    public Future<User> getUserFuture(Long id) {
        return new AsyncResult<User>() {
            @Override
            public User invoke() {
                Result result = restTemplate.getForObject(userServiceUrl + "/user/{1}", Result.class, id);
                Map data = (Map) result.getData();
                User user = BeanUtil.mapToBean(data, User.class, true);
                LOGGER.info("getUserById username:{}",user.getUsername());
                return user;
            }
        };
    }

    @HystrixCommand
    public List<User> listUsersByIds(List<Long> ids) {
        LOGGER.info("listUsersByIds:{}",ids);
        Result result = restTemplate.getForObject(userServiceUrl + "/user/listUsersByIds?ids={1}", Result.class, CollUtil.join(ids, ","));
        return (List<User>)result.getData();
    }


}
