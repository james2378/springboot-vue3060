package com.entity.vo;

import com.entity.YijidanweiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 一级单位
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yijidanwei")
public class YijidanweiVO implements Serializable {
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

}
