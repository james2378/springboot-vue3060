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
 * 二级单位
 *
 * @author 
 * @email
 */
@TableName("erjidanwei")
public class ErjidanweiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ErjidanweiEntity() {

	}

	public ErjidanweiEntity(T t) {
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
     * 二级单位名称
     */
    @TableField(value = "erjidanwei_name")

    private String erjidanweiName;


    /**
     * 二级单位联系方式
     */
    @TableField(value = "erjidanwei_phone")

    private String erjidanweiPhone;


    /**
     * 二级单位邮箱
     */
    @TableField(value = "erjidanwei_email")

    private String erjidanweiEmail;


    /**
     * 二级单位介绍
     */
    @TableField(value = "erjidanwei_content")

    private String erjidanweiContent;


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
	 * 设置：二级单位名称
	 */
    public String getErjidanweiName() {
        return erjidanweiName;
    }
    /**
	 * 获取：二级单位名称
	 */

    public void setErjidanweiName(String erjidanweiName) {
        this.erjidanweiName = erjidanweiName;
    }
    /**
	 * 设置：二级单位联系方式
	 */
    public String getErjidanweiPhone() {
        return erjidanweiPhone;
    }
    /**
	 * 获取：二级单位联系方式
	 */

    public void setErjidanweiPhone(String erjidanweiPhone) {
        this.erjidanweiPhone = erjidanweiPhone;
    }
    /**
	 * 设置：二级单位邮箱
	 */
    public String getErjidanweiEmail() {
        return erjidanweiEmail;
    }
    /**
	 * 获取：二级单位邮箱
	 */

    public void setErjidanweiEmail(String erjidanweiEmail) {
        this.erjidanweiEmail = erjidanweiEmail;
    }
    /**
	 * 设置：二级单位介绍
	 */
    public String getErjidanweiContent() {
        return erjidanweiContent;
    }
    /**
	 * 获取：二级单位介绍
	 */

    public void setErjidanweiContent(String erjidanweiContent) {
        this.erjidanweiContent = erjidanweiContent;
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
        return "Erjidanwei{" +
            "id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", erjidanweiName=" + erjidanweiName +
            ", erjidanweiPhone=" + erjidanweiPhone +
            ", erjidanweiEmail=" + erjidanweiEmail +
            ", erjidanweiContent=" + erjidanweiContent +
            ", createTime=" + createTime +
        "}";
    }
}
