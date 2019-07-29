package com.ab.lxoa.dao.mapper;

import com.ab.lxoa.dto.LxMemoNoteList;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LxMemoNoteListMapper {
    int deleteByPrimaryKey(String noteId);

    int insert(LxMemoNoteList record);

    int insertSelective(LxMemoNoteList record);

    LxMemoNoteList selectByPrimaryKey(String noteId);


    int updateByPrimaryKeySelective(LxMemoNoteList record);

    int updateByPrimaryKey(LxMemoNoteList record);

    /**
     * 根据menuId获取noteList
     */
    List<LxMemoNoteList> getNoteListByMenuId(String menuId,String userId);
    /**
     * 获取当前目录下最大排序值(用于新增笔记时添加到末尾，Max(sequence)+1)
     */
    int queryMaxSequenceByMenuId(@Param("menuId") String menuId);
}