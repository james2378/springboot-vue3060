<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      label-width="80px"
    >  
     <el-row>
                    <el-col :span="12">
           <el-form-item v-if="flag=='yonghu'"  label='用户姓名' prop="yonghuName">
               <el-input v-model="ruleForm.yonghuName"  placeholder='用户姓名' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='yonghu'"  label='用户手机号' prop="yonghuPhone">
               <el-input v-model="ruleForm.yonghuPhone"  placeholder='用户手机号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='yonghu'"  label='用户身份证号' prop="yonghuIdNumber">
               <el-input v-model="ruleForm.yonghuIdNumber"  placeholder='用户身份证号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='yonghu'" label='用户头像' prop="yonghuPhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.yonghuPhoto?ruleForm.yonghuPhoto:''"
                         @change="yonghuPhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='yonghu'"  label='电子邮箱' prop="yonghuEmail">
               <el-input v-model="ruleForm.yonghuEmail"  placeholder='电子邮箱' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='erjidanwei'"  label='二级单位名称' prop="erjidanweiName">
               <el-input v-model="ruleForm.erjidanweiName"  placeholder='二级单位名称' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='erjidanwei'"  label='二级单位联系方式' prop="erjidanweiPhone">
               <el-input v-model="ruleForm.erjidanweiPhone"  placeholder='二级单位联系方式' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='erjidanwei'"  label='二级单位邮箱' prop="erjidanweiEmail">
               <el-input v-model="ruleForm.erjidanweiEmail"  placeholder='二级单位邮箱' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="24">
             <el-form-item v-if="flag=='erjidanwei'"  label="二级单位介绍" prop="erjidanweiContent">
                 <editor
                         style="min-width: 200px; max-width: 600px;"
                         v-model="ruleForm.erjidanweiContent"
                         class="editor"
                         action="file/upload">
                 </editor>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='sanjidanwei'"  label='三级单位名称' prop="sanjidanweiName">
               <el-input v-model="ruleForm.sanjidanweiName"  placeholder='三级单位名称' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='sanjidanwei'"  label='三级单位联系方式' prop="sanjidanweiPhone">
               <el-input v-model="ruleForm.sanjidanweiPhone"  placeholder='三级单位联系方式' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='sanjidanwei'"  label='三级单位邮箱' prop="sanjidanweiEmail">
               <el-input v-model="ruleForm.sanjidanweiEmail"  placeholder='三级单位邮箱' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="24">
             <el-form-item v-if="flag=='sanjidanwei'"  label="三级单位介绍" prop="sanjidanweiContent">
                 <editor
                         style="min-width: 200px; max-width: 600px;"
                         v-model="ruleForm.sanjidanweiContent"
                         class="editor"
                         action="file/upload">
                 </editor>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='yijidanwei'"  label='一级单位名称' prop="yijidanweiName">
               <el-input v-model="ruleForm.yijidanweiName"  placeholder='一级单位名称' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='yijidanwei'"  label='一级单位联系方式' prop="yijidanweiPhone">
               <el-input v-model="ruleForm.yijidanweiPhone"  placeholder='一级单位联系方式' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='yijidanwei'"  label='一级单位邮箱' prop="yijidanweiEmail">
               <el-input v-model="ruleForm.yijidanweiEmail"  placeholder='一级单位邮箱' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="24">
             <el-form-item v-if="flag=='yijidanwei'"  label="一级单位介绍" prop="yijidanweiContent">
                 <editor
                         style="min-width: 200px; max-width: 600px;"
                         v-model="ruleForm.yijidanweiContent"
                         class="editor"
                         action="file/upload">
                 </editor>
             </el-form-item>
         </el-col>
         <el-form-item v-if="flag=='users'" label="用户名" prop="username">
             <el-input v-model="ruleForm.username"
                       placeholder="用户名"></el-input>
         </el-form-item>
         <el-col :span="12">
             <el-form-item v-if="flag=='yonghu'"  label="性别" prop="sexTypes">
                 <el-select v-model="ruleForm.sexTypes" placeholder="请选择性别">
                     <el-option
                             v-for="(item,index) in sexTypesOptions"
                             v-bind:key="item.codeIndex"
                             :label="item.indexName"
                             :value="item.codeIndex">
                     </el-option>
                 </el-select>
             </el-form-item>
         </el-col>
         <el-col :span="24">
             <el-form-item>
                 <el-button type="primary" @click="onUpdateHandler">修 改</el-button>
             </el-form-item>
         </el-col>
     </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
        ruleForm: {},
        flag: '',
        usersFlag: false,
        // sexTypesOptions : [],
