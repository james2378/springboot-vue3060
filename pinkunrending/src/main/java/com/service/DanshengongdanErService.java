package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DanshengongdanErEntity;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * 二级单位审核 服务类
 */
public interface DanshengongdanErService extends IService<DanshengongdanErEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}