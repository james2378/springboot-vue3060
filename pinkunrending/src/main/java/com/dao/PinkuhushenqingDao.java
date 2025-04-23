package com.dao;

import com.entity.PinkuhushenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.PinkuhushenqingView;

/**
 * 贫困申请 Dao 接口
 *
 * @author 
 */
public interface PinkuhushenqingDao extends BaseMapper<PinkuhushenqingEntity> {

   List<PinkuhushenqingView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
