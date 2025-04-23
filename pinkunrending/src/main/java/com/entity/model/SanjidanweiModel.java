package com.entity.model;

import com.entity.SanjidanweiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 三级单位
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class SanjidanweiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 三级单位名称
     */
    private String sanjidanweiName;


    /**
     * 三级单位联系方式
     */
    private String sanjidanweiPhone;


    /**
     * 三级单位邮箱
     */
    private String sanjidanweiEmail;


    /**
     * 三级单位介绍
     */
    private String sanjidanweiContent;


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
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：三级单位名称
	 */
    public String getSanjidanweiName() {
        return sanjidanweiName;
    }


    /**
	 * 设置：三级单位名称
	 */
    public void setSanjidanweiName(String sanjidanweiName) {
        this.sanjidanweiName = sanjidanweiName;
    }
    /**
	 * 获取：三级单位联系方式
	 */
    public String getSanjidanweiPhone() {
        return sanjidanweiPhone;
    }


    /**
	 * 设置：三级单位联系方式
	 */
    public void setSanjidanweiPhone(String sanjidanweiPhone) {
        this.sanjidanweiPhone = sanjidanweiPhone;
    }
    /**
	 * 获取：三级单位邮箱
	 */
    public String getSanjidanweiEmail() {
        return sanjidanweiEmail;
    }


    /**
	 * 设置：三级单位邮箱
	 */
    public void setSanjidanweiEmail(String sanjidanweiEmail) {
        this.sanjidanweiEmail = sanjidanweiEmail;
    }
    /**
	 * 获取：三级单位介绍
	 */
    public String getSanjidanweiContent() {
        return sanjidanweiContent;
    }


    /**
	 * 设置：三级单位介绍
	 */
    public void setSanjidanweiContent(String sanjidanweiContent) {
        this.sanjidanweiContent = sanjidanweiContent;
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
