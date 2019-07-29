package com.ab.lxoa.constant;

/**
 * @author shachor
 * @date 2018/12/27 16:18
 */
public class CommonConstant {
    /**
     * cookie_id标志
     */
    public static final String COOKIE_FLAG = "lx_cookie_id";

    /**
     * cookie加密密钥
     */
    public static final String COOKIE_KEY = "lx_cookie_key";

    /**
     * redis加密密钥
     */
    public static final String REDIS_KEY = "lx_redis_key";

    /**
     * 前端登录token
     */
    public static final String LOGIN_TOKEN = "token";
    /**
     * redis中token的前缀标志
     */
    public static final String TOKEN_PRE = "lx_token:";
    /**
     * 空数据
     */
    public static final String NONE_DATA = "无";

    private CommonConstant(){}
}
