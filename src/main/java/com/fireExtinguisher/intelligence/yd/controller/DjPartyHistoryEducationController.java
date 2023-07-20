package com.fireExtinguisher.intelligence.yd.controller;

import com.fireExtinguisher.intelligence.yd.entity.DjPartyFileInfo;
import com.fireExtinguisher.intelligence.yd.entity.DjPartyHistoryEducationInfo;
import com.fireExtinguisher.intelligence.yd.param.DjPartyHistoryEducationInfoQuery;
import com.fireExtinguisher.intelligence.yd.service.impl.DjPartyHistoryEducationInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.UUID;

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

    /**
     * 图片上传接口
     */
    @RequestMapping(value = "/info/uploadFile",method = {RequestMethod.POST})
    public String uploadFile(@RequestParam("file") MultipartFile file,
                             @RequestParam("associationId") Long associationId,
                             @RequestParam("title") String title,
                             @RequestParam("createBy") String createBy
                             ) throws IOException {
        try{
            if(file ==null || file.isEmpty()){
                return "文件为空";
            }
            System.out.println(associationId);
            System.out.println(title);
            return djPartyHistoryEducationService.uploadFile(file,associationId,title,createBy);

        }catch (Exception e){
        return e.getMessage();
        }
    }

    /**
     * 图片查看接口
     */
    @RequestMapping(value = "/info/downloadFile",method = {RequestMethod.POST})
    public String downloadFile(HttpServletResponse response,
                             @RequestParam("fileUrl") String fileUrl
    ) throws IOException {
        return djPartyHistoryEducationService.downloadFile(response,fileUrl);
    }

    /**
     * 图片列表查询接口
     */
    @RequestMapping(value = "/info/searchFileList",method = {RequestMethod.POST})
    public List<DjPartyFileInfo> searchFileList(@RequestParam("associationId") Long associationId) {
        return djPartyHistoryEducationService.searchFileList(associationId);
    }

}
