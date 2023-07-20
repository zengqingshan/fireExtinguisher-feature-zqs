package com.fireExtinguisher.intelligence.yd.dao;

import com.fireExtinguisher.intelligence.yd.entity.DjPartyFileInfo;
import com.fireExtinguisher.intelligence.yd.entity.DjPartyMeetingsLesson;
import com.fireExtinguisher.intelligence.yd.param.DjPartyMeetingsLessonQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DjPartyFileInfoMapper {

int add(DjPartyFileInfo djPartyFileInfo);

int deleteFileInfoById(Long id);

List<DjPartyFileInfo> findByAssociationId(@Param("associationId")Long associationId);

}