package com.ab.lxoa.request;


import com.ab.lxoa.dto.ChessCardRecord;
import com.ab.lxoa.base.QueryRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 卡牌记录request
 * @author zhoushuobiao
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CardRecordQueryRequest extends QueryRequest {
    /** 卡牌id */
    private Short cardId;
    /** 大局 */
    private Byte bigField;
    /** 小局 */
    private Byte smallField;
    /** 等级 */
    private Byte levels;
    /** 人口 */
    private Byte population;

    /** 对象转换 */
    public ChessCardRecord convert(){
        ChessCardRecord chessCardRecord = new ChessCardRecord();
        chessCardRecord.setBigField(bigField);
        chessCardRecord.setSmallField(smallField);
        chessCardRecord.setLevels(levels);
        chessCardRecord.setPopulation(population);
        chessCardRecord.setRole1(cardId);
        chessCardRecord.setRole2(cardId);
        chessCardRecord.setRole3(cardId);
        chessCardRecord.setRole4(cardId);
        return chessCardRecord;
    }
}
