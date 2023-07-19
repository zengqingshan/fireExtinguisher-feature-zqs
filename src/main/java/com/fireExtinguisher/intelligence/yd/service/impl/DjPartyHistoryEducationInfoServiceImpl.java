package com.fireExtinguisher.intelligence.yd.service.impl;

import com.fireExtinguisher.intelligence.yd.dao.DjPartyHistoryEducationInfoMapper;
import com.fireExtinguisher.intelligence.yd.entity.DjPartyHistoryEducationInfo;
import com.fireExtinguisher.intelligence.yd.param.DjPartyHistoryEducationInfoQuery;
import com.fireExtinguisher.intelligence.yd.service.DjPartyHistoryEducationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zqs
 * @date 2023-7-18 11:34
 * @Description:
 */
@Service
public class DjPartyHistoryEducationInfoServiceImpl implements DjPartyHistoryEducationInfoService {

    @Autowired
    private DjPartyHistoryEducationInfoMapper djPartyHistoryEducationInfoMapper;

    @Override
    public List<DjPartyHistoryEducationInfo> selectDjPartyHistoryEducationInfoList(DjPartyHistoryEducationInfoQuery query)
    {
        return djPartyHistoryEducationInfoMapper.findByAll(query);
    }
    @Override
    public int add(DjPartyHistoryEducationInfo djPartyHistoryEducationInfo){
        return djPartyHistoryEducationInfoMapper.add(djPartyHistoryEducationInfo);
    }
    @Override
    public int updateById(DjPartyHistoryEducationInfo djPartyHistoryEducationInfo){
        return djPartyHistoryEducationInfoMapper.updateById(djPartyHistoryEducationInfo);
    }
    @Override
    public int updateStatusById(Long djPartyHistoryEducationInfoId,String status){
        return djPartyHistoryEducationInfoMapper.updateStatusById(djPartyHistoryEducationInfoId,status);
    }
    @Override
    public int deleteById(Long djPartyHistoryEducationInfoId){
        return djPartyHistoryEducationInfoMapper.deleteDjPartyHistoryEducationInfoById(djPartyHistoryEducationInfoId);
    }
    @Override
    public DjPartyHistoryEducationInfo getById(Long djPartyHistoryEducationInfoId){
        return djPartyHistoryEducationInfoMapper.getById(djPartyHistoryEducationInfoId);
    }



}
