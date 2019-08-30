package com.ab.lxoa.dto;

import lombok.Data;

import java.util.Date;

@Data
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


}