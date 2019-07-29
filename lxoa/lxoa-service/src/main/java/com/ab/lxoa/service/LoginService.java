package com.ab.lxoa.service;

import com.ab.lxoa.dto.LxMemoUser;

public interface LoginService {
    /**
     * 用户登录
     * @param id
     * @param password
     * @return
     */
    public LxMemoUser doLogin(String id, String password);
}
