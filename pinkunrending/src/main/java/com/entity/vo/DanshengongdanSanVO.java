package com.entity.vo;

import com.entity.DanshengongdanSanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 三级单位审核
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("danshengongdan_san")
public class DanshengongdanSanVO implements Serializable {
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
     * 三级单位
     */

    @TableField(value = "sanjidanwei_id")
    private Integer sanjidanweiId;


    /**
     * 审核编号
     */

    @TableField(value = "danshengongdan_san_uuid_number")
    private String danshengongdanSanUuidNumber;


    /**
     * 审核状态
     */

    @TableField(value = "danshengongdan_san_yesno_types")
    private Integer danshengongdanSanYesnoTypes;


    /**
     * 审核意见
     */

    @TableField(value = "danshengongdan_san_yesno_text")
    private String danshengongdanSanYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "danshengongdan_san_shenhe_time")
    private Date danshengongdanSanShenheTime;


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
	 * 设置：三级单位
	 */
    public Integer getSanjidanweiId() {
        return sanjidanweiId;
    }


    /**
	 * 获取：三级单位
	 */

    public void setSanjidanweiId(Integer sanjidanweiId) {
        this.sanjidanweiId = sanjidanweiId;
    }
    /**
	 * 设置：审核编号
	 */
    public String getDanshengongdanSanUuidNumber() {
        return danshengongdanSanUuidNumber;
    }


    /**
	 * 获取：审核编号
	 */

    public void setDanshengongdanSanUuidNumber(String danshengongdanSanUuidNumber) {
        this.danshengongdanSanUuidNumber = danshengongdanSanUuidNumber;
    }
    /**
	 * 设置：审核状态
	 */
    public Integer getDanshengongdanSanYesnoTypes() {
        return danshengongdanSanYesnoTypes;
    }


    /**
	 * 获取：审核状态
	 */

    public void setDanshengongdanSanYesnoTypes(Integer danshengongdanSanYesnoTypes) {
        this.danshengongdanSanYesnoTypes = danshengongdanSanYesnoTypes;
    }
    /**
	 * 设置：审核意见
	 */
    public String getDanshengongdanSanYesnoText() {
        return danshengongdanSanYesnoText;
    }


    /**
	 * 获取：审核意见
	 */

    public void setDanshengongdanSanYesnoText(String danshengongdanSanYesnoText) {
        this.danshengongdanSanYesnoText = danshengongdanSanYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getDanshengongdanSanShenheTime() {
        return danshengongdanSanShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setDanshengongdanSanShenheTime(Date danshengongdanSanShenheTime) {
        this.danshengongdanSanShenheTime = danshengongdanSanShenheTime;
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
