
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
 * 三级单位审核
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/danshengongdanSan")
public class DanshengongdanSanController {
    private static final Logger logger = LoggerFactory.getLogger(DanshengongdanSanController.class);

    @Autowired
    private DanshengongdanSanService danshengongdanSanService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private PinkuhushenqingService pinkuhushenqingService;
    @Autowired
    private SanjidanweiService sanjidanweiService;

    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private ErjidanweiService erjidanweiService;
    @Autowired
    private YijidanweiService yijidanweiService;


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
        PageUtils page = danshengongdanSanService.queryPage(params);

        //字典表数据转换
        List<DanshengongdanSanView> list =(List<DanshengongdanSanView>)page.getList();
        for(DanshengongdanSanView c:list){
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
        DanshengongdanSanEntity danshengongdanSan = danshengongdanSanService.selectById(id);
        if(danshengongdanSan !=null){
            //entity转view
            DanshengongdanSanView view = new DanshengongdanSanView();
            BeanUtils.copyProperties( danshengongdanSan , view );//把实体数据重构到view中

                //级联表
                PinkuhushenqingEntity pinkuhushenqing = pinkuhushenqingService.selectById(danshengongdanSan.getPinkuhushenqingId());
                if(pinkuhushenqing != null){
                    BeanUtils.copyProperties( pinkuhushenqing , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setPinkuhushenqingId(pinkuhushenqing.getId());
                }
                //级联表
                SanjidanweiEntity sanjidanwei = sanjidanweiService.selectById(danshengongdanSan.getSanjidanweiId());
                if(sanjidanwei != null){
                    BeanUtils.copyProperties( sanjidanwei , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setSanjidanweiId(sanjidanwei.getId());
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
    public R save(@RequestBody DanshengongdanSanEntity danshengongdanSan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,danshengongdanSan:{}",this.getClass().getName(),danshengongdanSan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("三级单位".equals(role))
            danshengongdanSan.setSanjidanweiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<DanshengongdanSanEntity> queryWrapper = new EntityWrapper<DanshengongdanSanEntity>()
            .eq("pinkuhushenqing_id", danshengongdanSan.getPinkuhushenqingId())
            .eq("sanjidanwei_id", danshengongdanSan.getSanjidanweiId())
            .eq("danshengongdan_san_uuid_number", danshengongdanSan.getDanshengongdanSanUuidNumber())
            .eq("danshengongdan_san_yesno_types", danshengongdanSan.getDanshengongdanSanYesnoTypes())
            .eq("danshengongdan_san_yesno_text", danshengongdanSan.getDanshengongdanSanYesnoText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DanshengongdanSanEntity danshengongdanSanEntity = danshengongdanSanService.selectOne(queryWrapper);
        if(danshengongdanSanEntity==null){
            danshengongdanSan.setDanshengongdanSanYesnoTypes(1);
            danshengongdanSan.setInsertTime(new Date());
            danshengongdanSan.setCreateTime(new Date());
            danshengongdanSanService.insert(danshengongdanSan);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody DanshengongdanSanEntity danshengongdanSan, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,danshengongdanSan:{}",this.getClass().getName(),danshengongdanSan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("三级单位".equals(role))
//            danshengongdanSan.setSanjidanweiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<DanshengongdanSanEntity> queryWrapper = new EntityWrapper<DanshengongdanSanEntity>()
            .notIn("id",danshengongdanSan.getId())
            .andNew()
            .eq("pinkuhushenqing_id", danshengongdanSan.getPinkuhushenqingId())
            .eq("sanjidanwei_id", danshengongdanSan.getSanjidanweiId())
            .eq("danshengongdan_san_uuid_number", danshengongdanSan.getDanshengongdanSanUuidNumber())
            .eq("danshengongdan_san_yesno_types", danshengongdanSan.getDanshengongdanSanYesnoTypes())
            .eq("danshengongdan_san_yesno_text", danshengongdanSan.getDanshengongdanSanYesnoText())
            .eq("danshengongdan_san_shenhe_time", danshengongdanSan.getDanshengongdanSanShenheTime())
            .eq("insert_time", danshengongdanSan.getInsertTime())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DanshengongdanSanEntity danshengongdanSanEntity = danshengongdanSanService.selectOne(queryWrapper);
        if(danshengongdanSanEntity==null){
            danshengongdanSanService.updateById(danshengongdanSan);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody DanshengongdanSanEntity danshengongdanSan, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,danshengongdanSan:{}",this.getClass().getName(),danshengongdanSan.toString());

//        if(danshengongdanSan.getDanshengongdanSanYesnoTypes() == 2){//通过
//            danshengongdanSan.setDanshengongdanSanTypes();
//        }else if(danshengongdanSan.getDanshengongdanSanYesnoTypes() == 3){//拒绝
//            danshengongdanSan.setDanshengongdanSanTypes();
//        }


        Date date = new Date();
        DanshengongdanSanEntity danshengongdanSanEntity = danshengongdanSanService.selectById(danshengongdanSan.getId());
        PinkuhushenqingEntity pinkuhushenqingEntity = pinkuhushenqingService.selectById(danshengongdanSanEntity.getPinkuhushenqingId());

        if(danshengongdanSan.getDanshengongdanSanYesnoTypes() == 2){//通过
            pinkuhushenqingEntity.setPinkuhushenqingSanJieguo("通过");
            pinkuhushenqingEntity.setPinkuhushenqingSanTime(date);
            pinkuhushenqingEntity.setPinkuhushenqingSanYijian(danshengongdanSan.getDanshengongdanSanYesnoText());
            pinkuhushenqingService.updateById(pinkuhushenqingEntity);
        }else if(danshengongdanSan.getDanshengongdanSanYesnoTypes() == 3){//拒绝
            pinkuhushenqingEntity.setPinkuhushenqingSanJieguo("拒绝");
            pinkuhushenqingEntity.setPinkuhushenqingSanTime(date);
            pinkuhushenqingEntity.setPinkuhushenqingSanYijian(danshengongdanSan.getDanshengongdanSanYesnoText());
            pinkuhushenqingService.updateById(pinkuhushenqingEntity);
        }
        danshengongdanSan.setSanjidanweiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        danshengongdanSan.setDanshengongdanSanShenheTime(new Date());//审核时间
        danshengongdanSanService.updateById(danshengongdanSan);//审核
        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        danshengongdanSanService.deleteBatchIds(Arrays.asList(ids));
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
            List<DanshengongdanSanEntity> danshengongdanSanList = new ArrayList<>();//上传的东西
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
                            DanshengongdanSanEntity danshengongdanSanEntity = new DanshengongdanSanEntity();
//                            danshengongdanSanEntity.setPinkuhushenqingId(Integer.valueOf(data.get(0)));   //贫困申请 要改的
//                            danshengongdanSanEntity.setSanjidanweiId(Integer.valueOf(data.get(0)));   //三级单位 要改的
//                            danshengongdanSanEntity.setDanshengongdanSanUuidNumber(data.get(0));                    //审核编号 要改的
//                            danshengongdanSanEntity.setDanshengongdanSanYesnoTypes(Integer.valueOf(data.get(0)));   //审核状态 要改的
//                            danshengongdanSanEntity.setDanshengongdanSanYesnoText(data.get(0));                    //审核意见 要改的
//                            danshengongdanSanEntity.setDanshengongdanSanShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            danshengongdanSanEntity.setInsertTime(date);//时间
//                            danshengongdanSanEntity.setCreateTime(date);//时间
                            danshengongdanSanList.add(danshengongdanSanEntity);


                            //把要查询是否重复的字段放入map中
                                //审核编号
                                if(seachFields.containsKey("danshengongdanSanUuidNumber")){
                                    List<String> danshengongdanSanUuidNumber = seachFields.get("danshengongdanSanUuidNumber");
                                    danshengongdanSanUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> danshengongdanSanUuidNumber = new ArrayList<>();
                                    danshengongdanSanUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("danshengongdanSanUuidNumber",danshengongdanSanUuidNumber);
                                }
                        }

                        //查询是否重复
                         //审核编号
                        List<DanshengongdanSanEntity> danshengongdanSanEntities_danshengongdanSanUuidNumber = danshengongdanSanService.selectList(new EntityWrapper<DanshengongdanSanEntity>().in("danshengongdan_san_uuid_number", seachFields.get("danshengongdanSanUuidNumber")));
                        if(danshengongdanSanEntities_danshengongdanSanUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(DanshengongdanSanEntity s:danshengongdanSanEntities_danshengongdanSanUuidNumber){
                                repeatFields.add(s.getDanshengongdanSanUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [审核编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        danshengongdanSanService.insertBatch(danshengongdanSanList);
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
