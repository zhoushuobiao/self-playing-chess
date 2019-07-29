package com.ab.lxoa.utils.redis;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class JedisUtils {

    @Value("${redis.pool.maxActive}")
    private String maxActive;
    @Value("${redis.pool.maxIdle}")
    private String maxIdle;
    @Value("${redis.pool.minIdle}")
    private String minIdle;
    @Value("${redis.pool.maxWait}")
    private String maxWait;
    @Value("${redis.host}")
    private String host;
    @Value("${redis.port}")
    private String port;
    @Value("${redis.timeout}")
    private String timeout;

    private static Logger logger = LoggerFactory.getLogger(JedisUtils.class);

    @Bean
    public JedisPool initJedisPool(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(Integer.parseInt(maxActive));
        config.setMaxIdle(Integer.parseInt(maxIdle));
        config.setMinIdle(Integer.parseInt(minIdle));
        config.setMaxWaitMillis(Integer.parseInt(maxWait));
        config.setTestOnBorrow(true);
        config.setTestOnReturn(true);
        config.setTestWhileIdle(true);

        JedisPool jedisPool = new JedisPool(config, host, Integer.parseInt(port), Integer.parseInt(timeout));
        return jedisPool;
    }

    /**
     * 将对象-->byte[] (由于jedis中不支持直接存储object所以转换成byte[]存入)
     *
     * @param object
     * @return
     */
    public static byte[] serialize(Object object) {
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
            // 序列化
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            byte[] bytes = baos.toByteArray();
            return bytes;
        } catch (Exception e) {
            logger.error("{}", e);
        } finally {
            try {
                oos.close();
                baos.close();
            } catch (IOException e) {
                logger.error("{}", e);
            }
        }
        return null;
    }

    /**
     * 将byte[] -->Object
     *
     * @param bytes
     * @return
     */
    public static Object unserialize(byte[] bytes) {
        ByteArrayInputStream bais = null;
        try {
            // 反序列化
            bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {
            logger.error("{}", e);
        } finally {
            try {
                bais.close();
            } catch (IOException e) {
                logger.error("{}", e);
            }
        }
        return null;
    }

}
