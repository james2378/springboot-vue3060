import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import yonghu from '@/views/modules/yonghu/list'
    import danshengongdanEr from '@/views/modules/danshengongdanEr/list'
    import danshengongdanSan from '@/views/modules/danshengongdanSan/list'
    import danshengongdanYi from '@/views/modules/danshengongdanYi/list'
    import dictionary from '@/views/modules/dictionary/list'
    import erjidanwei from '@/views/modules/erjidanwei/list'
    import gonggao from '@/views/modules/gonggao/list'
    import liuyan from '@/views/modules/liuyan/list'
    import pinkuhushenqing from '@/views/modules/pinkuhushenqing/list'
    import sanjidanwei from '@/views/modules/sanjidanwei/list'
    import yijidanwei from '@/views/modules/yijidanwei/list'
    import dictionaryDanshengongdanErYesno from '@/views/modules/dictionaryDanshengongdanErYesno/list'
    import dictionaryDanshengongdanSanYesno from '@/views/modules/dictionaryDanshengongdanSanYesno/list'
    import dictionaryDanshengongdanYiYesno from '@/views/modules/dictionaryDanshengongdanYiYesno/list'
    import dictionaryGonggao from '@/views/modules/dictionaryGonggao/list'
    import dictionaryPinkuhushenqingShenqing from '@/views/modules/dictionaryPinkuhushenqingShenqing/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryZhengzhi from '@/views/modules/dictionaryZhengzhi/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryDanshengongdanErYesno',
        name: '审核状态',
        component: dictionaryDanshengongdanErYesno
    }
    ,{
        path: '/dictionaryDanshengongdanSanYesno',
        name: '审核状态',
        component: dictionaryDanshengongdanSanYesno
    }
    ,{
        path: '/dictionaryDanshengongdanYiYesno',
        name: '审核状态',
        component: dictionaryDanshengongdanYiYesno
    }
    ,{
        path: '/dictionaryGonggao',
        name: '公告类型',
        component: dictionaryGonggao
    }
    ,{
        path: '/dictionaryPinkuhushenqingShenqing',
        name: '申请类型',
        component: dictionaryPinkuhushenqingShenqing
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryZhengzhi',
        name: '政治面貌',
        component: dictionaryZhengzhi
    }


    ,{
        path: '/yonghu',
        name: '用户',
        component: yonghu
      }
    ,{
        path: '/danshengongdanEr',
        name: '二级单位审核',
        component: danshengongdanEr
      }
    ,{
        path: '/danshengongdanSan',
        name: '三级单位审核',
        component: danshengongdanSan
      }
    ,{
        path: '/danshengongdanYi',
        name: '一级单位审核',
        component: danshengongdanYi
      }
    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/erjidanwei',
        name: '二级单位',
        component: erjidanwei
      }
    ,{
        path: '/gonggao',
        name: '公告',
        component: gonggao
      }
    ,{
        path: '/liuyan',
        name: '留言',
        component: liuyan
      }
    ,{
        path: '/pinkuhushenqing',
        name: '贫困申请',
        component: pinkuhushenqing
      }
    ,{
        path: '/sanjidanwei',
        name: '三级单位',
        component: sanjidanwei
      }
    ,{
        path: '/yijidanwei',
        name: '一级单位',
        component: yijidanwei
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
