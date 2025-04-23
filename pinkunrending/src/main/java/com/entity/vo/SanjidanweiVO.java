package com.entity.vo;

import com.entity.SanjidanweiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 三级单位
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("sanjidanwei")
public class SanjidanweiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

}
