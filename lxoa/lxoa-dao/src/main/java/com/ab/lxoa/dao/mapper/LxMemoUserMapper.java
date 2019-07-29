package com.ab.lxoa.dao.mapper;

import com.ab.lxoa.dto.LxMemoUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface LxMemoUserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(LxMemoUser record);

    int insertSelective(LxMemoUser record);

    LxMemoUser selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(LxMemoUser record);

    int updateByPrimaryKey(LxMemoUser record);

    LxMemoUser validLogin(@Param("phone") String phone, @Param("password")String password);
}