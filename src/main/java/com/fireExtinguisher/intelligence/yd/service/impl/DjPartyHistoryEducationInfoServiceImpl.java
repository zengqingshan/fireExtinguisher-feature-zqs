package com.fireExtinguisher.intelligence.yd.service.impl;

import com.fireExtinguisher.intelligence.yd.dao.DjPartyHistoryEducationInfoMapper;
import com.fireExtinguisher.intelligence.yd.entity.DjPartyHistoryEducationInfo;
import com.fireExtinguisher.intelligence.yd.param.DjPartyHistoryEducationInfoQuery;
import com.fireExtinguisher.intelligence.yd.service.DjPartyHistoryEducationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author zqs
 * @date 2023-7-18 11:34
 * @Description:
 */
@Service
public class DjPartyHistoryEducationInfoServiceImpl implements DjPartyHistoryEducationInfoService {
    // 当前项目绝对路径
    private static final String PROJECT_PATH = new File("").getAbsolutePath();
    // 文件上传的路径
    private static final String UPLOAD_FOLDER = "/upload/";

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

    @Override
    public String uploadFile(MultipartFile file,Long associationId,String title) {
        try{
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormat2=new SimpleDateFormat("yyyyMMdd-HHmmss");
        Date date=new Date();
        String fileFolder=simpleDateFormat.format(date);
        String fileFolderUrl=PROJECT_PATH+UPLOAD_FOLDER+fileFolder;
        //判断服务器目录upload下是否存在当天日期的文件夹，如果不存在就创建
        File file2= new File(fileFolderUrl);
        if (!file2.exists()){
            if(!file2.mkdirs()){
                return "创建文件夹失败";
            }
        }
        //获取文件名
        String fileName = file.getOriginalFilename();
        //获取文件后缀名。也可以在这里添加判断语句，规定特定格式的图片才能上传，否则拒绝保存。
        String indexSuffixName = fileName.substring(0,fileName.indexOf("."));
        String lastSuffixName = fileName.substring(fileName.lastIndexOf("."));
        //为了避免发生图片替换，这里使用了文件名重新生成
        fileName=indexSuffixName+"-"+simpleDateFormat2.format(date)+lastSuffixName;
        String filePath=fileFolderUrl+"/"+fileName;
        String fileUrl=UPLOAD_FOLDER+fileFolder+"/"+fileName;
        System.out.println(filePath);
        System.out.println(fileUrl);
        file.transferTo(new File(filePath));
        //将视频相关信息保存到数据库
        return fileUrl;
        }catch (Exception e){
            return e.getMessage();
        }
    }


}
