package com.entity.model;

import com.entity.DanshengongdanSanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 三级单位审核
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class DanshengongdanSanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 贫困申请
     */
    private Integer pinkuhushenqingId;


    /**
     * 三级单位
     */
    private Integer sanjidanweiId;


    /**
     * 审核编号
     */
    private String danshengongdanSanUuidNumber;


    /**
     * 审核状态
     */
    private Integer danshengongdanSanYesnoTypes;


    /**
     * 审核意见
     */
    private String danshengongdanSanYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date danshengongdanSanShenheTime;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：贫困申请
	 */
    public Integer getPinkuhushenqingId() {
        return pinkuhushenqingId;
    }


    /**
	 * 设置：贫困申请
	 */
    public void setPinkuhushenqingId(Integer pinkuhushenqingId) {
        this.pinkuhushenqingId = pinkuhushenqingId;
    }
    /**
	 * 获取：三级单位
	 */
    public Integer getSanjidanweiId() {
        return sanjidanweiId;
    }


    /**
	 * 设置：三级单位
	 */
    public void setSanjidanweiId(Integer sanjidanweiId) {
        this.sanjidanweiId = sanjidanweiId;
    }
    /**
	 * 获取：审核编号
	 */
    public String getDanshengongdanSanUuidNumber() {
        return danshengongdanSanUuidNumber;
    }


    /**
	 * 设置：审核编号
	 */
    public void setDanshengongdanSanUuidNumber(String danshengongdanSanUuidNumber) {
        this.danshengongdanSanUuidNumber = danshengongdanSanUuidNumber;
    }
    /**
	 * 获取：审核状态
	 */
    public Integer getDanshengongdanSanYesnoTypes() {
        return danshengongdanSanYesnoTypes;
    }


    /**
	 * 设置：审核状态
	 */
    public void setDanshengongdanSanYesnoTypes(Integer danshengongdanSanYesnoTypes) {
        this.danshengongdanSanYesnoTypes = danshengongdanSanYesnoTypes;
    }
    /**
	 * 获取：审核意见
	 */
    public String getDanshengongdanSanYesnoText() {
        return danshengongdanSanYesnoText;
    }


    /**
	 * 设置：审核意见
	 */
    public void setDanshengongdanSanYesnoText(String danshengongdanSanYesnoText) {
        this.danshengongdanSanYesnoText = danshengongdanSanYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getDanshengongdanSanShenheTime() {
        return danshengongdanSanShenheTime;
    }


    /**
	 * 设置：审核时间
	 */
    public void setDanshengongdanSanShenheTime(Date danshengongdanSanShenheTime) {
        this.danshengongdanSanShenheTime = danshengongdanSanShenheTime;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：添加时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
