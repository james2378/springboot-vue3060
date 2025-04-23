package com.dao;

import com.entity.SanjidanweiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.SanjidanweiView;

/**
 * 三级单位 Dao 接口
 *
 * @author 
 */
public interface SanjidanweiDao extends BaseMapper<SanjidanweiEntity> {

   List<SanjidanweiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
