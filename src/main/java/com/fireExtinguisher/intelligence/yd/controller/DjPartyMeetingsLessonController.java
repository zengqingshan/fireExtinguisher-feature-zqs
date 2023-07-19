package com.fireExtinguisher.intelligence.yd.controller;

import com.fireExtinguisher.intelligence.yd.entity.DjPartyMeetingsLesson;
import com.fireExtinguisher.intelligence.yd.param.DjPartyMeetingsLessonQuery;
import com.fireExtinguisher.intelligence.yd.service.impl.DjPartyMeetingsLessonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zqs
 * @date 2023-7-18 11:05
 * @Description:
 */
@RestController
@RequestMapping("/dj/partyHistoryEducation")
public class DjPartyMeetingsLessonController {

    @Autowired
    private DjPartyMeetingsLessonServiceImpl djPartyMeetingsLessonServiceImpl;

    /**
     * 三会一课列表查询
     */
    @PostMapping("/meetingsLesson/list")
    public List<DjPartyMeetingsLesson> selectDjPartyHistoryEducationInfoList(@RequestBody DjPartyMeetingsLessonQuery query)
    {

        return djPartyMeetingsLessonServiceImpl.selectDjPartyMeetingsLessonList(query);
    }

    /**
     * 三会一课新增接口
     */
    @PostMapping("/meetingsLesson/add")
    public void add(@RequestBody DjPartyMeetingsLesson djPartyMeetingsLesson)
    {
        djPartyMeetingsLessonServiceImpl.add(djPartyMeetingsLesson);
    }

    /**
     * 三会一课更新接口
     */
    @PostMapping("/meetingsLesson/updateById")
    public void updateById(@RequestBody DjPartyMeetingsLesson djPartyMeetingsLesson)
    {
        djPartyMeetingsLessonServiceImpl.updateById(djPartyMeetingsLesson);
    }

    /**
     * 三会一课获取详情接口
     */
    @PostMapping("/meetingsLesson/getById")
    public DjPartyMeetingsLesson getById(@RequestBody DjPartyMeetingsLesson djPartyMeetingsLesson)
    {
       return djPartyMeetingsLessonServiceImpl.getById(djPartyMeetingsLesson.getId());
    }

    /**
     * 三会一课删除接口
     */
    @PostMapping("/meetingsLesson/deleteById")
    public void deleteById(@RequestBody DjPartyMeetingsLesson djPartyMeetingsLesson)
    {
        djPartyMeetingsLessonServiceImpl.deleteById(djPartyMeetingsLesson.getId());
    }
}
