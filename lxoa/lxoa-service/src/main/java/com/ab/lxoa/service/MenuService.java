package com.ab.lxoa.service;

import com.ab.lxoa.dto.LxMemoMenuList;

import java.util.List;

/**
 * 菜单栏service
 */
public interface MenuService {

    /**
     * 通过用户id以及menuId获取全部菜单
     * @param menuId
     * @param userId
     * @return
     */
    List<LxMemoMenuList> getMenuListByMenuId(String menuId,String userId);

    /**
     * 根据用户id添加菜单栏
     * @param lxMemoMenuList
     * @return
     */
    int addMenu(LxMemoMenuList lxMemoMenuList);

    /**
     * 根据菜单id删除菜单栏
     * @param menuId
     * @return
     */
    int deleteMenuByMenuId(String menuId);

    /**
     * 批量修改菜单信息
     * @param menuList
     * @return
     */
    int updateMenu(List<LxMemoMenuList> menuList);
}
