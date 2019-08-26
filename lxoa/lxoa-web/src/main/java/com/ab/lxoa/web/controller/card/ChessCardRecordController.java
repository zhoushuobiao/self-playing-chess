package com.ab.lxoa.web.controller.card;

import com.ab.lxoa.base.ResultJSON;
import com.ab.lxoa.service.IChessCardRecordService;
import com.ab.lxoa.request.CardRecordQueryRequest;
import com.ab.lxoa.request.CardRecordSaveRequest;
import com.ab.lxoa.web.controller.base.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * 卡牌记录
 * @author zhoushuobiao
 */
@RestController
@RequestMapping("/record")
public class ChessCardRecordController extends BaseController {
    private final IChessCardRecordService chessCardRecordService;

    public ChessCardRecordController(IChessCardRecordService chessCardRecordService) {
        this.chessCardRecordService = chessCardRecordService;
    }

    @RequestMapping("/saveRecord")
    public void saveRecord(CardRecordSaveRequest request, HttpServletResponse response){
        chessCardRecordService.saveRecord(request);
        sendJson(response,new ResultJSON());
    }

    @RequestMapping("/queryRecord")
    public void queryRecord(CardRecordQueryRequest request,HttpServletResponse response){
        sendJson(response,new ResultJSON(chessCardRecordService.queryRecord(request)));
    }
}
