package com.entity.view;

import com.entity.DanshengongdanErEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 二级单位审核
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("danshengongdan_er")
public class DanshengongdanErView extends DanshengongdanErEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 审核状态的值
		*/
		private String danshengongdanErYesnoValue;



		//级联表 erjidanwei
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

		//级联表 pinkuhushenqing
			/**
			* 贫困申请 的 用户
			*/
			private Integer pinkuhushenqingYonghuId;
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
				* 性别的值
				*/
				private String sexValue;
			/**
			* 年龄
			*/
			private Integer age;
			/**
			* 政治面貌
			*/
			private Integer zhengzhiTypes;
				/**
				* 政治面貌的值
				*/
				private String zhengzhiValue;
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
				* 申请类型的值
				*/
				private String pinkuhushenqingShenqingValue;
			/**
			* 居委会开具证明
			*/
			private String pinkuhushenqingJuweihuiFile;
			/**
			* 申请内容
			*/
			private String pinkuhushenqingContent;
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

	public DanshengongdanErView() {

	}

	public DanshengongdanErView(DanshengongdanErEntity danshengongdanErEntity) {
		try {
			BeanUtils.copyProperties(this, danshengongdanErEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 审核状态的值
			*/
			public String getDanshengongdanErYesnoValue() {
				return danshengongdanErYesnoValue;
			}
			/**
			* 设置： 审核状态的值
			*/
			public void setDanshengongdanErYesnoValue(String danshengongdanErYesnoValue) {
				this.danshengongdanErYesnoValue = danshengongdanErYesnoValue;
			}




















				//级联表的get和set erjidanwei

					/**
					* 获取： 二级单位名称
					*/
					public String getErjidanweiName() {
						return erjidanweiName;
					}
					/**
					* 设置： 二级单位名称
					*/
					public void setErjidanweiName(String erjidanweiName) {
						this.erjidanweiName = erjidanweiName;
					}

					/**
					* 获取： 二级单位联系方式
					*/
					public String getErjidanweiPhone() {
						return erjidanweiPhone;
					}
					/**
					* 设置： 二级单位联系方式
					*/
					public void setErjidanweiPhone(String erjidanweiPhone) {
						this.erjidanweiPhone = erjidanweiPhone;
					}

					/**
					* 获取： 二级单位邮箱
					*/
					public String getErjidanweiEmail() {
						return erjidanweiEmail;
					}
					/**
					* 设置： 二级单位邮箱
					*/
					public void setErjidanweiEmail(String erjidanweiEmail) {
						this.erjidanweiEmail = erjidanweiEmail;
					}

					/**
					* 获取： 二级单位介绍
					*/
					public String getErjidanweiContent() {
						return erjidanweiContent;
					}
					/**
					* 设置： 二级单位介绍
					*/
					public void setErjidanweiContent(String erjidanweiContent) {
						this.erjidanweiContent = erjidanweiContent;
					}








				//级联表的get和set pinkuhushenqing

					/**
					* 获取：贫困申请 的 用户
					*/
					public Integer getPinkuhushenqingYonghuId() {
						return pinkuhushenqingYonghuId;
					}
					/**
					* 设置：贫困申请 的 用户
					*/
					public void setPinkuhushenqingYonghuId(Integer pinkuhushenqingYonghuId) {
						this.pinkuhushenqingYonghuId = pinkuhushenqingYonghuId;
					}


					/**
					* 获取： 贫困申请编号
					*/
					public String getPinkuhushenqingUuidNumber() {
						return pinkuhushenqingUuidNumber;
					}
					/**
					* 设置： 贫困申请编号
					*/
					public void setPinkuhushenqingUuidNumber(String pinkuhushenqingUuidNumber) {
						this.pinkuhushenqingUuidNumber = pinkuhushenqingUuidNumber;
					}

					/**
					* 获取： 姓名
					*/
					public String getPinkuhushenqingName() {
						return pinkuhushenqingName;
					}
					/**
					* 设置： 姓名
					*/
					public void setPinkuhushenqingName(String pinkuhushenqingName) {
						this.pinkuhushenqingName = pinkuhushenqingName;
					}

					/**
					* 获取： 性别
					*/
					public Integer getSexTypes() {
						return sexTypes;
					}
					/**
					* 设置： 性别
					*/
					public void setSexTypes(Integer sexTypes) {
						this.sexTypes = sexTypes;
					}


						/**
						* 获取： 性别的值
						*/
						public String getSexValue() {
							return sexValue;
						}
						/**
						* 设置： 性别的值
						*/
						public void setSexValue(String sexValue) {
							this.sexValue = sexValue;
						}

					/**
					* 获取： 年龄
					*/
					public Integer getAge() {
						return age;
					}
					/**
					* 设置： 年龄
					*/
					public void setAge(Integer age) {
						this.age = age;
					}

					/**
					* 获取： 政治面貌
					*/
					public Integer getZhengzhiTypes() {
						return zhengzhiTypes;
					}
					/**
					* 设置： 政治面貌
					*/
					public void setZhengzhiTypes(Integer zhengzhiTypes) {
						this.zhengzhiTypes = zhengzhiTypes;
					}


						/**
						* 获取： 政治面貌的值
						*/
						public String getZhengzhiValue() {
							return zhengzhiValue;
						}
						/**
						* 设置： 政治面貌的值
						*/
						public void setZhengzhiValue(String zhengzhiValue) {
							this.zhengzhiValue = zhengzhiValue;
						}

					/**
					* 获取： 联系方式
					*/
					public String getPinkuhushenqingShenfenzhengPhone() {
						return pinkuhushenqingShenfenzhengPhone;
					}
					/**
					* 设置： 联系方式
					*/
					public void setPinkuhushenqingShenfenzhengPhone(String pinkuhushenqingShenfenzhengPhone) {
						this.pinkuhushenqingShenfenzhengPhone = pinkuhushenqingShenfenzhengPhone;
					}

					/**
					* 获取： 身份证号
					*/
					public String getPinkuhushenqingShenfenzhengIdNumber() {
						return pinkuhushenqingShenfenzhengIdNumber;
					}
					/**
					* 设置： 身份证号
					*/
					public void setPinkuhushenqingShenfenzhengIdNumber(String pinkuhushenqingShenfenzhengIdNumber) {
						this.pinkuhushenqingShenfenzhengIdNumber = pinkuhushenqingShenfenzhengIdNumber;
					}

					/**
					* 获取： 身份证人像面
					*/
					public String getPinkuhushenqingShenfenzhengRenxiangPhoto() {
						return pinkuhushenqingShenfenzhengRenxiangPhoto;
					}
					/**
					* 设置： 身份证人像面
					*/
					public void setPinkuhushenqingShenfenzhengRenxiangPhoto(String pinkuhushenqingShenfenzhengRenxiangPhoto) {
						this.pinkuhushenqingShenfenzhengRenxiangPhoto = pinkuhushenqingShenfenzhengRenxiangPhoto;
					}

					/**
					* 获取： 身份证国徽面
					*/
					public String getPinkuhushenqingShenfenzhengGuohuiPhoto() {
						return pinkuhushenqingShenfenzhengGuohuiPhoto;
					}
					/**
					* 设置： 身份证国徽面
					*/
					public void setPinkuhushenqingShenfenzhengGuohuiPhoto(String pinkuhushenqingShenfenzhengGuohuiPhoto) {
						this.pinkuhushenqingShenfenzhengGuohuiPhoto = pinkuhushenqingShenfenzhengGuohuiPhoto;
					}

					/**
					* 获取： 申请类型
					*/
					public Integer getPinkuhushenqingShenqingTypes() {
						return pinkuhushenqingShenqingTypes;
					}
					/**
					* 设置： 申请类型
					*/
					public void setPinkuhushenqingShenqingTypes(Integer pinkuhushenqingShenqingTypes) {
						this.pinkuhushenqingShenqingTypes = pinkuhushenqingShenqingTypes;
					}


						/**
						* 获取： 申请类型的值
						*/
						public String getPinkuhushenqingShenqingValue() {
							return pinkuhushenqingShenqingValue;
						}
						/**
						* 设置： 申请类型的值
						*/
						public void setPinkuhushenqingShenqingValue(String pinkuhushenqingShenqingValue) {
							this.pinkuhushenqingShenqingValue = pinkuhushenqingShenqingValue;
						}

					/**
					* 获取： 居委会开具证明
					*/
					public String getPinkuhushenqingJuweihuiFile() {
						return pinkuhushenqingJuweihuiFile;
					}
					/**
					* 设置： 居委会开具证明
					*/
					public void setPinkuhushenqingJuweihuiFile(String pinkuhushenqingJuweihuiFile) {
						this.pinkuhushenqingJuweihuiFile = pinkuhushenqingJuweihuiFile;
					}

					/**
					* 获取： 申请内容
					*/
					public String getPinkuhushenqingContent() {
						return pinkuhushenqingContent;
					}
					/**
					* 设置： 申请内容
					*/
					public void setPinkuhushenqingContent(String pinkuhushenqingContent) {
						this.pinkuhushenqingContent = pinkuhushenqingContent;
					}

					/**
					* 获取： 一级单位审核结果
					*/
					public String getPinkuhushenqingYiJieguo() {
						return pinkuhushenqingYiJieguo;
					}
					/**
					* 设置： 一级单位审核结果
					*/
					public void setPinkuhushenqingYiJieguo(String pinkuhushenqingYiJieguo) {
						this.pinkuhushenqingYiJieguo = pinkuhushenqingYiJieguo;
					}

					/**
					* 获取： 一级单位审核意见
					*/
					public String getPinkuhushenqingYiYijian() {
						return pinkuhushenqingYiYijian;
					}
					/**
					* 设置： 一级单位审核意见
					*/
					public void setPinkuhushenqingYiYijian(String pinkuhushenqingYiYijian) {
						this.pinkuhushenqingYiYijian = pinkuhushenqingYiYijian;
					}

					/**
					* 获取： 一级单位审核时间
					*/
					public Date getPinkuhushenqingYiTime() {
						return pinkuhushenqingYiTime;
					}
					/**
					* 设置： 一级单位审核时间
					*/
					public void setPinkuhushenqingYiTime(Date pinkuhushenqingYiTime) {
						this.pinkuhushenqingYiTime = pinkuhushenqingYiTime;
					}

					/**
					* 获取： 二级单位审核结果
					*/
					public String getPinkuhushenqingErJieguo() {
						return pinkuhushenqingErJieguo;
					}
					/**
					* 设置： 二级单位审核结果
					*/
					public void setPinkuhushenqingErJieguo(String pinkuhushenqingErJieguo) {
						this.pinkuhushenqingErJieguo = pinkuhushenqingErJieguo;
					}

					/**
					* 获取： 二级单位审核意见
					*/
					public String getPinkuhushenqingErYijian() {
						return pinkuhushenqingErYijian;
					}
					/**
					* 设置： 二级单位审核意见
					*/
					public void setPinkuhushenqingErYijian(String pinkuhushenqingErYijian) {
						this.pinkuhushenqingErYijian = pinkuhushenqingErYijian;
					}

					/**
					* 获取： 二级单位审核时间
					*/
					public Date getPinkuhushenqingErTime() {
						return pinkuhushenqingErTime;
					}
					/**
					* 设置： 二级单位审核时间
					*/
					public void setPinkuhushenqingErTime(Date pinkuhushenqingErTime) {
						this.pinkuhushenqingErTime = pinkuhushenqingErTime;
					}

					/**
					* 获取： 三级单位审核结果
					*/
					public String getPinkuhushenqingSanJieguo() {
						return pinkuhushenqingSanJieguo;
					}
					/**
					* 设置： 三级单位审核结果
					*/
					public void setPinkuhushenqingSanJieguo(String pinkuhushenqingSanJieguo) {
						this.pinkuhushenqingSanJieguo = pinkuhushenqingSanJieguo;
					}

					/**
					* 获取： 三级单位审核意见
					*/
					public String getPinkuhushenqingSanYijian() {
						return pinkuhushenqingSanYijian;
					}
					/**
					* 设置： 三级单位审核意见
					*/
					public void setPinkuhushenqingSanYijian(String pinkuhushenqingSanYijian) {
						this.pinkuhushenqingSanYijian = pinkuhushenqingSanYijian;
					}

					/**
					* 获取： 三级单位审核时间
					*/
					public Date getPinkuhushenqingSanTime() {
						return pinkuhushenqingSanTime;
					}
					/**
					* 设置： 三级单位审核时间
					*/
					public void setPinkuhushenqingSanTime(Date pinkuhushenqingSanTime) {
						this.pinkuhushenqingSanTime = pinkuhushenqingSanTime;
					}










}
