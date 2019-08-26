package com.ab.lxoa.service;

import com.ab.lxoa.dto.ChessCardRecord;
import com.ab.lxoa.base.QueryResponse;
import com.ab.lxoa.request.CardRecordQueryRequest;
import com.ab.lxoa.request.CardRecordSaveRequest;

/**
 * 卡牌记录
 * @author zhoushuobiao
 */
public interface IChessCardRecordService {
    /**
     * 保存
     * @param request 记录数据
     */
    void saveRecord(CardRecordSaveRequest request);

    /**
     * 查询
     * @param request 请求参数
     * @return 列表
     */
    QueryResponse<ChessCardRecord> queryRecord(CardRecordQueryRequest request);
}
