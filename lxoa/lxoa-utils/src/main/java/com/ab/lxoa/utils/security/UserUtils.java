package com.ab.lxoa.utils.security;

import com.ab.lxoa.dto.LxMemoUser;
import org.springframework.util.Assert;

public class UserUtils {
    public static ThreadLocal local = new ThreadLocal();

    public static LxMemoUser getUserInfo(){
        if (local.get() == null) {
            LxMemoUser user = new LxMemoUser();
            local.set(user);
            return user;
        } else {
            return (LxMemoUser)local.get();
        }
    }

    public static void setUserInfo(LxMemoUser user){
            Assert.notNull(user, "Only non-null Authentication instances are permitted");
            local.set(user);
    }
}