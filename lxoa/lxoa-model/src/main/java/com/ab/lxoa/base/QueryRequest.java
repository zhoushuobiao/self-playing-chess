package com.ab.lxoa.base;


import lombok.Data;

/**
 * 查询请求
 * @author zhoushuobiao
 */
@Data
public class QueryRequest {
    /** 页数 */
    private int page = 1;
    /** 每页条数 */
    private int pageSize = 20;
}
