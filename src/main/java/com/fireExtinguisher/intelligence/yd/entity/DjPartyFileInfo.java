package com.fireExtinguisher.intelligence.yd.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * zqs
 */
@ApiModel(description = "文件数据")
@TableName(value = "t_file")
public class DjPartyFileInfo {
    /**
     * 文件ID
     */
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value = "文件ID")
    private Long id;

    /**
     * 关联对象id（村落id）
     */
    @TableField(value = "association_id")
    @ApiModelProperty(value = "小区、村落id")
    private Long associationId;
    /**
     * 文件类型（1:图片 2：视频）
     */
    @TableField(value = "file_type")
    @ApiModelProperty(value = "文件类型（1:图片 2：视频）")
    private Integer fileType;
    /**
     * 项目模块（1：党建 ）
     */
    @TableField(value = "project_modle")
    @ApiModelProperty(value = "项目模块（1：党建 ）")
    private Integer projectModle;
    /**
     * 文件URL
     */
    @TableField(value = "file_url")
    @ApiModelProperty(value = "文件URL")
    private String fileUrl;
    /**
     * 标题
     */
    @TableField(value = "title")
    @ApiModelProperty(value = "标题")
    private String title;
    /**
     * 备注
     */
    @TableField(value = "remarks")
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 创建人
     */
    @TableField(value = "create_by")
    @ApiModelProperty(value = "创建人")
    private String createBy;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 更新人
     */
    @TableField(value = "update_by")
    @ApiModelProperty(value = "更新人")
    private String updateBy;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    @ApiModelProperty(value = "更新时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /**
     * 逻辑删除（0：删除  1：可用）
     */
    @TableField(value = "enabled")
    @ApiModelProperty(value = "逻辑删除（0：删除  1：可用）")
    private String enabled;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAssociationId() {
        return associationId;
    }

    public void setAssociationId(Long associationId) {
        this.associationId = associationId;
    }

    public Integer getFileType() {
        return fileType;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }

    public Integer getProjectModle() {
        return projectModle;
    }

    public void setProjectModle(Integer projectModle) {
        this.projectModle = projectModle;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }
}
