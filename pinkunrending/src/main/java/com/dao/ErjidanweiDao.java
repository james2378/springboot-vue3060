package com.dao;

import com.entity.ErjidanweiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ErjidanweiView;

/**
 * 二级单位 Dao 接口
 *
 * @author 
 */
public interface ErjidanweiDao extends BaseMapper<ErjidanweiEntity> {

   List<ErjidanweiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
