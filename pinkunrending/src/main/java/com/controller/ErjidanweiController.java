
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
 * 二级单位
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/erjidanwei")
public class ErjidanweiController {
    private static final Logger logger = LoggerFactory.getLogger(ErjidanweiController.class);

    @Autowired
    private ErjidanweiService erjidanweiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private SanjidanweiService sanjidanweiService;
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
        PageUtils page = erjidanweiService.queryPage(params);

        //字典表数据转换
        List<ErjidanweiView> list =(List<ErjidanweiView>)page.getList();
        for(ErjidanweiView c:list){
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
        ErjidanweiEntity erjidanwei = erjidanweiService.selectById(id);
        if(erjidanwei !=null){
            //entity转view
            ErjidanweiView view = new ErjidanweiView();
            BeanUtils.copyProperties( erjidanwei , view );//把实体数据重构到view中

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
    public R save(@RequestBody ErjidanweiEntity erjidanwei, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,erjidanwei:{}",this.getClass().getName(),erjidanwei.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ErjidanweiEntity> queryWrapper = new EntityWrapper<ErjidanweiEntity>()
            .eq("username", erjidanwei.getUsername())
            .or()
            .eq("erjidanwei_phone", erjidanwei.getErjidanweiPhone())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ErjidanweiEntity erjidanweiEntity = erjidanweiService.selectOne(queryWrapper);
        if(erjidanweiEntity==null){
            erjidanwei.setCreateTime(new Date());
            erjidanwei.setPassword("123456");
            erjidanweiService.insert(erjidanwei);
            return R.ok();
        }else {
            return R.error(511,"账户或者二级单位联系方式已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ErjidanweiEntity erjidanwei, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,erjidanwei:{}",this.getClass().getName(),erjidanwei.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<ErjidanweiEntity> queryWrapper = new EntityWrapper<ErjidanweiEntity>()
            .notIn("id",erjidanwei.getId())
            .andNew()
            .eq("username", erjidanwei.getUsername())
            .or()
            .eq("erjidanwei_phone", erjidanwei.getErjidanweiPhone())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ErjidanweiEntity erjidanweiEntity = erjidanweiService.selectOne(queryWrapper);
        if(erjidanweiEntity==null){
            erjidanweiService.updateById(erjidanwei);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者二级单位联系方式已经被使用");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        erjidanweiService.deleteBatchIds(Arrays.asList(ids));
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
            List<ErjidanweiEntity> erjidanweiList = new ArrayList<>();//上传的东西
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
                            ErjidanweiEntity erjidanweiEntity = new ErjidanweiEntity();
//                            erjidanweiEntity.setUsername(data.get(0));                    //账户 要改的
//                            //erjidanweiEntity.setPassword("123456");//密码
//                            erjidanweiEntity.setErjidanweiName(data.get(0));                    //二级单位名称 要改的
//                            erjidanweiEntity.setErjidanweiPhone(data.get(0));                    //二级单位联系方式 要改的
//                            erjidanweiEntity.setErjidanweiEmail(data.get(0));                    //二级单位邮箱 要改的
//                            erjidanweiEntity.setErjidanweiContent("");//详情和图片
//                            erjidanweiEntity.setCreateTime(date);//时间
                            erjidanweiList.add(erjidanweiEntity);


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
                                //二级单位联系方式
                                if(seachFields.containsKey("erjidanweiPhone")){
                                    List<String> erjidanweiPhone = seachFields.get("erjidanweiPhone");
                                    erjidanweiPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> erjidanweiPhone = new ArrayList<>();
                                    erjidanweiPhone.add(data.get(0));//要改的
                                    seachFields.put("erjidanweiPhone",erjidanweiPhone);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<ErjidanweiEntity> erjidanweiEntities_username = erjidanweiService.selectList(new EntityWrapper<ErjidanweiEntity>().in("username", seachFields.get("username")));
                        if(erjidanweiEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ErjidanweiEntity s:erjidanweiEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //二级单位联系方式
                        List<ErjidanweiEntity> erjidanweiEntities_erjidanweiPhone = erjidanweiService.selectList(new EntityWrapper<ErjidanweiEntity>().in("erjidanwei_phone", seachFields.get("erjidanweiPhone")));
                        if(erjidanweiEntities_erjidanweiPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ErjidanweiEntity s:erjidanweiEntities_erjidanweiPhone){
                                repeatFields.add(s.getErjidanweiPhone());
                            }
                            return R.error(511,"数据库的该表中的 [二级单位联系方式] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        erjidanweiService.insertBatch(erjidanweiList);
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
        ErjidanweiEntity erjidanwei = erjidanweiService.selectOne(new EntityWrapper<ErjidanweiEntity>().eq("username", username));
        if(erjidanwei==null || !erjidanwei.getPassword().equals(password))
            return R.error("账号或密码不正确");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(.getRoleTypes());
        String token = tokenService.generateToken(erjidanwei.getId(),username, "erjidanwei", "二级单位");
        R r = R.ok();
        r.put("token", token);
        r.put("role","二级单位");
        r.put("username",erjidanwei.getErjidanweiName());
        r.put("tableName","erjidanwei");
        r.put("userId",erjidanwei.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody ErjidanweiEntity erjidanwei){
//    	ValidatorUtils.validateEntity(user);
        Wrapper<ErjidanweiEntity> queryWrapper = new EntityWrapper<ErjidanweiEntity>()
            .eq("username", erjidanwei.getUsername())
            .or()
            .eq("erjidanwei_phone", erjidanwei.getErjidanweiPhone())
            ;
        ErjidanweiEntity erjidanweiEntity = erjidanweiService.selectOne(queryWrapper);
        if(erjidanweiEntity != null)
            return R.error("账户或者二级单位联系方式已经被使用");
        erjidanwei.setCreateTime(new Date());
        erjidanweiService.insert(erjidanwei);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        ErjidanweiEntity erjidanwei = new ErjidanweiEntity();
        erjidanwei.setPassword("123456");
        erjidanwei.setId(id);
        erjidanweiService.updateById(erjidanwei);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        ErjidanweiEntity erjidanwei = erjidanweiService.selectOne(new EntityWrapper<ErjidanweiEntity>().eq("username", username));
        if(erjidanwei!=null){
            erjidanwei.setPassword("123456");
            boolean b = erjidanweiService.updateById(erjidanwei);
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
    public R getCurrErjidanwei(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        ErjidanweiEntity erjidanwei = erjidanweiService.selectById(id);
        if(erjidanwei !=null){
            //entity转view
            ErjidanweiView view = new ErjidanweiView();
            BeanUtils.copyProperties( erjidanwei , view );//把实体数据重构到view中

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
