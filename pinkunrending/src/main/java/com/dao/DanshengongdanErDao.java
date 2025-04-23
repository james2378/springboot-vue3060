package com.dao;

import com.entity.DanshengongdanErEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.DanshengongdanErView;

/**
 * 二级单位审核 Dao 接口
 *
 * @author 
 */
public interface DanshengongdanErDao extends BaseMapper<DanshengongdanErEntity> {

   List<DanshengongdanErView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
