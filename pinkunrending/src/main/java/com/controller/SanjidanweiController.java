
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
 * 三级单位
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/sanjidanwei")
public class SanjidanweiController {
    private static final Logger logger = LoggerFactory.getLogger(SanjidanweiController.class);

    @Autowired
    private SanjidanweiService sanjidanweiService;


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
        PageUtils page = sanjidanweiService.queryPage(params);

        //字典表数据转换
        List<SanjidanweiView> list =(List<SanjidanweiView>)page.getList();
        for(SanjidanweiView c:list){
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
        SanjidanweiEntity sanjidanwei = sanjidanweiService.selectById(id);
        if(sanjidanwei !=null){
            //entity转view
            SanjidanweiView view = new SanjidanweiView();
            BeanUtils.copyProperties( sanjidanwei , view );//把实体数据重构到view中

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
    public R save(@RequestBody SanjidanweiEntity sanjidanwei, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,sanjidanwei:{}",this.getClass().getName(),sanjidanwei.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<SanjidanweiEntity> queryWrapper = new EntityWrapper<SanjidanweiEntity>()
            .eq("username", sanjidanwei.getUsername())
            .or()
            .eq("sanjidanwei_phone", sanjidanwei.getSanjidanweiPhone())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SanjidanweiEntity sanjidanweiEntity = sanjidanweiService.selectOne(queryWrapper);
        if(sanjidanweiEntity==null){
            sanjidanwei.setCreateTime(new Date());
            sanjidanwei.setPassword("123456");
            sanjidanweiService.insert(sanjidanwei);
            return R.ok();
        }else {
            return R.error(511,"账户或者三级单位联系方式已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody SanjidanweiEntity sanjidanwei, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,sanjidanwei:{}",this.getClass().getName(),sanjidanwei.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<SanjidanweiEntity> queryWrapper = new EntityWrapper<SanjidanweiEntity>()
            .notIn("id",sanjidanwei.getId())
            .andNew()
            .eq("username", sanjidanwei.getUsername())
            .or()
            .eq("sanjidanwei_phone", sanjidanwei.getSanjidanweiPhone())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SanjidanweiEntity sanjidanweiEntity = sanjidanweiService.selectOne(queryWrapper);
        if(sanjidanweiEntity==null){
            sanjidanweiService.updateById(sanjidanwei);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者三级单位联系方式已经被使用");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        sanjidanweiService.deleteBatchIds(Arrays.asList(ids));
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
            List<SanjidanweiEntity> sanjidanweiList = new ArrayList<>();//上传的东西
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
                            SanjidanweiEntity sanjidanweiEntity = new SanjidanweiEntity();
//                            sanjidanweiEntity.setUsername(data.get(0));                    //账户 要改的
//                            //sanjidanweiEntity.setPassword("123456");//密码
//                            sanjidanweiEntity.setSanjidanweiName(data.get(0));                    //三级单位名称 要改的
//                            sanjidanweiEntity.setSanjidanweiPhone(data.get(0));                    //三级单位联系方式 要改的
//                            sanjidanweiEntity.setSanjidanweiEmail(data.get(0));                    //三级单位邮箱 要改的
//                            sanjidanweiEntity.setSanjidanweiContent("");//详情和图片
//                            sanjidanweiEntity.setCreateTime(date);//时间
                            sanjidanweiList.add(sanjidanweiEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //三级单位联系方式
                                if(seachFields.containsKey("sanjidanweiPhone")){
                                    List<String> sanjidanweiPhone = seachFields.get("sanjidanweiPhone");
                                    sanjidanweiPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> sanjidanweiPhone = new ArrayList<>();
                                    sanjidanweiPhone.add(data.get(0));//要改的
                                    seachFields.put("sanjidanweiPhone",sanjidanweiPhone);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<SanjidanweiEntity> sanjidanweiEntities_username = sanjidanweiService.selectList(new EntityWrapper<SanjidanweiEntity>().in("username", seachFields.get("username")));
                        if(sanjidanweiEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(SanjidanweiEntity s:sanjidanweiEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //三级单位联系方式
                        List<SanjidanweiEntity> sanjidanweiEntities_sanjidanweiPhone = sanjidanweiService.selectList(new EntityWrapper<SanjidanweiEntity>().in("sanjidanwei_phone", seachFields.get("sanjidanweiPhone")));
                        if(sanjidanweiEntities_sanjidanweiPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(SanjidanweiEntity s:sanjidanweiEntities_sanjidanweiPhone){
                                repeatFields.add(s.getSanjidanweiPhone());
                            }
                            return R.error(511,"数据库的该表中的 [三级单位联系方式] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        sanjidanweiService.insertBatch(sanjidanweiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }


    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        SanjidanweiEntity sanjidanwei = sanjidanweiService.selectOne(new EntityWrapper<SanjidanweiEntity>().eq("username", username));
        if(sanjidanwei==null || !sanjidanwei.getPassword().equals(password))
            return R.error("账号或密码不正确");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(.getRoleTypes());
        String token = tokenService.generateToken(sanjidanwei.getId(),username, "sanjidanwei", "三级单位");
        R r = R.ok();
        r.put("token", token);
        r.put("role","三级单位");
        r.put("username",sanjidanwei.getSanjidanweiName());
        r.put("tableName","sanjidanwei");
        r.put("userId",sanjidanwei.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody SanjidanweiEntity sanjidanwei){
//    	ValidatorUtils.validateEntity(user);
        Wrapper<SanjidanweiEntity> queryWrapper = new EntityWrapper<SanjidanweiEntity>()
            .eq("username", sanjidanwei.getUsername())
            .or()
            .eq("sanjidanwei_phone", sanjidanwei.getSanjidanweiPhone())
            ;
        SanjidanweiEntity sanjidanweiEntity = sanjidanweiService.selectOne(queryWrapper);
        if(sanjidanweiEntity != null)
            return R.error("账户或者三级单位联系方式已经被使用");
        sanjidanwei.setCreateTime(new Date());
        sanjidanweiService.insert(sanjidanwei);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        SanjidanweiEntity sanjidanwei = new SanjidanweiEntity();
        sanjidanwei.setPassword("123456");
        sanjidanwei.setId(id);
        sanjidanweiService.updateById(sanjidanwei);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        SanjidanweiEntity sanjidanwei = sanjidanweiService.selectOne(new EntityWrapper<SanjidanweiEntity>().eq("username", username));
        if(sanjidanwei!=null){
            sanjidanwei.setPassword("123456");
            boolean b = sanjidanweiService.updateById(sanjidanwei);
            if(!b){
               return R.error();
            }
        }else{
           return R.error("账号不存在");
        }
        return R.ok();
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrSanjidanwei(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        SanjidanweiEntity sanjidanwei = sanjidanweiService.selectById(id);
        if(sanjidanwei !=null){
            //entity转view
            SanjidanweiView view = new SanjidanweiView();
            BeanUtils.copyProperties( sanjidanwei , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }





}
