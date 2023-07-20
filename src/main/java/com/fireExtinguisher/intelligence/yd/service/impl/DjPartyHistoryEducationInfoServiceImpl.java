package com.fireExtinguisher.intelligence.yd.service.impl;

import com.fireExtinguisher.intelligence.yd.dao.DjPartyFileInfoMapper;
import com.fireExtinguisher.intelligence.yd.dao.DjPartyHistoryEducationInfoMapper;
import com.fireExtinguisher.intelligence.yd.entity.DjPartyFileInfo;
import com.fireExtinguisher.intelligence.yd.entity.DjPartyHistoryEducationInfo;
import com.fireExtinguisher.intelligence.yd.param.DjPartyHistoryEducationInfoQuery;
import com.fireExtinguisher.intelligence.yd.service.DjPartyHistoryEducationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
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
    @Autowired
    private DjPartyFileInfoMapper djPartyFileInfoMapper;

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
    public String uploadFile(MultipartFile file,Long associationId,String title,String createBy) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMdd");
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
        //String indexSuffixName = fileName.substring(0,fileName.indexOf("."));
        //String lastSuffixName = fileName.substring(fileName.lastIndexOf("."));
        //为了避免发生图片替换，这里使用了文件名重新生成
        //fileName=indexSuffixName+"-"+simpleDateFormat2.format(date)+lastSuffixName;
        fileName= simpleDateFormat2.format(date)+"-"+fileName;
        String filePath=fileFolderUrl+"/"+fileName;
        //String fileUrl=UPLOAD_FOLDER+fileFolder+"/"+fileName;
        System.out.println(filePath);
        System.out.println(fileName);
        //将视频相关信息保存到数据库
         DjPartyFileInfo djPartyFileInfo=new DjPartyFileInfo();
         djPartyFileInfo.setAssociationId(associationId);
         djPartyFileInfo.setTitle(title);
         djPartyFileInfo.setFileType(2);//文件类型为2 视频
         djPartyFileInfo.setProjectModle(1);//项目模块为 1 党建
         djPartyFileInfo.setFileUrl(fileName);
         djPartyFileInfo.setCreateBy(createBy);
         djPartyFileInfo.setCreateTime(new Date());
         djPartyFileInfo.setUpdateBy(createBy);
         djPartyFileInfo.setUpdateTime(new Date());
         djPartyFileInfoMapper.add(djPartyFileInfo);
         //上传视频到服务
            new Thread(new Runnable() {
                public void run() {
                    try {
                        file.transferTo(new File(filePath));
                    }catch (Exception e){

                    }
                }}).start();
        return fileName;

    }

    @Override
    public String downloadFile(HttpServletResponse response, String fileName) {
        response.setHeader("content-type", "application/octet-stream");
        response.setContentType("application/octet-stream");
        try {
            response.setHeader("Content-Disposition", "attachment;filename=" + java.net.URLEncoder.encode(fileName, "UTF-8"));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            String dateFolder=fileName.substring(0,fileName.indexOf("-"));//日期文件夹
            String fileUrl=PROJECT_PATH+UPLOAD_FOLDER+dateFolder+"/"+fileName;
            os = response.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(new File(fileUrl)));
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
        } catch (FileNotFoundException e1) {
            //e1.getMessage()+"系统找不到指定的文件";
            return "系统找不到指定的文件";
        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "success";
    }

    @Override
    public List<DjPartyFileInfo> searchFileList(Long associationId) {
        return djPartyFileInfoMapper.findByAssociationId(associationId);
    }


}
