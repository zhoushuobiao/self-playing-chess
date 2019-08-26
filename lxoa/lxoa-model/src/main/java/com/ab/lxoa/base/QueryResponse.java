package com.ab.lxoa.base;

import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.util.List;

/**
 * 查询response
 * @author zhoushuobiao
 */
@Data
public class QueryResponse<T> {
    /** 总数 */
    private long total;
    /** 页数 */
    private int pages;
    /** 条数 */
    private int pageSize;
    /** 结果集 */
    private List<T> rows;

    public QueryResponse(PageInfo<T> pageInfo){
        this.total = pageInfo.getTotal();
        this.pages = pageInfo.getPages();
        this.pageSize = pageInfo.getPageSize();
        this.rows = pageInfo.getList();
    }

}
