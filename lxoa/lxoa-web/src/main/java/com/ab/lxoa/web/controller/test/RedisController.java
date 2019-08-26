package com.ab.lxoa.web.controller.test;

import com.ab.lxoa.base.ResultJSON;
import com.ab.lxoa.web.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/redis")
public class RedisController extends BaseController {

    private int i = 0;

    private List<String> list = new ArrayList<>();

    @Autowired
    private JedisPool jedisPool;

    @RequestMapping("/getRedis")
    public void getRedis(HttpServletResponse response){
        i++;
        list.add(""+i);
        System.out.println("================ "+i);
        Jedis jedis = jedisPool.getResource();
        sendJson(response,new ResultJSON(jedis.get("test")));
    }

    @RequestMapping("/setRedis")
    public void setRedis(HttpServletResponse response){

        Jedis jedis = jedisPool.getResource();
        jedis.set("test","a1");
        sendJson(response,new ResultJSON());
    }
}
