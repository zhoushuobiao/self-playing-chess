package com.ab.lxoa.dao.mapper;

import com.ab.lxoa.dto.LxMemoMenuList;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface LxMemoMenuListMapper {
    int deleteByMenuId(String id);

    int addMenu(LxMemoMenuList record);

    int insertSelective(LxMemoMenuList record);

    LxMemoMenuList selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(LxMemoMenuList record);

    int updateByPrimaryKey(LxMemoMenuList record);

    List<LxMemoMenuList> getMenuListByMenuId(@Param("menuId") String menuId, @Param("userId") String userId);

    int batchUpdateMenu(List<LxMemoMenuList> list);
}