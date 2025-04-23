package com.entity.vo;

import com.entity.DanshengongdanYiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 一级单位审核
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("danshengongdan_yi")
public class DanshengongdanYiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 贫困申请
     */

    @TableField(value = "pinkuhushenqing_id")
    private Integer pinkuhushenqingId;


    /**
     * 一级单位
     */

    @TableField(value = "yijidanwei_id")
    private Integer yijidanweiId;


    /**
     * 审核编号
     */

    @TableField(value = "danshengongdan_yi_uuid_number")
    private String danshengongdanYiUuidNumber;


    /**
     * 审核状态
     */

    @TableField(value = "danshengongdan_yi_yesno_types")
    private Integer danshengongdanYiYesnoTypes;


    /**
     * 审核意见
     */

    @TableField(value = "danshengongdan_yi_yesno_text")
    private String danshengongdanYiYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "danshengongdan_yi_shenhe_time")
    private Date danshengongdanYiShenheTime;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：贫困申请
	 */
    public Integer getPinkuhushenqingId() {
        return pinkuhushenqingId;
    }


    /**
	 * 获取：贫困申请
	 */

    public void setPinkuhushenqingId(Integer pinkuhushenqingId) {
        this.pinkuhushenqingId = pinkuhushenqingId;
    }
    /**
	 * 设置：一级单位
	 */
    public Integer getYijidanweiId() {
        return yijidanweiId;
    }


    /**
	 * 获取：一级单位
	 */

    public void setYijidanweiId(Integer yijidanweiId) {
        this.yijidanweiId = yijidanweiId;
    }
    /**
	 * 设置：审核编号
	 */
    public String getDanshengongdanYiUuidNumber() {
        return danshengongdanYiUuidNumber;
    }


    /**
	 * 获取：审核编号
	 */

    public void setDanshengongdanYiUuidNumber(String danshengongdanYiUuidNumber) {
        this.danshengongdanYiUuidNumber = danshengongdanYiUuidNumber;
    }
    /**
	 * 设置：审核状态
	 */
    public Integer getDanshengongdanYiYesnoTypes() {
        return danshengongdanYiYesnoTypes;
    }


    /**
	 * 获取：审核状态
	 */

    public void setDanshengongdanYiYesnoTypes(Integer danshengongdanYiYesnoTypes) {
        this.danshengongdanYiYesnoTypes = danshengongdanYiYesnoTypes;
    }
    /**
	 * 设置：审核意见
	 */
    public String getDanshengongdanYiYesnoText() {
        return danshengongdanYiYesnoText;
    }


    /**
	 * 获取：审核意见
	 */

    public void setDanshengongdanYiYesnoText(String danshengongdanYiYesnoText) {
        this.danshengongdanYiYesnoText = danshengongdanYiYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getDanshengongdanYiShenheTime() {
        return danshengongdanYiShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setDanshengongdanYiShenheTime(Date danshengongdanYiShenheTime) {
        this.danshengongdanYiShenheTime = danshengongdanYiShenheTime;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
