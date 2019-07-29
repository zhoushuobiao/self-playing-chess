package com.ab.lxoa.service.impl;

import com.ab.lxoa.dao.mapper.LxMemoMenuListMapper;
import com.ab.lxoa.dto.LxMemoMenuList;
import com.ab.lxoa.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private LxMemoMenuListMapper lxMemoMenuListMapper;
    /**
     * 通过用户id获取全部菜单
     */
    @Override
    public List<LxMemoMenuList> getMenuListByMenuId(String menuId,String userId) {
        return lxMemoMenuListMapper.getMenuListByMenuId(menuId,userId);
    }

    /**
     * 根据用户id添加菜单栏
     */
    @Override
    public int addMenu(LxMemoMenuList lxMemoMenuList) {
        return lxMemoMenuListMapper.addMenu(lxMemoMenuList);
    }

    /**
     * 根据菜单id以及用户id删除菜单栏
     */
    @Override
    public int deleteMenuByMenuId(String menuId) {
        return lxMemoMenuListMapper.deleteByMenuId(menuId);
    }

    /**
     * 批量修改菜单信息
     */
    @Override
    public int updateMenu(List<LxMemoMenuList> menuList) {
        return lxMemoMenuListMapper.batchUpdateMenu(menuList);
    }
}
