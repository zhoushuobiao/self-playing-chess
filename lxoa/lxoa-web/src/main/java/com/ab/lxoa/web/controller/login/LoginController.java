package com.ab.lxoa.web.controller.login;

import com.ab.lxoa.common.ResultJSON;
import com.ab.lxoa.constant.CommonConstant;
import com.ab.lxoa.dto.LxMemoUser;
import com.ab.lxoa.service.LoginService;
import com.ab.lxoa.utils.redis.JedisUtils;
import com.ab.lxoa.utils.security.UserUtils;
import com.ab.lxoa.utils.token.TokenUtils;
import com.ab.lxoa.web.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

    @Autowired
    private JedisPool jedisPool;
    @Autowired
    private LoginService loginService;
    @RequestMapping("/doLogin")
    public void doLogin(@RequestParam String id, @RequestParam String password, HttpServletRequest request, HttpServletResponse response){
        //暂时不对登录做加密处理
        LxMemoUser lxMemoUser = loginService.doLogin(id,password);
        if(lxMemoUser != null){
            String token = TokenUtils.md5(password,CommonConstant.COOKIE_KEY);
            Cookie userCookie = new Cookie(CommonConstant.COOKIE_FLAG,token);
            userCookie.setMaxAge(60*60);
            userCookie.setPath("/");
            response.addCookie(userCookie);
            //后面可以提取方法到一个工具类
            jedisPool.getResource().setex((CommonConstant.TOKEN_PRE+token).getBytes(),60*60,JedisUtils.serialize(lxMemoUser));
            UserUtils.setUserInfo(lxMemoUser);
            sendJson(response,new ResultJSON());
        }else {
            sendJson(response,ResultJSON.forbidden());
        }
    }
}
