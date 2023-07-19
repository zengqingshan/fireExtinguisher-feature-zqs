package com.fireExtinguisher.intelligence.yd.dao;

import com.fireExtinguisher.intelligence.yd.entity.DjPartyMeetingsLesson;
import com.fireExtinguisher.intelligence.yd.param.DjPartyMeetingsLessonQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
public interface DjPartyMeetingsLessonMapper {

    List<DjPartyMeetingsLesson> findByAll(DjPartyMeetingsLessonQuery query);

    int  deleteDjPartyMeetingsLessonById(@Param("id")Long id);

    DjPartyMeetingsLesson getById(@Param("id")Long id);

    int add(DjPartyMeetingsLesson djPartyMeetingsLesson);

    int updateById(DjPartyMeetingsLesson djPartyMeetingsLesson);
}