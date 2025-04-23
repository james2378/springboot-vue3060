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
 * 三级单位
 *
 * @author 
 * @email
 */
@TableName("sanjidanwei")
public class SanjidanweiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public SanjidanweiEntity() {

	}

	public SanjidanweiEntity(T t) {
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
     * 账户
     */
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @TableField(value = "password")

    private String password;


    /**
     * 三级单位名称
     */
    @TableField(value = "sanjidanwei_name")

    private String sanjidanweiName;


    /**
     * 三级单位联系方式
     */
    @TableField(value = "sanjidanwei_phone")

    private String sanjidanweiPhone;


    /**
     * 三级单位邮箱
     */
    @TableField(value = "sanjidanwei_email")

    private String sanjidanweiEmail;


    /**
     * 三级单位介绍
     */
    @TableField(value = "sanjidanwei_content")

    private String sanjidanweiContent;


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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }
    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }
    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：三级单位名称
	 */
    public String getSanjidanweiName() {
        return sanjidanweiName;
    }
    /**
	 * 获取：三级单位名称
	 */

    public void setSanjidanweiName(String sanjidanweiName) {
        this.sanjidanweiName = sanjidanweiName;
    }
    /**
	 * 设置：三级单位联系方式
	 */
    public String getSanjidanweiPhone() {
        return sanjidanweiPhone;
    }
    /**
	 * 获取：三级单位联系方式
	 */

    public void setSanjidanweiPhone(String sanjidanweiPhone) {
        this.sanjidanweiPhone = sanjidanweiPhone;
    }
    /**
	 * 设置：三级单位邮箱
	 */
    public String getSanjidanweiEmail() {
        return sanjidanweiEmail;
    }
    /**
	 * 获取：三级单位邮箱
	 */

    public void setSanjidanweiEmail(String sanjidanweiEmail) {
        this.sanjidanweiEmail = sanjidanweiEmail;
    }
    /**
	 * 设置：三级单位介绍
	 */
    public String getSanjidanweiContent() {
        return sanjidanweiContent;
    }
    /**
	 * 获取：三级单位介绍
	 */

    public void setSanjidanweiContent(String sanjidanweiContent) {
        this.sanjidanweiContent = sanjidanweiContent;
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
        return "Sanjidanwei{" +
            "id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", sanjidanweiName=" + sanjidanweiName +
            ", sanjidanweiPhone=" + sanjidanweiPhone +
            ", sanjidanweiEmail=" + sanjidanweiEmail +
            ", sanjidanweiContent=" + sanjidanweiContent +
            ", createTime=" + createTime +
        "}";
    }
}
