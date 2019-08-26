package com.ab.lxoa.dto;

import java.util.Date;

public class ChessCardRecord {
    private Integer id;

    private Byte bigField;

    private Byte smallField;

    private Byte levels;

    private Byte population;

    private Short role1;

    private Short role2;

    private Short role3;

    private Short role4;

    private Integer createId;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getBigField() {
        return bigField;
    }

    public void setBigField(Byte bigField) {
        this.bigField = bigField;
    }

    public Byte getSmallField() {
        return smallField;
    }

    public void setSmallField(Byte smallField) {
        this.smallField = smallField;
    }

    public Byte getLevels() {
        return levels;
    }

    public void setLevels(Byte levels) {
        this.levels = levels;
    }

    public Byte getPopulation() {
        return population;
    }

    public void setPopulation(Byte population) {
        this.population = population;
    }

    public Short getRole1() {
        return role1;
    }

    public void setRole1(Short role1) {
        this.role1 = role1;
    }

    public Short getRole2() {
        return role2;
    }

    public void setRole2(Short role2) {
        this.role2 = role2;
    }

    public Short getRole3() {
        return role3;
    }

    public void setRole3(Short role3) {
        this.role3 = role3;
    }

    public Short getRole4() {
        return role4;
    }

    public void setRole4(Short role4) {
        this.role4 = role4;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}