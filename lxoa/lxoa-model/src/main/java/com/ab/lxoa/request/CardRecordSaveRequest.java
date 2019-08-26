package com.ab.lxoa.request;

import com.ab.lxoa.dto.ChessCardRecord;
import lombok.Data;

import java.util.Date;

/**
 * 保存卡牌记录
 * @author zhoushuobiao
 */
@Data
public class CardRecordSaveRequest {
    /** 大局 */
    private Byte bigField;
    /** 小局 */
    private Byte smallField;
    /** 等级 */
    private Byte levels;
    /** 人口 */
    private Byte population;

    private Short role1;

    private Short role2;

    private Short role3;

    private Short role4;

    private Integer createId;

    public ChessCardRecord convert(){
        ChessCardRecord cardRecord = new ChessCardRecord();
        cardRecord.setRole1(role1);
        cardRecord.setRole2(role2);
        cardRecord.setRole3(role3);
        cardRecord.setRole4(role4);
        cardRecord.setBigField(bigField);
        cardRecord.setSmallField(smallField);
        cardRecord.setLevels(levels);
        cardRecord.setPopulation(population);
        cardRecord.setCreateId(createId);
        cardRecord.setCreateTime(new Date());
        return cardRecord;
    }
}
