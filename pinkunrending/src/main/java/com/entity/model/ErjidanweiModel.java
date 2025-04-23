package com.entity.model;

import com.entity.ErjidanweiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 二级单位
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ErjidanweiModel implements Serializable {
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
     * 二级单位名称
     */
    private String erjidanweiName;


    /**
     * 二级单位联系方式
     */
    private String erjidanweiPhone;


    /**
     * 二级单位邮箱
     */
    private String erjidanweiEmail;


    /**
     * 二级单位介绍
     */
    private String erjidanweiContent;


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
	 * 获取：二级单位名称
	 */
    public String getErjidanweiName() {
        return erjidanweiName;
    }


    /**
	 * 设置：二级单位名称
	 */
    public void setErjidanweiName(String erjidanweiName) {
        this.erjidanweiName = erjidanweiName;
    }
    /**
	 * 获取：二级单位联系方式
	 */
    public String getErjidanweiPhone() {
        return erjidanweiPhone;
    }


    /**
	 * 设置：二级单位联系方式
	 */
    public void setErjidanweiPhone(String erjidanweiPhone) {
        this.erjidanweiPhone = erjidanweiPhone;
    }
    /**
	 * 获取：二级单位邮箱
	 */
    public String getErjidanweiEmail() {
        return erjidanweiEmail;
    }


    /**
	 * 设置：二级单位邮箱
	 */
    public void setErjidanweiEmail(String erjidanweiEmail) {
        this.erjidanweiEmail = erjidanweiEmail;
    }
    /**
	 * 获取：二级单位介绍
	 */
    public String getErjidanweiContent() {
        return erjidanweiContent;
    }


    /**
	 * 设置：二级单位介绍
	 */
    public void setErjidanweiContent(String erjidanweiContent) {
        this.erjidanweiContent = erjidanweiContent;
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
