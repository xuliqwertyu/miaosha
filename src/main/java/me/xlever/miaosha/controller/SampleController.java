package me.xlever.miaosha.controller;

import me.xlever.miaosha.domain.User;
import me.xlever.miaosha.redis.RedisService;
import me.xlever.miaosha.redis.UserKey;
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
    public Result<User> redisGet(){
        User result = redisService.get(UserKey.getById,""+1,User.class);
        return Result.success(result);
    }

    @RequestMapping("/redis/set")
    @ResponseBody
    public Result<Boolean> redisSet(){
        User user=new User();
        user.setId(1);
        user.setName("111111");
        boolean result = redisService.set(UserKey.getById,""+1, user);
        return Result.success(result);
    }

}
