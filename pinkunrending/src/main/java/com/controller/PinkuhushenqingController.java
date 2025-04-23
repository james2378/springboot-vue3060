
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
 * 贫困申请
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/pinkuhushenqing")
public class PinkuhushenqingController {
    private static final Logger logger = LoggerFactory.getLogger(PinkuhushenqingController.class);

    @Autowired
    private PinkuhushenqingService pinkuhushenqingService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private YonghuService yonghuService;

    @Autowired
    private ErjidanweiService erjidanweiService;
    @Autowired
    private SanjidanweiService sanjidanweiService;
    @Autowired
    private YijidanweiService yijidanweiService;

    @Autowired
    private DanshengongdanYiService danshengongdanYiService;
    @Autowired
    private DanshengongdanErService danshengongdanErService;
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
        PageUtils page = pinkuhushenqingService.queryPage(params);

        //字典表数据转换
        List<PinkuhushenqingView> list =(List<PinkuhushenqingView>)page.getList();
        for(PinkuhushenqingView c:list){
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
        PinkuhushenqingEntity pinkuhushenqing = pinkuhushenqingService.selectById(id);
        if(pinkuhushenqing !=null){
            //entity转view
            PinkuhushenqingView view = new PinkuhushenqingView();
            BeanUtils.copyProperties( pinkuhushenqing , view );//把实体数据重构到view中

                //级联表
                YonghuEntity yonghu = yonghuService.selectById(pinkuhushenqing.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
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
    public R save(@RequestBody PinkuhushenqingEntity pinkuhushenqing, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,pinkuhushenqing:{}",this.getClass().getName(),pinkuhushenqing.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            pinkuhushenqing.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<PinkuhushenqingEntity> queryWrapper = new EntityWrapper<PinkuhushenqingEntity>()
            .eq("yonghu_id", pinkuhushenqing.getYonghuId())
            .eq("pinkuhushenqing_uuid_number", pinkuhushenqing.getPinkuhushenqingUuidNumber())
            .eq("pinkuhushenqing_name", pinkuhushenqing.getPinkuhushenqingName())
            .eq("sex_types", pinkuhushenqing.getSexTypes())
            .eq("age", pinkuhushenqing.getAge())
            .eq("zhengzhi_types", pinkuhushenqing.getZhengzhiTypes())
            .eq("pinkuhushenqing_shenfenzheng_phone", pinkuhushenqing.getPinkuhushenqingShenfenzhengPhone())
            .eq("pinkuhushenqing_shenfenzheng_id_number", pinkuhushenqing.getPinkuhushenqingShenfenzhengIdNumber())
            .eq("pinkuhushenqing_shenqing_types", pinkuhushenqing.getPinkuhushenqingShenqingTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        PinkuhushenqingEntity pinkuhushenqingEntity = pinkuhushenqingService.selectOne(queryWrapper);
        if(pinkuhushenqingEntity==null){
            Date date = new Date();
            pinkuhushenqing.setInsertTime(date);
            pinkuhushenqing.setCreateTime(date);
            pinkuhushenqingService.insert(pinkuhushenqing);


            DanshengongdanYiEntity danshengongdanYiEntity = new DanshengongdanYiEntity();
            danshengongdanYiEntity.setCreateTime(date);
            danshengongdanYiEntity.setInsertTime(date);
            danshengongdanYiEntity.setDanshengongdanYiYesnoTypes(1);
            danshengongdanYiEntity.setDanshengongdanYiUuidNumber(String.valueOf(new Date().getTime()));
            danshengongdanYiEntity.setPinkuhushenqingId(pinkuhushenqing.getId());
            danshengongdanYiService.insert(danshengongdanYiEntity);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody PinkuhushenqingEntity pinkuhushenqing, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,pinkuhushenqing:{}",this.getClass().getName(),pinkuhushenqing.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            pinkuhushenqing.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<PinkuhushenqingEntity> queryWrapper = new EntityWrapper<PinkuhushenqingEntity>()
            .notIn("id",pinkuhushenqing.getId())
            .andNew()
            .eq("yonghu_id", pinkuhushenqing.getYonghuId())
            .eq("pinkuhushenqing_uuid_number", pinkuhushenqing.getPinkuhushenqingUuidNumber())
            .eq("pinkuhushenqing_name", pinkuhushenqing.getPinkuhushenqingName())
            .eq("sex_types", pinkuhushenqing.getSexTypes())
            .eq("age", pinkuhushenqing.getAge())
            .eq("zhengzhi_types", pinkuhushenqing.getZhengzhiTypes())
            .eq("pinkuhushenqing_shenfenzheng_phone", pinkuhushenqing.getPinkuhushenqingShenfenzhengPhone())
            .eq("pinkuhushenqing_shenfenzheng_id_number", pinkuhushenqing.getPinkuhushenqingShenfenzhengIdNumber())
            .eq("pinkuhushenqing_shenqing_types", pinkuhushenqing.getPinkuhushenqingShenqingTypes())
            .eq("pinkuhushenqing_yi_jieguo", pinkuhushenqing.getPinkuhushenqingYiJieguo())
            .eq("pinkuhushenqing_yi_yijian", pinkuhushenqing.getPinkuhushenqingYiYijian())
            .eq("pinkuhushenqing_er_jieguo", pinkuhushenqing.getPinkuhushenqingErJieguo())
            .eq("pinkuhushenqing_er_yijian", pinkuhushenqing.getPinkuhushenqingErYijian())
            .eq("pinkuhushenqing_san_jieguo", pinkuhushenqing.getPinkuhushenqingSanJieguo())
            .eq("pinkuhushenqing_san_yijian", pinkuhushenqing.getPinkuhushenqingSanYijian())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        PinkuhushenqingEntity pinkuhushenqingEntity = pinkuhushenqingService.selectOne(queryWrapper);
        if("".equals(pinkuhushenqing.getPinkuhushenqingShenfenzhengRenxiangPhoto()) || "null".equals(pinkuhushenqing.getPinkuhushenqingShenfenzhengRenxiangPhoto())){
                pinkuhushenqing.setPinkuhushenqingShenfenzhengRenxiangPhoto(null);
        }
        if("".equals(pinkuhushenqing.getPinkuhushenqingShenfenzhengGuohuiPhoto()) || "null".equals(pinkuhushenqing.getPinkuhushenqingShenfenzhengGuohuiPhoto())){
                pinkuhushenqing.setPinkuhushenqingShenfenzhengGuohuiPhoto(null);
        }
        if("".equals(pinkuhushenqing.getPinkuhushenqingJuweihuiFile()) || "null".equals(pinkuhushenqing.getPinkuhushenqingJuweihuiFile())){
                pinkuhushenqing.setPinkuhushenqingJuweihuiFile(null);
        }
        if(pinkuhushenqingEntity==null){
            pinkuhushenqingService.updateById(pinkuhushenqing);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<Integer> idList = Arrays.asList(ids);
        danshengongdanYiService.delete(new EntityWrapper<DanshengongdanYiEntity>().in("pinkuhushenqing_id",idList));
        danshengongdanErService.delete(new EntityWrapper<DanshengongdanErEntity>().in("pinkuhushenqing_id",idList));
        danshengongdanSanService.delete(new EntityWrapper<DanshengongdanSanEntity>().in("pinkuhushenqing_id",idList));
        pinkuhushenqingService.deleteBatchIds(Arrays.asList(ids));
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
            List<PinkuhushenqingEntity> pinkuhushenqingList = new ArrayList<>();//上传的东西
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
                            PinkuhushenqingEntity pinkuhushenqingEntity = new PinkuhushenqingEntity();
//                            pinkuhushenqingEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            pinkuhushenqingEntity.setPinkuhushenqingUuidNumber(data.get(0));                    //贫困申请编号 要改的
//                            pinkuhushenqingEntity.setPinkuhushenqingName(data.get(0));                    //姓名 要改的
//                            pinkuhushenqingEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            pinkuhushenqingEntity.setAge(Integer.valueOf(data.get(0)));   //年龄 要改的
//                            pinkuhushenqingEntity.setZhengzhiTypes(Integer.valueOf(data.get(0)));   //政治面貌 要改的
//                            pinkuhushenqingEntity.setPinkuhushenqingShenfenzhengPhone(data.get(0));                    //联系方式 要改的
//                            pinkuhushenqingEntity.setPinkuhushenqingShenfenzhengIdNumber(data.get(0));                    //身份证号 要改的
//                            pinkuhushenqingEntity.setPinkuhushenqingShenfenzhengRenxiangPhoto("");//详情和图片
//                            pinkuhushenqingEntity.setPinkuhushenqingShenfenzhengGuohuiPhoto("");//详情和图片
//                            pinkuhushenqingEntity.setPinkuhushenqingShenqingTypes(Integer.valueOf(data.get(0)));   //申请类型 要改的
//                            pinkuhushenqingEntity.setPinkuhushenqingJuweihuiFile(data.get(0));                    //居委会开具证明 要改的
//                            pinkuhushenqingEntity.setPinkuhushenqingContent("");//详情和图片
//                            pinkuhushenqingEntity.setInsertTime(date);//时间
//                            pinkuhushenqingEntity.setPinkuhushenqingYiJieguo(data.get(0));                    //一级单位审核结果 要改的
//                            pinkuhushenqingEntity.setPinkuhushenqingYiYijian(data.get(0));                    //一级单位审核意见 要改的
//                            pinkuhushenqingEntity.setPinkuhushenqingYiTime(sdf.parse(data.get(0)));          //一级单位审核时间 要改的
//                            pinkuhushenqingEntity.setPinkuhushenqingErJieguo(data.get(0));                    //二级单位审核结果 要改的
//                            pinkuhushenqingEntity.setPinkuhushenqingErYijian(data.get(0));                    //二级单位审核意见 要改的
//                            pinkuhushenqingEntity.setPinkuhushenqingErTime(sdf.parse(data.get(0)));          //二级单位审核时间 要改的
//                            pinkuhushenqingEntity.setPinkuhushenqingSanJieguo(data.get(0));                    //三级单位审核结果 要改的
//                            pinkuhushenqingEntity.setPinkuhushenqingSanYijian(data.get(0));                    //三级单位审核意见 要改的
//                            pinkuhushenqingEntity.setPinkuhushenqingSanTime(sdf.parse(data.get(0)));          //三级单位审核时间 要改的
//                            pinkuhushenqingEntity.setCreateTime(date);//时间
                            pinkuhushenqingList.add(pinkuhushenqingEntity);


                            //把要查询是否重复的字段放入map中
                                //贫困申请编号
                                if(seachFields.containsKey("pinkuhushenqingUuidNumber")){
                                    List<String> pinkuhushenqingUuidNumber = seachFields.get("pinkuhushenqingUuidNumber");
                                    pinkuhushenqingUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> pinkuhushenqingUuidNumber = new ArrayList<>();
                                    pinkuhushenqingUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("pinkuhushenqingUuidNumber",pinkuhushenqingUuidNumber);
                                }
                        }

                        //查询是否重复
                         //贫困申请编号
                        List<PinkuhushenqingEntity> pinkuhushenqingEntities_pinkuhushenqingUuidNumber = pinkuhushenqingService.selectList(new EntityWrapper<PinkuhushenqingEntity>().in("pinkuhushenqing_uuid_number", seachFields.get("pinkuhushenqingUuidNumber")));
                        if(pinkuhushenqingEntities_pinkuhushenqingUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(PinkuhushenqingEntity s:pinkuhushenqingEntities_pinkuhushenqingUuidNumber){
                                repeatFields.add(s.getPinkuhushenqingUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [贫困申请编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        pinkuhushenqingService.insertBatch(pinkuhushenqingList);
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
