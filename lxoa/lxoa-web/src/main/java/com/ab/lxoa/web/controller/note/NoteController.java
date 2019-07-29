package com.ab.lxoa.web.controller.note;

import com.ab.lxoa.common.ResultJSON;
import com.ab.lxoa.dto.LxMemoNoteList;
import com.ab.lxoa.service.NoteService;
import com.ab.lxoa.web.controller.base.BaseController;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author shachor
 * @date 2019/02/15 16:36
 */
@RestController
@RequestMapping("/note")
public class NoteController extends BaseController {

    @Autowired
    private NoteService noteService;

    @PostMapping("/addNote")
    public void addNote(LxMemoNoteList noteList, HttpServletResponse response){
        if(noteList == null || StringUtils.isBlank(noteList.getNoteName())){
            sendJson(response,ResultJSON.invalid("noteName"));
            return;
        }
        //待添加参数校验
        if(noteService.addNote(noteList) >0){
            sendJson(response,new ResultJSON());
        }else {
            sendJson(response,ResultJSON.forbidden());
        }
    }

    @GetMapping("/getNote")
    public void getNote(String noteId, HttpServletResponse response){
        //待添加参数校验
        LxMemoNoteList note =  noteService.getNoteByNoteId(noteId);
        sendJson(response,new ResultJSON(note));
    }
}
