
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 一级单位审核
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/danshengongdanYi")
public class DanshengongdanYiController {
    private static final Logger logger = LoggerFactory.getLogger(DanshengongdanYiController.class);

    @Autowired
    private DanshengongdanYiService danshengongdanYiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private PinkuhushenqingService pinkuhushenqingService;
    @Autowired
    private YijidanweiService yijidanweiService;

    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private ErjidanweiService erjidanweiService;
    @Autowired
    private SanjidanweiService sanjidanweiService;

    @Autowired
    private DanshengongdanErService danshengongdanErService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("二级单位".equals(role))
            params.put("erjidanweiId",request.getSession().getAttribute("userId"));
        else if("三级单位".equals(role))
            params.put("sanjidanweiId",request.getSession().getAttribute("userId"));
        else if("一级单位".equals(role))
            params.put("yijidanweiId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = danshengongdanYiService.queryPage(params);

        //字典表数据转换
        List<DanshengongdanYiView> list =(List<DanshengongdanYiView>)page.getList();
        for(DanshengongdanYiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        DanshengongdanYiEntity danshengongdanYi = danshengongdanYiService.selectById(id);
        if(danshengongdanYi !=null){
            //entity转view
            DanshengongdanYiView view = new DanshengongdanYiView();
            BeanUtils.copyProperties( danshengongdanYi , view );//把实体数据重构到view中

                //级联表
                PinkuhushenqingEntity pinkuhushenqing = pinkuhushenqingService.selectById(danshengongdanYi.getPinkuhushenqingId());
                if(pinkuhushenqing != null){
                    BeanUtils.copyProperties( pinkuhushenqing , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setPinkuhushenqingId(pinkuhushenqing.getId());
                }
                //级联表
                YijidanweiEntity yijidanwei = yijidanweiService.selectById(danshengongdanYi.getYijidanweiId());
                if(yijidanwei != null){
                    BeanUtils.copyProperties( yijidanwei , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYijidanweiId(yijidanwei.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody DanshengongdanYiEntity danshengongdanYi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,danshengongdanYi:{}",this.getClass().getName(),danshengongdanYi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("一级单位".equals(role))
            danshengongdanYi.setYijidanweiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<DanshengongdanYiEntity> queryWrapper = new EntityWrapper<DanshengongdanYiEntity>()
            .eq("pinkuhushenqing_id", danshengongdanYi.getPinkuhushenqingId())
            .eq("yijidanwei_id", danshengongdanYi.getYijidanweiId())
            .eq("danshengongdan_yi_uuid_number", danshengongdanYi.getDanshengongdanYiUuidNumber())
            .eq("danshengongdan_yi_yesno_types", danshengongdanYi.getDanshengongdanYiYesnoTypes())
            .eq("danshengongdan_yi_yesno_text", danshengongdanYi.getDanshengongdanYiYesnoText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DanshengongdanYiEntity danshengongdanYiEntity = danshengongdanYiService.selectOne(queryWrapper);
        if(danshengongdanYiEntity==null){
            danshengongdanYi.setDanshengongdanYiYesnoTypes(1);
            danshengongdanYi.setInsertTime(new Date());
            danshengongdanYi.setCreateTime(new Date());
            danshengongdanYiService.insert(danshengongdanYi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody DanshengongdanYiEntity danshengongdanYi, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,danshengongdanYi:{}",this.getClass().getName(),danshengongdanYi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("一级单位".equals(role))
//            danshengongdanYi.setYijidanweiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<DanshengongdanYiEntity> queryWrapper = new EntityWrapper<DanshengongdanYiEntity>()
            .notIn("id",danshengongdanYi.getId())
            .andNew()
            .eq("pinkuhushenqing_id", danshengongdanYi.getPinkuhushenqingId())
            .eq("yijidanwei_id", danshengongdanYi.getYijidanweiId())
            .eq("danshengongdan_yi_uuid_number", danshengongdanYi.getDanshengongdanYiUuidNumber())
            .eq("danshengongdan_yi_yesno_types", danshengongdanYi.getDanshengongdanYiYesnoTypes())
            .eq("danshengongdan_yi_yesno_text", danshengongdanYi.getDanshengongdanYiYesnoText())
            .eq("danshengongdan_yi_shenhe_time", danshengongdanYi.getDanshengongdanYiShenheTime())
            .eq("insert_time", danshengongdanYi.getInsertTime())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DanshengongdanYiEntity danshengongdanYiEntity = danshengongdanYiService.selectOne(queryWrapper);
        if(danshengongdanYiEntity==null){
            danshengongdanYiService.updateById(danshengongdanYi);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody DanshengongdanYiEntity danshengongdanYi, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,danshengongdanYi:{}",this.getClass().getName(),danshengongdanYi.toString());
        Date date = new Date();
        DanshengongdanYiEntity danshengongdanYiEntity = danshengongdanYiService.selectById(danshengongdanYi.getId());
        PinkuhushenqingEntity pinkuhushenqingEntity = pinkuhushenqingService.selectById(danshengongdanYiEntity.getPinkuhushenqingId());

        if(danshengongdanYi.getDanshengongdanYiYesnoTypes() == 2){//通过
            //在二级审核中新增
            DanshengongdanErEntity danshengongdanErEntity = new DanshengongdanErEntity();
            danshengongdanErEntity.setCreateTime(date);
            danshengongdanErEntity.setInsertTime(date);
            danshengongdanErEntity.setDanshengongdanErYesnoTypes(1);
            danshengongdanErEntity.setDanshengongdanErUuidNumber(String.valueOf(new Date().getTime()));
            danshengongdanErEntity.setPinkuhushenqingId(danshengongdanYiEntity.getPinkuhushenqingId());
            danshengongdanErService.insert(danshengongdanErEntity);
            pinkuhushenqingEntity.setPinkuhushenqingYiJieguo("通过");
            pinkuhushenqingEntity.setPinkuhushenqingYiTime(date);
            pinkuhushenqingEntity.setPinkuhushenqingYiYijian(danshengongdanYi.getDanshengongdanYiYesnoText());
            pinkuhushenqingService.updateById(pinkuhushenqingEntity);
        }else if(danshengongdanYi.getDanshengongdanYiYesnoTypes() == 3){//拒绝
            pinkuhushenqingEntity.setPinkuhushenqingYiJieguo("拒绝");
            pinkuhushenqingEntity.setPinkuhushenqingYiTime(date);
            pinkuhushenqingEntity.setPinkuhushenqingYiYijian(danshengongdanYi.getDanshengongdanYiYesnoText());
            pinkuhushenqingService.updateById(pinkuhushenqingEntity);
        }
        danshengongdanYi.setYijidanweiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        danshengongdanYi.setDanshengongdanYiShenheTime(new Date());//审核时间
        danshengongdanYiService.updateById(danshengongdanYi);//审核
        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        danshengongdanYiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<DanshengongdanYiEntity> danshengongdanYiList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            DanshengongdanYiEntity danshengongdanYiEntity = new DanshengongdanYiEntity();
//                            danshengongdanYiEntity.setPinkuhushenqingId(Integer.valueOf(data.get(0)));   //贫困申请 要改的
//                            danshengongdanYiEntity.setYijidanweiId(Integer.valueOf(data.get(0)));   //一级单位 要改的
//                            danshengongdanYiEntity.setDanshengongdanYiUuidNumber(data.get(0));                    //审核编号 要改的
//                            danshengongdanYiEntity.setDanshengongdanYiYesnoTypes(Integer.valueOf(data.get(0)));   //审核状态 要改的
//                            danshengongdanYiEntity.setDanshengongdanYiYesnoText(data.get(0));                    //审核意见 要改的
//                            danshengongdanYiEntity.setDanshengongdanYiShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            danshengongdanYiEntity.setInsertTime(date);//时间
//                            danshengongdanYiEntity.setCreateTime(date);//时间
                            danshengongdanYiList.add(danshengongdanYiEntity);


                            //把要查询是否重复的字段放入map中
                                //审核编号
                                if(seachFields.containsKey("danshengongdanYiUuidNumber")){
                                    List<String> danshengongdanYiUuidNumber = seachFields.get("danshengongdanYiUuidNumber");
                                    danshengongdanYiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> danshengongdanYiUuidNumber = new ArrayList<>();
                                    danshengongdanYiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("danshengongdanYiUuidNumber",danshengongdanYiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //审核编号
                        List<DanshengongdanYiEntity> danshengongdanYiEntities_danshengongdanYiUuidNumber = danshengongdanYiService.selectList(new EntityWrapper<DanshengongdanYiEntity>().in("danshengongdan_yi_uuid_number", seachFields.get("danshengongdanYiUuidNumber")));
                        if(danshengongdanYiEntities_danshengongdanYiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(DanshengongdanYiEntity s:danshengongdanYiEntities_danshengongdanYiUuidNumber){
                                repeatFields.add(s.getDanshengongdanYiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [审核编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        danshengongdanYiService.insertBatch(danshengongdanYiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
