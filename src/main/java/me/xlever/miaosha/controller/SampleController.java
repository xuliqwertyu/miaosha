package me.xlever.miaosha.controller;

import me.xlever.miaosha.domain.User;
import me.xlever.miaosha.redis.RedisService;
import me.xlever.miaosha.result.CodeMsg;
import me.xlever.miaosha.result.Result;
import me.xlever.miaosha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class SampleController {

    @Autowired
    UserService userService;
    @Autowired
    RedisService redisService;

    @RequestMapping("/thymeleaf")
    public String thymeleaf(Model model){
        model.addAttribute("name","Joshua");
        return "hello";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public Result<String> hello(){
        return Result.success("helloworld");
    }
    @RequestMapping("/helloError")
    @ResponseBody
    public Result<CodeMsg> error(){
        return Result.error(CodeMsg.SERVER_ERROR);
    }

    @RequestMapping("/db/get")
    @ResponseBody
    public Result<User> dbGet(){
        User user= userService.getById(1);
        return Result.success(user);
    }

    @RequestMapping("/db/tx")
    @ResponseBody
    public boolean dbTx(){
        return userService.tx();
    }

    @RequestMapping("/redis/get")
    @ResponseBody
    public Result<Long> redisGet(){
        Long result = redisService.get("key1", Long.class);
        return Result.success(result);
    }

    @RequestMapping("/redis/set")
    @ResponseBody
    public Result<Boolean> redisSet(){
        boolean result = redisService.set("key2", "test");
        return Result.success(result);
    }

    @RequestMapping("/redis/set2")
    @ResponseBody
    public Result<Boolean> redisSetPrex(){
        boolean result = redisService.set("key2", "test");
        return Result.success(result);
    }
}
