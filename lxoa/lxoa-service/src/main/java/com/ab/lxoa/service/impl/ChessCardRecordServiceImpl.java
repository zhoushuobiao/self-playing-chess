package com.ab.lxoa.service.impl;

import com.ab.lxoa.dao.mapper.ChessCardRecordMapper;
import com.ab.lxoa.dto.ChessCardRecord;
import com.ab.lxoa.service.IChessCardRecordService;
import com.ab.lxoa.base.QueryResponse;
import com.ab.lxoa.request.CardRecordQueryRequest;
import com.ab.lxoa.request.CardRecordSaveRequest;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 卡牌记录service
 * @author zhoushuobiao
 */
@Service
public class ChessCardRecordServiceImpl implements IChessCardRecordService {
    private final ChessCardRecordMapper chessCardRecordMapper;

    public ChessCardRecordServiceImpl(ChessCardRecordMapper chessCardRecordMapper) {
        this.chessCardRecordMapper = chessCardRecordMapper;
    }

    @Override
    public void saveRecord(CardRecordSaveRequest request) {
        chessCardRecordMapper.addCardRecord(request.convert());
    }

    @Override
    public QueryResponse<ChessCardRecord> queryRecord(CardRecordQueryRequest request) {
        PageHelper.startPage(request.getPage(),request.getPageSize());
        List<ChessCardRecord> cardList = chessCardRecordMapper.queryCardByParam(request.convert());
        return new QueryResponse<>(new PageInfo<>(cardList));
    }
}
