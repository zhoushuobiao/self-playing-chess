package com.ab.lxoa.utils.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.*;

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
        return new JedisPool(config, host, Integer.parseInt(port), Integer.parseInt(timeout));
    }

    /**
     * 将对象-->byte[] (由于jedis中不支持直接存储object所以转换成byte[]存入)
     */
    public static byte[] serialize(Object object) {

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();ObjectOutputStream oos = new ObjectOutputStream(baos);){
            // 序列化
            oos.writeObject(object);
            return baos.toByteArray();
        } catch (Exception e) {
            logger.error(String.valueOf(e));
        }
        return new byte[0];
    }

    /**
     * 将byte[] -->Object
     */
    public static Object unserialize(byte[] bytes) {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
             ObjectInputStream ois = new ObjectInputStream(bais)){
            // 反序列化
            return ois.readObject();
        } catch (Exception e) {
            logger.error(String.valueOf(e));
        }
        return null;
    }

}
