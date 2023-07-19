package com.fireExtinguisher.intelligence.yd.service.impl;

import com.fireExtinguisher.intelligence.yd.dao.DjPartyMeetingsLessonMapper;
import com.fireExtinguisher.intelligence.yd.entity.DjPartyMeetingsLesson;
import com.fireExtinguisher.intelligence.yd.param.DjPartyMeetingsLessonQuery;
import com.fireExtinguisher.intelligence.yd.service.DjPartyMeetingsLessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zqs
 * @date 2023-7-18 11:34
 * @Description:
 */
@Service
public class DjPartyMeetingsLessonServiceImpl implements DjPartyMeetingsLessonService {

    @Autowired
    private DjPartyMeetingsLessonMapper djPartyMeetingsLessonMapper;
    @Override
    public List<DjPartyMeetingsLesson> selectDjPartyMeetingsLessonList(DjPartyMeetingsLessonQuery query)
    {
        return djPartyMeetingsLessonMapper.findByAll(query);
    }
    @Override
    public int add(DjPartyMeetingsLesson djPartyMeetingsLesson){
        return djPartyMeetingsLessonMapper.add(djPartyMeetingsLesson);
    }
    @Override
    public int updateById(DjPartyMeetingsLesson djPartyMeetingsLesson){
        return djPartyMeetingsLessonMapper.updateById(djPartyMeetingsLesson);
    }
    @Override
    public int deleteById(Long djPartyMeetingsLessonId){
        return djPartyMeetingsLessonMapper.deleteDjPartyMeetingsLessonById(djPartyMeetingsLessonId);
    }
    @Override
    public DjPartyMeetingsLesson getById(Long djPartyMeetingsLessonId){
        return djPartyMeetingsLessonMapper.getById(djPartyMeetingsLessonId);
    }



}
