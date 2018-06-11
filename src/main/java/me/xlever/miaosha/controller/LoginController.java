package me.xlever.miaosha.controller;

import me.xlever.miaosha.redis.RedisService;
import me.xlever.miaosha.result.Result;
import me.xlever.miaosha.service.MiaoshaUserService;
import me.xlever.miaosha.vo.LoginVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/login")
public class LoginController {
    private static Logger log= LoggerFactory.getLogger(LoginController.class);
    @Autowired
    MiaoshaUserService userService;
    @Autowired
    private RedisService redisService;

    @RequestMapping("/to_login")
    public String toLogin(){
        return "login";
    }

    public Result<Boolean> doLogin(HttpServletResponse response , LoginVo loginVo){
        log.info(loginVo.toString());
        userService.login(response,loginVo);
        return Result.success(true);
    }
}
