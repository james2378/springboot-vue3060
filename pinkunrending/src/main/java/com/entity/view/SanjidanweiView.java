package com.entity.view;

import com.entity.SanjidanweiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 三级单位
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("sanjidanwei")
public class SanjidanweiView extends SanjidanweiEntity implements Serializable {
    private static final long serialVersionUID = 1L;




	public SanjidanweiView() {

	}

	public SanjidanweiView(SanjidanweiEntity sanjidanweiEntity) {
		try {
			BeanUtils.copyProperties(this, sanjidanweiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

















}
