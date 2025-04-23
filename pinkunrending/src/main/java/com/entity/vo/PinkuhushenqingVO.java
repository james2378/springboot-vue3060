package com.entity.vo;

import com.entity.PinkuhushenqingEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 贫困申请
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("pinkuhushenqing")
public class PinkuhushenqingVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 贫困申请编号
     */

    @TableField(value = "pinkuhushenqing_uuid_number")
    private String pinkuhushenqingUuidNumber;


    /**
     * 姓名
     */

    @TableField(value = "pinkuhushenqing_name")
    private String pinkuhushenqingName;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 年龄
     */

    @TableField(value = "age")
    private Integer age;


    /**
     * 政治面貌
     */

    @TableField(value = "zhengzhi_types")
    private Integer zhengzhiTypes;


    /**
     * 联系方式
     */

    @TableField(value = "pinkuhushenqing_shenfenzheng_phone")
    private String pinkuhushenqingShenfenzhengPhone;


    /**
     * 身份证号
     */

    @TableField(value = "pinkuhushenqing_shenfenzheng_id_number")
    private String pinkuhushenqingShenfenzhengIdNumber;


    /**
     * 身份证人像面
     */

    @TableField(value = "pinkuhushenqing_shenfenzheng_renxiang_photo")
    private String pinkuhushenqingShenfenzhengRenxiangPhoto;


    /**
     * 身份证国徽面
     */

    @TableField(value = "pinkuhushenqing_shenfenzheng_guohui_photo")
    private String pinkuhushenqingShenfenzhengGuohuiPhoto;


    /**
     * 申请类型
     */

    @TableField(value = "pinkuhushenqing_shenqing_types")
    private Integer pinkuhushenqingShenqingTypes;


    /**
     * 居委会开具证明
     */

    @TableField(value = "pinkuhushenqing_juweihui_file")
    private String pinkuhushenqingJuweihuiFile;


    /**
     * 申请内容
     */

    @TableField(value = "pinkuhushenqing_content")
    private String pinkuhushenqingContent;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 一级单位审核结果
     */

    @TableField(value = "pinkuhushenqing_yi_jieguo")
    private String pinkuhushenqingYiJieguo;


    /**
     * 一级单位审核意见
     */

    @TableField(value = "pinkuhushenqing_yi_yijian")
    private String pinkuhushenqingYiYijian;


    /**
     * 一级单位审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "pinkuhushenqing_yi_time")
    private Date pinkuhushenqingYiTime;


    /**
     * 二级单位审核结果
     */

    @TableField(value = "pinkuhushenqing_er_jieguo")
    private String pinkuhushenqingErJieguo;


    /**
     * 二级单位审核意见
     */

    @TableField(value = "pinkuhushenqing_er_yijian")
    private String pinkuhushenqingErYijian;


    /**
     * 二级单位审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "pinkuhushenqing_er_time")
    private Date pinkuhushenqingErTime;


    /**
     * 三级单位审核结果
     */

    @TableField(value = "pinkuhushenqing_san_jieguo")
    private String pinkuhushenqingSanJieguo;


    /**
     * 三级单位审核意见
     */

    @TableField(value = "pinkuhushenqing_san_yijian")
    private String pinkuhushenqingSanYijian;


    /**
     * 三级单位审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "pinkuhushenqing_san_time")
    private Date pinkuhushenqingSanTime;


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
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：贫困申请编号
	 */
    public String getPinkuhushenqingUuidNumber() {
        return pinkuhushenqingUuidNumber;
    }


    /**
	 * 获取：贫困申请编号
	 */

    public void setPinkuhushenqingUuidNumber(String pinkuhushenqingUuidNumber) {
        this.pinkuhushenqingUuidNumber = pinkuhushenqingUuidNumber;
    }
    /**
	 * 设置：姓名
	 */
    public String getPinkuhushenqingName() {
        return pinkuhushenqingName;
    }


    /**
	 * 获取：姓名
	 */

    public void setPinkuhushenqingName(String pinkuhushenqingName) {
        this.pinkuhushenqingName = pinkuhushenqingName;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：年龄
	 */
    public Integer getAge() {
        return age;
    }


    /**
	 * 获取：年龄
	 */

    public void setAge(Integer age) {
        this.age = age;
    }
    /**
	 * 设置：政治面貌
	 */
    public Integer getZhengzhiTypes() {
        return zhengzhiTypes;
    }


    /**
	 * 获取：政治面貌
	 */

    public void setZhengzhiTypes(Integer zhengzhiTypes) {
        this.zhengzhiTypes = zhengzhiTypes;
    }
    /**
	 * 设置：联系方式
	 */
    public String getPinkuhushenqingShenfenzhengPhone() {
        return pinkuhushenqingShenfenzhengPhone;
    }


    /**
	 * 获取：联系方式
	 */

    public void setPinkuhushenqingShenfenzhengPhone(String pinkuhushenqingShenfenzhengPhone) {
        this.pinkuhushenqingShenfenzhengPhone = pinkuhushenqingShenfenzhengPhone;
    }
    /**
	 * 设置：身份证号
	 */
    public String getPinkuhushenqingShenfenzhengIdNumber() {
        return pinkuhushenqingShenfenzhengIdNumber;
    }


    /**
	 * 获取：身份证号
	 */

    public void setPinkuhushenqingShenfenzhengIdNumber(String pinkuhushenqingShenfenzhengIdNumber) {
        this.pinkuhushenqingShenfenzhengIdNumber = pinkuhushenqingShenfenzhengIdNumber;
    }
    /**
	 * 设置：身份证人像面
	 */
    public String getPinkuhushenqingShenfenzhengRenxiangPhoto() {
        return pinkuhushenqingShenfenzhengRenxiangPhoto;
    }


    /**
	 * 获取：身份证人像面
	 */

    public void setPinkuhushenqingShenfenzhengRenxiangPhoto(String pinkuhushenqingShenfenzhengRenxiangPhoto) {
        this.pinkuhushenqingShenfenzhengRenxiangPhoto = pinkuhushenqingShenfenzhengRenxiangPhoto;
    }
    /**
	 * 设置：身份证国徽面
	 */
    public String getPinkuhushenqingShenfenzhengGuohuiPhoto() {
        return pinkuhushenqingShenfenzhengGuohuiPhoto;
    }


    /**
	 * 获取：身份证国徽面
	 */

    public void setPinkuhushenqingShenfenzhengGuohuiPhoto(String pinkuhushenqingShenfenzhengGuohuiPhoto) {
        this.pinkuhushenqingShenfenzhengGuohuiPhoto = pinkuhushenqingShenfenzhengGuohuiPhoto;
    }
    /**
	 * 设置：申请类型
	 */
    public Integer getPinkuhushenqingShenqingTypes() {
        return pinkuhushenqingShenqingTypes;
    }


    /**
	 * 获取：申请类型
	 */

    public void setPinkuhushenqingShenqingTypes(Integer pinkuhushenqingShenqingTypes) {
        this.pinkuhushenqingShenqingTypes = pinkuhushenqingShenqingTypes;
    }
    /**
	 * 设置：居委会开具证明
	 */
    public String getPinkuhushenqingJuweihuiFile() {
        return pinkuhushenqingJuweihuiFile;
    }


    /**
	 * 获取：居委会开具证明
	 */

    public void setPinkuhushenqingJuweihuiFile(String pinkuhushenqingJuweihuiFile) {
        this.pinkuhushenqingJuweihuiFile = pinkuhushenqingJuweihuiFile;
    }
    /**
	 * 设置：申请内容
	 */
    public String getPinkuhushenqingContent() {
        return pinkuhushenqingContent;
    }


    /**
	 * 获取：申请内容
	 */

    public void setPinkuhushenqingContent(String pinkuhushenqingContent) {
        this.pinkuhushenqingContent = pinkuhushenqingContent;
    }
    /**
	 * 设置：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：一级单位审核结果
	 */
    public String getPinkuhushenqingYiJieguo() {
        return pinkuhushenqingYiJieguo;
    }


    /**
	 * 获取：一级单位审核结果
	 */

    public void setPinkuhushenqingYiJieguo(String pinkuhushenqingYiJieguo) {
        this.pinkuhushenqingYiJieguo = pinkuhushenqingYiJieguo;
    }
    /**
	 * 设置：一级单位审核意见
	 */
    public String getPinkuhushenqingYiYijian() {
        return pinkuhushenqingYiYijian;
    }


    /**
	 * 获取：一级单位审核意见
	 */

    public void setPinkuhushenqingYiYijian(String pinkuhushenqingYiYijian) {
        this.pinkuhushenqingYiYijian = pinkuhushenqingYiYijian;
    }
    /**
	 * 设置：一级单位审核时间
	 */
    public Date getPinkuhushenqingYiTime() {
        return pinkuhushenqingYiTime;
    }


    /**
	 * 获取：一级单位审核时间
	 */

    public void setPinkuhushenqingYiTime(Date pinkuhushenqingYiTime) {
        this.pinkuhushenqingYiTime = pinkuhushenqingYiTime;
    }
    /**
	 * 设置：二级单位审核结果
	 */
    public String getPinkuhushenqingErJieguo() {
        return pinkuhushenqingErJieguo;
    }


    /**
	 * 获取：二级单位审核结果
	 */

    public void setPinkuhushenqingErJieguo(String pinkuhushenqingErJieguo) {
        this.pinkuhushenqingErJieguo = pinkuhushenqingErJieguo;
    }
    /**
	 * 设置：二级单位审核意见
	 */
    public String getPinkuhushenqingErYijian() {
        return pinkuhushenqingErYijian;
    }


    /**
	 * 获取：二级单位审核意见
	 */

    public void setPinkuhushenqingErYijian(String pinkuhushenqingErYijian) {
        this.pinkuhushenqingErYijian = pinkuhushenqingErYijian;
    }
    /**
	 * 设置：二级单位审核时间
	 */
    public Date getPinkuhushenqingErTime() {
        return pinkuhushenqingErTime;
    }


    /**
	 * 获取：二级单位审核时间
	 */

    public void setPinkuhushenqingErTime(Date pinkuhushenqingErTime) {
        this.pinkuhushenqingErTime = pinkuhushenqingErTime;
    }
    /**
	 * 设置：三级单位审核结果
	 */
    public String getPinkuhushenqingSanJieguo() {
        return pinkuhushenqingSanJieguo;
    }


    /**
	 * 获取：三级单位审核结果
	 */

    public void setPinkuhushenqingSanJieguo(String pinkuhushenqingSanJieguo) {
        this.pinkuhushenqingSanJieguo = pinkuhushenqingSanJieguo;
    }
    /**
	 * 设置：三级单位审核意见
	 */
    public String getPinkuhushenqingSanYijian() {
        return pinkuhushenqingSanYijian;
    }


    /**
	 * 获取：三级单位审核意见
	 */

    public void setPinkuhushenqingSanYijian(String pinkuhushenqingSanYijian) {
        this.pinkuhushenqingSanYijian = pinkuhushenqingSanYijian;
    }
    /**
	 * 设置：三级单位审核时间
	 */
    public Date getPinkuhushenqingSanTime() {
        return pinkuhushenqingSanTime;
    }


    /**
	 * 获取：三级单位审核时间
	 */

    public void setPinkuhushenqingSanTime(Date pinkuhushenqingSanTime) {
        this.pinkuhushenqingSanTime = pinkuhushenqingSanTime;
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
