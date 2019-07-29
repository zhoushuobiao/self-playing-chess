package com.ab.lxoa.web.interceptor;

import com.ab.lxoa.common.HttpCodeConstant;
import com.ab.lxoa.constant.CommonConstant;
import com.ab.lxoa.dto.LxMemoUser;
import com.ab.lxoa.utils.redis.JedisUtils;
import com.ab.lxoa.utils.security.UserUtils;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 一个简单的Interceptor拦截器类
 * @author shachor
 */
@Component
public class ApiInterceptor implements HandlerInterceptor {

    @Autowired
    private JedisPool jedisPool;

    private void sendRedirect(HttpServletResponse response){
        PrintWriter writer = null;
        try {
            response.setStatus(HttpCodeConstant.TOKEN_INVALID);
            response.setContentType("application/json;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            writer = response.getWriter();
            //也可以用ServletOutputStream
            String res= "token已过期，请重新登录";
            writer.write(res);
            response.flushBuffer();
        }catch (IOException e){
            logger.info("====返回数据异常====");
        }finally {
            writer.close();
        }
    }
    private final Logger logger = LoggerFactory.getLogger(ApiInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) {

        String loginToken = null;
        if(httpServletRequest.getCookies() == null){
            this.sendRedirect(httpServletResponse);
            return false;
        }

        for(Cookie cookie : httpServletRequest.getCookies()){
            if(CommonConstant.COOKIE_FLAG.equals(cookie.getName())){
                loginToken = cookie.getValue();
            }
        }

        if(StringUtils.isNotBlank(loginToken)){
            byte[] userByte = jedisPool.getResource().get((CommonConstant.TOKEN_PRE+loginToken).getBytes());
            if(userByte != null){
                LxMemoUser user = (LxMemoUser)JedisUtils.unserialize(userByte);
                UserUtils.setUserInfo(user);
                return true;
            }
        }

        //只有返回true才会继续向下执行，返回false取消当前请求
        System.out.println("myinterc prehandler");
        this.sendRedirect(httpServletResponse);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

        System.out.println("myinterc posthandler");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

        System.out.println("myinterc aftercompletion");
    }
}