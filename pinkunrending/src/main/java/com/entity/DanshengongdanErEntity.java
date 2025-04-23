package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 二级单位审核
 *
 * @author 
 * @email
 */
@TableName("danshengongdan_er")
public class DanshengongdanErEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public DanshengongdanErEntity() {

	}

	public DanshengongdanErEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
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
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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

    @Override
    public String toString() {
        return "DanshengongdanEr{" +
            "id=" + id +
            ", pinkuhushenqingId=" + pinkuhushenqingId +
            ", erjidanweiId=" + erjidanweiId +
            ", danshengongdanErUuidNumber=" + danshengongdanErUuidNumber +
            ", danshengongdanErYesnoTypes=" + danshengongdanErYesnoTypes +
            ", danshengongdanErYesnoText=" + danshengongdanErYesnoText +
            ", danshengongdanErShenheTime=" + danshengongdanErShenheTime +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
