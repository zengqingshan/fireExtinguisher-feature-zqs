package com.fireExtinguisher.intelligence.yd.controller;

import com.fireExtinguisher.intelligence.yd.entity.DjPartyHistoryEducationInfo;
import com.fireExtinguisher.intelligence.yd.param.DjPartyHistoryEducationInfoQuery;
import com.fireExtinguisher.intelligence.yd.service.impl.DjPartyHistoryEducationInfoServiceImpl;
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
public class DjPartyHistoryEducationController {

    @Autowired
    private DjPartyHistoryEducationInfoServiceImpl djPartyHistoryEducationService;

    /**
     * 党史资料列表查询
     */
    @PostMapping("/info/list")
    public List<DjPartyHistoryEducationInfo> selectDjPartyHistoryEducationInfoList(@RequestBody DjPartyHistoryEducationInfoQuery query)
    {
        List<DjPartyHistoryEducationInfo>  list=djPartyHistoryEducationService.selectDjPartyHistoryEducationInfoList(query);
        return list;
    }

    /**
     * 党史资料新增接口
     */
    @PostMapping("/info/add")
    public void add(@RequestBody DjPartyHistoryEducationInfo djPartyHistoryEducationInfo)
    {
        djPartyHistoryEducationService.add(djPartyHistoryEducationInfo);
    }

    /**
     * 党史资料更新接口
     */
    @PostMapping("/info/updateById")
    public void updateById(@RequestBody DjPartyHistoryEducationInfo djPartyHistoryEducationInfo)
    {
        djPartyHistoryEducationService.updateById(djPartyHistoryEducationInfo);
    }

    /**
     * 党史资料更新状态接口
     */
    @PostMapping("/info/updateStatusById")
    public void updateStatusById(@RequestBody DjPartyHistoryEducationInfo djPartyHistoryEducationInfo)
    {
        djPartyHistoryEducationService.updateStatusById(djPartyHistoryEducationInfo.getId(),djPartyHistoryEducationInfo.getStatus());
    }

    /**
     * 党史资料获取详情接口
     */
    @PostMapping("/info/getById")
    public DjPartyHistoryEducationInfo getById(@RequestBody DjPartyHistoryEducationInfo djPartyHistoryEducationInfo)
    {
       return djPartyHistoryEducationService.getById(djPartyHistoryEducationInfo.getId());
    }

    /**
     * 党史资料删除接口
     */
    @PostMapping("/info/deleteById")
    public void deleteById(@RequestBody DjPartyHistoryEducationInfo djPartyHistoryEducationInfo)
    {
         djPartyHistoryEducationService.deleteById(djPartyHistoryEducationInfo.getId());
    }
}
