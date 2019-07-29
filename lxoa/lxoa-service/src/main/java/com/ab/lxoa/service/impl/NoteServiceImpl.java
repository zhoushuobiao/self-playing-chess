package com.ab.lxoa.service.impl;

import com.ab.lxoa.dao.mapper.LxMemoNoteListMapper;
import com.ab.lxoa.dto.LxMemoNoteList;
import com.ab.lxoa.service.NoteService;
import com.ab.lxoa.utils.data.DateUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private LxMemoNoteListMapper noteListMapper;

    @Override
    public List<LxMemoNoteList> getNoteListByMenuId(String menuId,String userId) {
        return noteListMapper.getNoteListByMenuId(menuId,userId);
    }

    @Override
    public LxMemoNoteList getNoteByNoteId(String noteId) {
        return noteListMapper.selectByPrimaryKey(noteId);
    }

    @Override
    @Transactional
    public int addNote(LxMemoNoteList lxMemoNoteList) {
        //noteId为空表示新增，否则表示更新
        if(StringUtils.isBlank(lxMemoNoteList.getNoteId())){
            lxMemoNoteList.setNoteId(UUID.randomUUID().toString().replaceAll("-", ""));
            lxMemoNoteList.setCreateTime(DateUtils.getCurrentTime());
            int maxSequence = noteListMapper.queryMaxSequenceByMenuId(lxMemoNoteList.getMenuId()) + 1;
            lxMemoNoteList.setSequence((short)maxSequence);
            lxMemoNoteList.setCreateUserId("18202795228");
            lxMemoNoteList.setDelflag((byte)1);
        }
        lxMemoNoteList.setUpdateTime(DateUtils.getCurrentTime());
        return noteListMapper.insertSelective(lxMemoNoteList);
    }

    @Override
    public int updateNote(LxMemoNoteList lxMemoNoteList) {
        return 0;
    }

    @Override
    public int deleteNote(String noteId) {
        return 0;
    }

}
