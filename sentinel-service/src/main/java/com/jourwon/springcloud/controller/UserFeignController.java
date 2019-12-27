package com.jourwon.springcloud.controller;

import com.jourwon.springcloud.pojo.Result;
import com.jourwon.springcloud.pojo.User;
import com.jourwon.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Description:
 *
 * @author JourWon
 * @date 2019/12/25 13:54
 */
@RestController
@RequestMapping("/user")
public class UserFeignController {

    @Autowired
    private UserService userService;

    @PostMapping("/insert")
    public Result insert(@RequestBody User user) {
        return userService.insert(user);
    }

    @GetMapping("/{id}")
    public Result<User> getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping("/listUsersByIds")
    public Result<List<User>> listUsersByIds(@RequestParam List<Long> ids) {
        return userService.listUsersByIds(ids);
    }

    @GetMapping("/getByUsername")
    public Result<User> getByUsername(@RequestParam String username) {
        return userService.getByUsername(username);
    }

    @PostMapping("/update")
    public Result update(@RequestBody User user) {
        return userService.update(user);
    }

    @PostMapping("/delete/{id}")
    public Result delete(@PathVariable Long id) {
        return userService.delete(id);
    }

}
