package com.ab.lxoa.web.controller.menu;

import com.ab.lxoa.common.ResultJSON;
import com.ab.lxoa.dto.LxMemoMenuList;
import com.ab.lxoa.dto.LxMemoNoteList;
import com.ab.lxoa.service.MenuService;
import com.ab.lxoa.service.NoteService;
import com.ab.lxoa.web.controller.base.BaseController;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shachor
 * @date 2018/12/20 16:36
 */
@RestController
@RequestMapping("/menu")
public class MenuController extends BaseController{
    @Autowired
    private MenuService menuService;
    @Autowired
    private NoteService noteService;

    private int i =0;
    /**
     * 获取目录下全部菜单栏
     */
    @GetMapping("/getMenuList")
    public void getProjectList(String menuId,HttpServletResponse response){
            System.out.println("==================="+(i++));
        List<LxMemoMenuList> menuList = menuService.getMenuListByMenuId(menuId,"18202795228");
        List<LxMemoNoteList> noteList = noteService.getNoteListByMenuId(menuId,"18202795228");
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("menuList",menuList);
        resultMap.put("noteList",noteList);
        sendJson(response,new ResultJSON(resultMap));
    }

    /**
     * 更新菜单栏
     */
    @PostMapping(value = "/updateMenuList")
    public void updateMenuList(String menuList,HttpServletRequest request,HttpServletResponse response){
        List<LxMemoMenuList> updateMenuList = JSONArray.parseArray(menuList, LxMemoMenuList.class);
        if(menuService.updateMenu(updateMenuList) >0){
            sendJson(response,new ResultJSON());
        }else {
            sendJson(response,ResultJSON.forbidden());
        }
    }


}
