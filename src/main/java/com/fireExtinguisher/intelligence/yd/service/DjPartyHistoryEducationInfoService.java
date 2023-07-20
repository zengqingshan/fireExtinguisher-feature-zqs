package com.fireExtinguisher.intelligence.yd.service;

import com.fireExtinguisher.intelligence.yd.entity.DjPartyHistoryEducationInfo;
import com.fireExtinguisher.intelligence.yd.entity.User;
import com.fireExtinguisher.intelligence.yd.param.DjPartyHistoryEducationInfoQuery;
import com.fireExtinguisher.intelligence.yd.param.UserParam;
import com.github.pagehelper.PageInfo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DjPartyHistoryEducationInfoService {

     List<DjPartyHistoryEducationInfo> selectDjPartyHistoryEducationInfoList(DjPartyHistoryEducationInfoQuery query);
     int add(DjPartyHistoryEducationInfo djPartyHistoryEducationInfo);
     int updateById(DjPartyHistoryEducationInfo djPartyHistoryEducationInfo);
     int updateStatusById(Long djPartyHistoryEducationInfoId,String status);
     int deleteById(Long djPartyHistoryEducationInfoId);
     DjPartyHistoryEducationInfo getById(Long djPartyHistoryEducationInfoId);

     String uploadFile(MultipartFile file,Long associationId,String title);
}
