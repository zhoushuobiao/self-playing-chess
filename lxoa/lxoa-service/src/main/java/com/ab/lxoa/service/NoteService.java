package com.ab.lxoa.service;

import com.ab.lxoa.dto.LxMemoNoteList;

import java.util.List;

/**
 * 笔记service
 */
public interface NoteService {

    /**
     * 获取目录下所有的笔记
     * @param menuId
     * @return
     */
    List<LxMemoNoteList> getNoteListByMenuId(String menuId,String userId);

    /**
     * 根据笔记id获取笔记详情
     * @param noteId
     * @return
     */
    LxMemoNoteList getNoteByNoteId(String noteId);

    /**
     * 新增笔记
     * @param lxMemoNoteList
     * @return
     */
    int addNote(LxMemoNoteList lxMemoNoteList);

    /**
     * 更新笔记基本信息
     * @param lxMemoNoteList
     * @return
     */
    int updateNote(LxMemoNoteList lxMemoNoteList);

    /**
     * 删除笔记
     * @param noteId
     * @return
     */
    int deleteNote(String noteId);

}
