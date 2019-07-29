package com.ab.lxoa.dto;

import java.util.Date;

public class LxMemoMenuList {
    private String id;

    private String menuId;

    private String menuName;

    private String parentMenuId;

    private String parentMenuName;

    private Boolean ifRootMenu;

    private Short sequence;

    private String createUserId;

    private String createTime;

    private Byte delflag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getparentMenuId() {
        return parentMenuId;
    }

    public void setparentMenuId(String parentMenuId) {
        this.parentMenuId = parentMenuId == null ? null : parentMenuId.trim();
    }

    public String getparentMenuName() {
        return parentMenuName;
    }

    public void setparentMenuName(String parentMenuName) {
        this.parentMenuName = parentMenuName == null ? null : parentMenuName.trim();
    }

    public Boolean getIfRootMenu() {
        return ifRootMenu;
    }

    public void setIfRootMenu(Boolean ifRootMenu) {
        this.ifRootMenu = ifRootMenu;
    }

    public Short getSequence() {
        return sequence;
    }

    public void setSequence(Short sequence) {
        this.sequence = sequence;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId == null ? null : createUserId.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Byte getDelflag() {
        return delflag;
    }

    public void setDelflag(Byte delflag) {
        this.delflag = delflag;
    }
}