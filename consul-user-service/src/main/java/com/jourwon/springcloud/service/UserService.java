package com.jourwon.springcloud.service;

import com.jourwon.springcloud.pojo.User;

import java.util.List;

/**
 * Description:
 *
 * @author JourWon
 * @date 2019/12/18 14:06
 */
public interface UserService {

    void insert(User user);

    User getUser(Long id);

    void update(User user);

    void delete(Long id);

    User getByUsername(String username);

    List<User> listUsersByIds(List<Long> ids);

}
