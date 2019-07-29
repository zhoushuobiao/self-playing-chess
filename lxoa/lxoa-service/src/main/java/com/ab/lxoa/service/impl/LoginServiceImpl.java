package com.ab.lxoa.service.impl;

import com.ab.lxoa.dao.mapper.LxMemoUserMapper;
import com.ab.lxoa.dto.LxMemoUser;
import com.ab.lxoa.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LxMemoUserMapper lxMemoUserMapper;

    @Override
    public LxMemoUser doLogin(String id, String password) {
        return lxMemoUserMapper.validLogin(id,password);
    }
}
