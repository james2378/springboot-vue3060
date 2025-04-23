package com.entity.vo;

import com.entity.DanshengongdanErEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 二级单位审核
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("danshengongdan_er")
public class DanshengongdanErVO implements Serializable {
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
     * 二级单位
     */

    @TableField(value = "erjidanwei_id")
    private Integer erjidanweiId;


    /**
     * 审核编号
     */

    @TableField(value = "danshengongdan_er_uuid_number")
    private String danshengongdanErUuidNumber;


    /**
     * 审核状态
     */

    @TableField(value = "danshengongdan_er_yesno_types")
    private Integer danshengongdanErYesnoTypes;


    /**
     * 审核意见
     */

    @TableField(value = "danshengongdan_er_yesno_text")
    private String danshengongdanErYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "danshengongdan_er_shenhe_time")
    private Date danshengongdanErShenheTime;


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
	 * 设置：二级单位
	 */
    public Integer getErjidanweiId() {
        return erjidanweiId;
    }


    /**
	 * 获取：二级单位
	 */

    public void setErjidanweiId(Integer erjidanweiId) {
        this.erjidanweiId = erjidanweiId;
    }
    /**
	 * 设置：审核编号
	 */
    public String getDanshengongdanErUuidNumber() {
        return danshengongdanErUuidNumber;
    }


    /**
	 * 获取：审核编号
	 */

    public void setDanshengongdanErUuidNumber(String danshengongdanErUuidNumber) {
        this.danshengongdanErUuidNumber = danshengongdanErUuidNumber;
    }
    /**
	 * 设置：审核状态
	 */
    public Integer getDanshengongdanErYesnoTypes() {
        return danshengongdanErYesnoTypes;
    }


    /**
	 * 获取：审核状态
	 */

    public void setDanshengongdanErYesnoTypes(Integer danshengongdanErYesnoTypes) {
        this.danshengongdanErYesnoTypes = danshengongdanErYesnoTypes;
    }
    /**
	 * 设置：审核意见
	 */
    public String getDanshengongdanErYesnoText() {
        return danshengongdanErYesnoText;
    }


    /**
	 * 获取：审核意见
	 */

    public void setDanshengongdanErYesnoText(String danshengongdanErYesnoText) {
        this.danshengongdanErYesnoText = danshengongdanErYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getDanshengongdanErShenheTime() {
        return danshengongdanErShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setDanshengongdanErShenheTime(Date danshengongdanErShenheTime) {
        this.danshengongdanErShenheTime = danshengongdanErShenheTime;
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
