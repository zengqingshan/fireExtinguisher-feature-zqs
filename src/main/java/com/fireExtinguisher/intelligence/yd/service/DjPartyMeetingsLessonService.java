package com.fireExtinguisher.intelligence.yd.service;

import com.fireExtinguisher.intelligence.yd.entity.DjPartyMeetingsLesson;
import com.fireExtinguisher.intelligence.yd.entity.User;
import com.fireExtinguisher.intelligence.yd.param.DjPartyMeetingsLessonQuery;
import com.fireExtinguisher.intelligence.yd.param.UserParam;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface DjPartyMeetingsLessonService {

     List<DjPartyMeetingsLesson> selectDjPartyMeetingsLessonList(DjPartyMeetingsLessonQuery query);
     int add(DjPartyMeetingsLesson djPartyMeetingsLesson);
     int updateById(DjPartyMeetingsLesson djPartyMeetingsLesson);
     int deleteById(Long djPartyMeetingsLessonId);
     DjPartyMeetingsLesson getById(Long djPartyMeetingsLessonId);
}
