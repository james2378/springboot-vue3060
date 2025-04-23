
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
 * 二级单位审核
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/danshengongdanEr")
public class DanshengongdanErController {
    private static final Logger logger = LoggerFactory.getLogger(DanshengongdanErController.class);

    @Autowired
    private DanshengongdanErService danshengongdanErService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private ErjidanweiService erjidanweiService;
    @Autowired
    private PinkuhushenqingService pinkuhushenqingService;

    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private SanjidanweiService sanjidanweiService;
    @Autowired
    private YijidanweiService yijidanweiService;

    @Autowired
    private DanshengongdanSanService danshengongdanSanService;



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
        PageUtils page = danshengongdanErService.queryPage(params);

        //字典表数据转换
        List<DanshengongdanErView> list =(List<DanshengongdanErView>)page.getList();
        for(DanshengongdanErView c:list){
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
        DanshengongdanErEntity danshengongdanEr = danshengongdanErService.selectById(id);
        if(danshengongdanEr !=null){
            //entity转view
            DanshengongdanErView view = new DanshengongdanErView();
            BeanUtils.copyProperties( danshengongdanEr , view );//把实体数据重构到view中

                //级联表
                ErjidanweiEntity erjidanwei = erjidanweiService.selectById(danshengongdanEr.getErjidanweiId());
                if(erjidanwei != null){
                    BeanUtils.copyProperties( erjidanwei , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setErjidanweiId(erjidanwei.getId());
                }
                //级联表
                PinkuhushenqingEntity pinkuhushenqing = pinkuhushenqingService.selectById(danshengongdanEr.getPinkuhushenqingId());
                if(pinkuhushenqing != null){
                    BeanUtils.copyProperties( pinkuhushenqing , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setPinkuhushenqingId(pinkuhushenqing.getId());
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
    public R save(@RequestBody DanshengongdanErEntity danshengongdanEr, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,danshengongdanEr:{}",this.getClass().getName(),danshengongdanEr.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("二级单位".equals(role))
            danshengongdanEr.setErjidanweiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<DanshengongdanErEntity> queryWrapper = new EntityWrapper<DanshengongdanErEntity>()
            .eq("pinkuhushenqing_id", danshengongdanEr.getPinkuhushenqingId())
            .eq("erjidanwei_id", danshengongdanEr.getErjidanweiId())
            .eq("danshengongdan_er_uuid_number", danshengongdanEr.getDanshengongdanErUuidNumber())
            .eq("danshengongdan_er_yesno_types", danshengongdanEr.getDanshengongdanErYesnoTypes())
            .eq("danshengongdan_er_yesno_text", danshengongdanEr.getDanshengongdanErYesnoText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DanshengongdanErEntity danshengongdanErEntity = danshengongdanErService.selectOne(queryWrapper);
        if(danshengongdanErEntity==null){
            danshengongdanEr.setDanshengongdanErYesnoTypes(1);
            danshengongdanEr.setInsertTime(new Date());
            danshengongdanEr.setCreateTime(new Date());
            danshengongdanErService.insert(danshengongdanEr);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody DanshengongdanErEntity danshengongdanEr, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,danshengongdanEr:{}",this.getClass().getName(),danshengongdanEr.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("二级单位".equals(role))
//            danshengongdanEr.setErjidanweiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<DanshengongdanErEntity> queryWrapper = new EntityWrapper<DanshengongdanErEntity>()
            .notIn("id",danshengongdanEr.getId())
            .andNew()
            .eq("pinkuhushenqing_id", danshengongdanEr.getPinkuhushenqingId())
            .eq("erjidanwei_id", danshengongdanEr.getErjidanweiId())
            .eq("danshengongdan_er_uuid_number", danshengongdanEr.getDanshengongdanErUuidNumber())
            .eq("danshengongdan_er_yesno_types", danshengongdanEr.getDanshengongdanErYesnoTypes())
            .eq("danshengongdan_er_yesno_text", danshengongdanEr.getDanshengongdanErYesnoText())
            .eq("danshengongdan_er_shenhe_time", danshengongdanEr.getDanshengongdanErShenheTime())
            .eq("insert_time", danshengongdanEr.getInsertTime())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DanshengongdanErEntity danshengongdanErEntity = danshengongdanErService.selectOne(queryWrapper);
        if(danshengongdanErEntity==null){
            danshengongdanErService.updateById(danshengongdanEr);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody DanshengongdanErEntity danshengongdanEr, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,danshengongdanEr:{}",this.getClass().getName(),danshengongdanEr.toString());

//        if(danshengongdanEr.getDanshengongdanErYesnoTypes() == 2){//通过
//            danshengongdanEr.setDanshengongdanErTypes();
//        }else if(danshengongdanEr.getDanshengongdanErYesnoTypes() == 3){//拒绝
//            danshengongdanEr.setDanshengongdanErTypes();
//        }

        Date date = new Date();
        DanshengongdanErEntity danshengongdanErEntity = danshengongdanErService.selectById(danshengongdanEr.getId());
        PinkuhushenqingEntity pinkuhushenqingEntity = pinkuhushenqingService.selectById(danshengongdanErEntity.getPinkuhushenqingId());

        if(danshengongdanEr.getDanshengongdanErYesnoTypes() == 2){//通过
            //在三级审核中新增
            DanshengongdanSanEntity danshengongdanSanEntity = new DanshengongdanSanEntity();
            danshengongdanSanEntity.setCreateTime(date);
            danshengongdanSanEntity.setInsertTime(date);
            danshengongdanSanEntity.setDanshengongdanSanYesnoTypes(1);
            danshengongdanSanEntity.setDanshengongdanSanUuidNumber(String.valueOf(new Date().getTime()));
            danshengongdanSanEntity.setPinkuhushenqingId(danshengongdanErEntity.getPinkuhushenqingId());
            danshengongdanSanService.insert(danshengongdanSanEntity);
            pinkuhushenqingEntity.setPinkuhushenqingErJieguo("通过");
            pinkuhushenqingEntity.setPinkuhushenqingErTime(date);
            pinkuhushenqingEntity.setPinkuhushenqingErYijian(danshengongdanEr.getDanshengongdanErYesnoText());
            pinkuhushenqingService.updateById(pinkuhushenqingEntity);
        }else if(danshengongdanEr.getDanshengongdanErYesnoTypes() == 3){//拒绝
            pinkuhushenqingEntity.setPinkuhushenqingErJieguo("拒绝");
            pinkuhushenqingEntity.setPinkuhushenqingErTime(date);
            pinkuhushenqingEntity.setPinkuhushenqingErYijian(danshengongdanEr.getDanshengongdanErYesnoText());
            pinkuhushenqingService.updateById(pinkuhushenqingEntity);
        }
        danshengongdanEr.setErjidanweiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        danshengongdanEr.setDanshengongdanErShenheTime(new Date());//审核时间
        danshengongdanErService.updateById(danshengongdanEr);//审核
        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        danshengongdanErService.deleteBatchIds(Arrays.asList(ids));
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
            List<DanshengongdanErEntity> danshengongdanErList = new ArrayList<>();//上传的东西
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
                            DanshengongdanErEntity danshengongdanErEntity = new DanshengongdanErEntity();
//                            danshengongdanErEntity.setPinkuhushenqingId(Integer.valueOf(data.get(0)));   //贫困申请 要改的
//                            danshengongdanErEntity.setErjidanweiId(Integer.valueOf(data.get(0)));   //二级单位 要改的
//                            danshengongdanErEntity.setDanshengongdanErUuidNumber(data.get(0));                    //审核编号 要改的
//                            danshengongdanErEntity.setDanshengongdanErYesnoTypes(Integer.valueOf(data.get(0)));   //审核状态 要改的
//                            danshengongdanErEntity.setDanshengongdanErYesnoText(data.get(0));                    //审核意见 要改的
//                            danshengongdanErEntity.setDanshengongdanErShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            danshengongdanErEntity.setInsertTime(date);//时间
//                            danshengongdanErEntity.setCreateTime(date);//时间
                            danshengongdanErList.add(danshengongdanErEntity);


                            //把要查询是否重复的字段放入map中
                                //审核编号
                                if(seachFields.containsKey("danshengongdanErUuidNumber")){
                                    List<String> danshengongdanErUuidNumber = seachFields.get("danshengongdanErUuidNumber");
                                    danshengongdanErUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> danshengongdanErUuidNumber = new ArrayList<>();
                                    danshengongdanErUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("danshengongdanErUuidNumber",danshengongdanErUuidNumber);
                                }
                        }

                        //查询是否重复
                         //审核编号
                        List<DanshengongdanErEntity> danshengongdanErEntities_danshengongdanErUuidNumber = danshengongdanErService.selectList(new EntityWrapper<DanshengongdanErEntity>().in("danshengongdan_er_uuid_number", seachFields.get("danshengongdanErUuidNumber")));
                        if(danshengongdanErEntities_danshengongdanErUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(DanshengongdanErEntity s:danshengongdanErEntities_danshengongdanErUuidNumber){
                                repeatFields.add(s.getDanshengongdanErUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [审核编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        danshengongdanErService.insertBatch(danshengongdanErList);
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
