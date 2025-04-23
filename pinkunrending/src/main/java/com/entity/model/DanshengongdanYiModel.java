package com.entity.model;

import com.entity.DanshengongdanYiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 一级单位审核
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class DanshengongdanYiModel implements Serializable {
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
     * 一级单位
     */
    private Integer yijidanweiId;


    /**
     * 审核编号
     */
    private String danshengongdanYiUuidNumber;


    /**
     * 审核状态
     */
    private Integer danshengongdanYiYesnoTypes;


    /**
     * 审核意见
     */
    private String danshengongdanYiYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date danshengongdanYiShenheTime;


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
	 * 获取：一级单位
	 */
    public Integer getYijidanweiId() {
        return yijidanweiId;
    }


    /**
	 * 设置：一级单位
	 */
    public void setYijidanweiId(Integer yijidanweiId) {
        this.yijidanweiId = yijidanweiId;
    }
    /**
	 * 获取：审核编号
	 */
    public String getDanshengongdanYiUuidNumber() {
        return danshengongdanYiUuidNumber;
    }


    /**
	 * 设置：审核编号
	 */
    public void setDanshengongdanYiUuidNumber(String danshengongdanYiUuidNumber) {
        this.danshengongdanYiUuidNumber = danshengongdanYiUuidNumber;
    }
    /**
	 * 获取：审核状态
	 */
    public Integer getDanshengongdanYiYesnoTypes() {
        return danshengongdanYiYesnoTypes;
    }


    /**
	 * 设置：审核状态
	 */
    public void setDanshengongdanYiYesnoTypes(Integer danshengongdanYiYesnoTypes) {
        this.danshengongdanYiYesnoTypes = danshengongdanYiYesnoTypes;
    }
    /**
	 * 获取：审核意见
	 */
    public String getDanshengongdanYiYesnoText() {
        return danshengongdanYiYesnoText;
    }


    /**
	 * 设置：审核意见
	 */
    public void setDanshengongdanYiYesnoText(String danshengongdanYiYesnoText) {
        this.danshengongdanYiYesnoText = danshengongdanYiYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getDanshengongdanYiShenheTime() {
        return danshengongdanYiShenheTime;
    }


    /**
	 * 设置：审核时间
	 */
    public void setDanshengongdanYiShenheTime(Date danshengongdanYiShenheTime) {
        this.danshengongdanYiShenheTime = danshengongdanYiShenheTime;
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
