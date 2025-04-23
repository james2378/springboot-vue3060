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
 * 一级单位
 *
 * @author 
 * @email
 */
@TableName("yijidanwei")
public class YijidanweiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YijidanweiEntity() {

	}

	public YijidanweiEntity(T t) {
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
     * 一级单位名称
     */
    @TableField(value = "yijidanwei_name")

    private String yijidanweiName;


    /**
     * 一级单位联系方式
     */
    @TableField(value = "yijidanwei_phone")

    private String yijidanweiPhone;


    /**
     * 一级单位邮箱
     */
    @TableField(value = "yijidanwei_email")

    private String yijidanweiEmail;


    /**
     * 一级单位介绍
     */
    @TableField(value = "yijidanwei_content")

    private String yijidanweiContent;


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
	 * 设置：一级单位名称
	 */
    public String getYijidanweiName() {
        return yijidanweiName;
    }
    /**
	 * 获取：一级单位名称
	 */

    public void setYijidanweiName(String yijidanweiName) {
        this.yijidanweiName = yijidanweiName;
    }
    /**
	 * 设置：一级单位联系方式
	 */
    public String getYijidanweiPhone() {
        return yijidanweiPhone;
    }
    /**
	 * 获取：一级单位联系方式
	 */

    public void setYijidanweiPhone(String yijidanweiPhone) {
        this.yijidanweiPhone = yijidanweiPhone;
    }
    /**
	 * 设置：一级单位邮箱
	 */
    public String getYijidanweiEmail() {
        return yijidanweiEmail;
    }
    /**
	 * 获取：一级单位邮箱
	 */

    public void setYijidanweiEmail(String yijidanweiEmail) {
        this.yijidanweiEmail = yijidanweiEmail;
    }
    /**
	 * 设置：一级单位介绍
	 */
    public String getYijidanweiContent() {
        return yijidanweiContent;
    }
    /**
	 * 获取：一级单位介绍
	 */

    public void setYijidanweiContent(String yijidanweiContent) {
        this.yijidanweiContent = yijidanweiContent;
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
        return "Yijidanwei{" +
            "id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", yijidanweiName=" + yijidanweiName +
            ", yijidanweiPhone=" + yijidanweiPhone +
            ", yijidanweiEmail=" + yijidanweiEmail +
            ", yijidanweiContent=" + yijidanweiContent +
            ", createTime=" + createTime +
        "}";
    }
}
