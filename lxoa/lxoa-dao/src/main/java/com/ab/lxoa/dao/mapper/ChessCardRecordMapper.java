package com.ab.lxoa.dao.mapper;

import com.ab.lxoa.dto.ChessCardRecord;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 卡牌记录Mapper
 * @author zhoushuobiao
 */
@Component
public interface ChessCardRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(ChessCardRecord record);

    ChessCardRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChessCardRecord record);

    int updateByPrimaryKey(ChessCardRecord record);

    List<ChessCardRecord> queryCardByParam(ChessCardRecord request);

    int addCardRecord(ChessCardRecord record);
}