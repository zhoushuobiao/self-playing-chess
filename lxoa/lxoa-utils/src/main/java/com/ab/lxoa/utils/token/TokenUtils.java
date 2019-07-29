package com.ab.lxoa.utils.token;

import org.apache.commons.codec.digest.DigestUtils;

public class TokenUtils {

    /**
     * 生成MD5密文
     * @param content
     * @param key
     * @return
     */
    public static String md5(String content,String key){
        //加密后的字符串
        String encodeStr=DigestUtils.md5Hex(content + key);
        System.out.println("MD5加密后的字符串为:encodeStr="+encodeStr);
        return encodeStr;
    }
}
