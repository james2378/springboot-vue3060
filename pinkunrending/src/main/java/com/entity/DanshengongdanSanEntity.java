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
 * 三级单位审核
 *
 * @author 
 * @email
 */
@TableName("danshengongdan_san")
public class DanshengongdanSanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public DanshengongdanSanEntity() {

	}

	public DanshengongdanSanEntity(T t) {
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

    @Override
    public String toString() {
        return "DanshengongdanSan{" +
            "id=" + id +
            ", pinkuhushenqingId=" + pinkuhushenqingId +
            ", sanjidanweiId=" + sanjidanweiId +
            ", danshengongdanSanUuidNumber=" + danshengongdanSanUuidNumber +
            ", danshengongdanSanYesnoTypes=" + danshengongdanSanYesnoTypes +
            ", danshengongdanSanYesnoText=" + danshengongdanSanYesnoText +
            ", danshengongdanSanShenheTime=" + danshengongdanSanShenheTime +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