// 注册表 用户
    // 注册的类型字段 用户
        // 性别
        sexTypesOptions : [],
// 注册表 二级单位
// 注册表 三级单位
// 注册表 一级单位
    };
  },
  mounted() {
    //获取当前登录用户的信息
    var table = this.$storage.get("sessionTable");
    this.sessionTable = this.$storage.get("sessionTable");
    this.role = this.$storage.get("role");
    if (this.role != "管理员"){
    }

    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
// 注册表 用户
// 注册表 二级单位
// 注册表 三级单位
// 注册表 一级单位
      } else {
        this.$message.error(data.msg);
      }
    });

// 注册表 用户 的级联表
// 注册表 二级单位 的级联表
// 注册表 三级单位 的级联表
// 注册表 一级单位 的级联表

      this.$http({
          url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=sex_types`,
          method: "get"
      }).then(({ data }) => {
          if (data && data.code === 0) {
              this.sexTypesOptions = data.data.list;
          } else {
              this.$message.error(data.msg);
          }
      });
  },
  methods: {
    chongzhi() {
      this.$router.replace({ path: "/pay" });
    },
    yonghuPhotoUploadChange(fileUrls) {
        this.ruleForm.yonghuPhoto = fileUrls;
    },


    onUpdateHandler() {
                         if((!this.ruleForm.yonghuName)&& 'yonghu'==this.flag){
                             this.$message.error('用户姓名不能为空');
                             return
                         }

                             if( 'yonghu' ==this.flag && this.ruleForm.yonghuPhone&&(!isMobile(this.ruleForm.yonghuPhone))){
                                 this.$message.error(`手机应输入手机格式`);
                                 return
                             }
                         if((!this.ruleForm.yonghuIdNumber)&& 'yonghu'==this.flag){
                             this.$message.error('用户身份证号不能为空');
                             return
                         }

                         if((!this.ruleForm.yonghuPhoto)&& 'yonghu'==this.flag){
                             this.$message.error('用户头像不能为空');
                             return
                         }

                             if( 'yonghu' ==this.flag && this.ruleForm.yonghuEmail&&(!isEmail(this.ruleForm.yonghuEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
                         if((!this.ruleForm.erjidanweiName)&& 'erjidanwei'==this.flag){
                             this.$message.error('二级单位名称不能为空');
                             return
                         }

                         if((!this.ruleForm.erjidanweiPhone)&& 'erjidanwei'==this.flag){
                             this.$message.error('二级单位联系方式不能为空');
                             return
                         }

                             if( 'erjidanwei' ==this.flag && this.ruleForm.erjidanweiEmail&&(!isEmail(this.ruleForm.erjidanweiEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
                         if((!this.ruleForm.erjidanweiContent)&& 'erjidanwei'==this.flag){
                             this.$message.error('二级单位介绍不能为空');
                             return
                         }

                         if((!this.ruleForm.sanjidanweiName)&& 'sanjidanwei'==this.flag){
                             this.$message.error('三级单位名称不能为空');
                             return
                         }

                         if((!this.ruleForm.sanjidanweiPhone)&& 'sanjidanwei'==this.flag){
                             this.$message.error('三级单位联系方式不能为空');
                             return
                         }

                             if( 'sanjidanwei' ==this.flag && this.ruleForm.sanjidanweiEmail&&(!isEmail(this.ruleForm.sanjidanweiEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
                         if((!this.ruleForm.sanjidanweiContent)&& 'sanjidanwei'==this.flag){
                             this.$message.error('三级单位介绍不能为空');
                             return
                         }

                         if((!this.ruleForm.yijidanweiName)&& 'yijidanwei'==this.flag){
                             this.$message.error('一级单位名称不能为空');
                             return
                         }

                         if((!this.ruleForm.yijidanweiPhone)&& 'yijidanwei'==this.flag){
                             this.$message.error('一级单位联系方式不能为空');
                             return
                         }

                             if( 'yijidanwei' ==this.flag && this.ruleForm.yijidanweiEmail&&(!isEmail(this.ruleForm.yijidanweiEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
                         if((!this.ruleForm.yijidanweiContent)&& 'yijidanwei'==this.flag){
                             this.$message.error('一级单位介绍不能为空');
                             return
                         }

        if((!this.ruleForm.sexTypes) && this.flag=='yonghu'){
            this.$message.error('性别不能为空');
            return
        }
      if('users'==this.flag && this.ruleForm.username.trim().length<1) {
        this.$message.error(`用户名不能为空`);
        return	
      }
      this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "修改信息成功",
            type: "success",
            duration: 1500,
            onClose: () => {
            }
          });
        } else {
          this.$message.error(data.msg);
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
