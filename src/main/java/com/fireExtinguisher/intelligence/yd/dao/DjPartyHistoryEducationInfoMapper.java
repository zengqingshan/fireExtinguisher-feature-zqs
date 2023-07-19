package com.fireExtinguisher.intelligence.yd.dao;

import com.fireExtinguisher.intelligence.yd.entity.DjPartyHistoryEducationInfo;
import com.fireExtinguisher.intelligence.yd.param.DjPartyHistoryEducationInfoQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
public interface DjPartyHistoryEducationInfoMapper {

    List<DjPartyHistoryEducationInfo> findByAll(DjPartyHistoryEducationInfoQuery query);

    int  deleteDjPartyHistoryEducationInfoById(@Param("id")Long id);

    DjPartyHistoryEducationInfo getById(@Param("id")Long id);

    int add(DjPartyHistoryEducationInfo djPartyHistoryEducationInfo);

    int updateById(DjPartyHistoryEducationInfo djPartyHistoryEducationInfo);

    int updateStatusById(@Param("id")Long id,@Param("status")String status);
}