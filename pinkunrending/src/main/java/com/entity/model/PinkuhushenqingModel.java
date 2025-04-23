package com.entity.model;

import com.entity.PinkuhushenqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 贫困申请
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class PinkuhushenqingModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 贫困申请编号
     */
    private String pinkuhushenqingUuidNumber;


    /**
     * 姓名
     */
    private String pinkuhushenqingName;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 年龄
     */
    private Integer age;


    /**
     * 政治面貌
     */
    private Integer zhengzhiTypes;


    /**
     * 联系方式
     */
    private String pinkuhushenqingShenfenzhengPhone;


    /**
     * 身份证号
     */
    private String pinkuhushenqingShenfenzhengIdNumber;


    /**
     * 身份证人像面
     */
    private String pinkuhushenqingShenfenzhengRenxiangPhoto;


    /**
     * 身份证国徽面
     */
    private String pinkuhushenqingShenfenzhengGuohuiPhoto;


    /**
     * 申请类型
     */
    private Integer pinkuhushenqingShenqingTypes;


    /**
     * 居委会开具证明
     */
    private String pinkuhushenqingJuweihuiFile;


    /**
     * 申请内容
     */
    private String pinkuhushenqingContent;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 一级单位审核结果
     */
    private String pinkuhushenqingYiJieguo;


    /**
     * 一级单位审核意见
     */
    private String pinkuhushenqingYiYijian;


    /**
     * 一级单位审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date pinkuhushenqingYiTime;


    /**
     * 二级单位审核结果
     */
    private String pinkuhushenqingErJieguo;


    /**
     * 二级单位审核意见
     */
    private String pinkuhushenqingErYijian;


    /**
     * 二级单位审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date pinkuhushenqingErTime;


    /**
     * 三级单位审核结果
     */
    private String pinkuhushenqingSanJieguo;


    /**
     * 三级单位审核意见
     */
    private String pinkuhushenqingSanYijian;


    /**
     * 三级单位审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date pinkuhushenqingSanTime;


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
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：贫困申请编号
	 */
    public String getPinkuhushenqingUuidNumber() {
        return pinkuhushenqingUuidNumber;
    }


    /**
	 * 设置：贫困申请编号
	 */
    public void setPinkuhushenqingUuidNumber(String pinkuhushenqingUuidNumber) {
        this.pinkuhushenqingUuidNumber = pinkuhushenqingUuidNumber;
    }
    /**
	 * 获取：姓名
	 */
    public String getPinkuhushenqingName() {
        return pinkuhushenqingName;
    }


    /**
	 * 设置：姓名
	 */
    public void setPinkuhushenqingName(String pinkuhushenqingName) {
        this.pinkuhushenqingName = pinkuhushenqingName;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：年龄
	 */
    public Integer getAge() {
        return age;
    }


    /**
	 * 设置：年龄
	 */
    public void setAge(Integer age) {
        this.age = age;
    }
    /**
	 * 获取：政治面貌
	 */
    public Integer getZhengzhiTypes() {
        return zhengzhiTypes;
    }


    /**
	 * 设置：政治面貌
	 */
    public void setZhengzhiTypes(Integer zhengzhiTypes) {
        this.zhengzhiTypes = zhengzhiTypes;
    }
    /**
	 * 获取：联系方式
	 */
    public String getPinkuhushenqingShenfenzhengPhone() {
        return pinkuhushenqingShenfenzhengPhone;
    }


    /**
	 * 设置：联系方式
	 */
    public void setPinkuhushenqingShenfenzhengPhone(String pinkuhushenqingShenfenzhengPhone) {
        this.pinkuhushenqingShenfenzhengPhone = pinkuhushenqingShenfenzhengPhone;
    }
    /**
	 * 获取：身份证号
	 */
    public String getPinkuhushenqingShenfenzhengIdNumber() {
        return pinkuhushenqingShenfenzhengIdNumber;
    }


    /**
	 * 设置：身份证号
	 */
    public void setPinkuhushenqingShenfenzhengIdNumber(String pinkuhushenqingShenfenzhengIdNumber) {
        this.pinkuhushenqingShenfenzhengIdNumber = pinkuhushenqingShenfenzhengIdNumber;
    }
    /**
	 * 获取：身份证人像面
	 */
    public String getPinkuhushenqingShenfenzhengRenxiangPhoto() {
        return pinkuhushenqingShenfenzhengRenxiangPhoto;
    }


    /**
	 * 设置：身份证人像面
	 */
    public void setPinkuhushenqingShenfenzhengRenxiangPhoto(String pinkuhushenqingShenfenzhengRenxiangPhoto) {
        this.pinkuhushenqingShenfenzhengRenxiangPhoto = pinkuhushenqingShenfenzhengRenxiangPhoto;
    }
    /**
	 * 获取：身份证国徽面
	 */
    public String getPinkuhushenqingShenfenzhengGuohuiPhoto() {
        return pinkuhushenqingShenfenzhengGuohuiPhoto;
    }


    /**
	 * 设置：身份证国徽面
	 */
    public void setPinkuhushenqingShenfenzhengGuohuiPhoto(String pinkuhushenqingShenfenzhengGuohuiPhoto) {
        this.pinkuhushenqingShenfenzhengGuohuiPhoto = pinkuhushenqingShenfenzhengGuohuiPhoto;
    }
    /**
	 * 获取：申请类型
	 */
    public Integer getPinkuhushenqingShenqingTypes() {
        return pinkuhushenqingShenqingTypes;
    }


    /**
	 * 设置：申请类型
	 */
    public void setPinkuhushenqingShenqingTypes(Integer pinkuhushenqingShenqingTypes) {
        this.pinkuhushenqingShenqingTypes = pinkuhushenqingShenqingTypes;
    }
    /**
	 * 获取：居委会开具证明
	 */
    public String getPinkuhushenqingJuweihuiFile() {
        return pinkuhushenqingJuweihuiFile;
    }


    /**
	 * 设置：居委会开具证明
	 */
    public void setPinkuhushenqingJuweihuiFile(String pinkuhushenqingJuweihuiFile) {
        this.pinkuhushenqingJuweihuiFile = pinkuhushenqingJuweihuiFile;
    }
    /**
	 * 获取：申请内容
	 */
    public String getPinkuhushenqingContent() {
        return pinkuhushenqingContent;
    }


    /**
	 * 设置：申请内容
	 */
    public void setPinkuhushenqingContent(String pinkuhushenqingContent) {
        this.pinkuhushenqingContent = pinkuhushenqingContent;
    }
    /**
	 * 获取：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：申请时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：一级单位审核结果
	 */
    public String getPinkuhushenqingYiJieguo() {
        return pinkuhushenqingYiJieguo;
    }


    /**
	 * 设置：一级单位审核结果
	 */
    public void setPinkuhushenqingYiJieguo(String pinkuhushenqingYiJieguo) {
        this.pinkuhushenqingYiJieguo = pinkuhushenqingYiJieguo;
    }
    /**
	 * 获取：一级单位审核意见
	 */
    public String getPinkuhushenqingYiYijian() {
        return pinkuhushenqingYiYijian;
    }


    /**
	 * 设置：一级单位审核意见
	 */
    public void setPinkuhushenqingYiYijian(String pinkuhushenqingYiYijian) {
        this.pinkuhushenqingYiYijian = pinkuhushenqingYiYijian;
    }
    /**
	 * 获取：一级单位审核时间
	 */
    public Date getPinkuhushenqingYiTime() {
        return pinkuhushenqingYiTime;
    }


    /**
	 * 设置：一级单位审核时间
	 */
    public void setPinkuhushenqingYiTime(Date pinkuhushenqingYiTime) {
        this.pinkuhushenqingYiTime = pinkuhushenqingYiTime;
    }
    /**
	 * 获取：二级单位审核结果
	 */
    public String getPinkuhushenqingErJieguo() {
        return pinkuhushenqingErJieguo;
    }


    /**
	 * 设置：二级单位审核结果
	 */
    public void setPinkuhushenqingErJieguo(String pinkuhushenqingErJieguo) {
        this.pinkuhushenqingErJieguo = pinkuhushenqingErJieguo;
    }
    /**
	 * 获取：二级单位审核意见
	 */
    public String getPinkuhushenqingErYijian() {
        return pinkuhushenqingErYijian;
    }


    /**
	 * 设置：二级单位审核意见
	 */
    public void setPinkuhushenqingErYijian(String pinkuhushenqingErYijian) {
        this.pinkuhushenqingErYijian = pinkuhushenqingErYijian;
    }
    /**
	 * 获取：二级单位审核时间
	 */
    public Date getPinkuhushenqingErTime() {
        return pinkuhushenqingErTime;
    }


    /**
	 * 设置：二级单位审核时间
	 */
    public void setPinkuhushenqingErTime(Date pinkuhushenqingErTime) {
        this.pinkuhushenqingErTime = pinkuhushenqingErTime;
    }
    /**
	 * 获取：三级单位审核结果
	 */
    public String getPinkuhushenqingSanJieguo() {
        return pinkuhushenqingSanJieguo;
    }


    /**
	 * 设置：三级单位审核结果
	 */
    public void setPinkuhushenqingSanJieguo(String pinkuhushenqingSanJieguo) {
        this.pinkuhushenqingSanJieguo = pinkuhushenqingSanJieguo;
    }
    /**
	 * 获取：三级单位审核意见
	 */
    public String getPinkuhushenqingSanYijian() {
        return pinkuhushenqingSanYijian;
    }


    /**
	 * 设置：三级单位审核意见
	 */
    public void setPinkuhushenqingSanYijian(String pinkuhushenqingSanYijian) {
        this.pinkuhushenqingSanYijian = pinkuhushenqingSanYijian;
    }
    /**
	 * 获取：三级单位审核时间
	 */
    public Date getPinkuhushenqingSanTime() {
        return pinkuhushenqingSanTime;
    }


    /**
	 * 设置：三级单位审核时间
	 */
    public void setPinkuhushenqingSanTime(Date pinkuhushenqingSanTime) {
        this.pinkuhushenqingSanTime = pinkuhushenqingSanTime;
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
