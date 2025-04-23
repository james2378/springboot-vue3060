<template>
    <div class="addEdit-block">
        <el-form
                class="detail-form-content"
                ref="ruleForm"
                :model="ruleForm"
                :rules="rules"
                label-width="80px"
                :style="{backgroundColor:addEditForm.addEditBoxColor}">
            <el-row>
                <el-col :span="12"  v-if="sessionTable !='yonghu'">
                    <el-form-item class="select" v-if="type!='info'"  label="用户" prop="yonghuId">
                        <el-select v-model="ruleForm.yonghuId" :disabled="ro.yonghuId" filterable placeholder="请选择用户" @change="yonghuChange">
                            <el-option
                                    v-for="(item,index) in yonghuOptions"
                                    v-bind:key="item.id"
                                    :label="item.yonghuName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='yonghu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="用户姓名" prop="yonghuName">
                        <el-input v-model="yonghuForm.yonghuName"
                                  placeholder="用户姓名" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="用户姓名" prop="yonghuName">
                            <el-input v-model="ruleForm.yonghuName"
                                      placeholder="用户姓名" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yonghu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="用户手机号" prop="yonghuPhone">
                        <el-input v-model="yonghuForm.yonghuPhone"
                                  placeholder="用户手机号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="用户手机号" prop="yonghuPhone">
                            <el-input v-model="ruleForm.yonghuPhone"
                                      placeholder="用户手机号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yonghu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="用户身份证号" prop="yonghuIdNumber">
                        <el-input v-model="yonghuForm.yonghuIdNumber"
                                  placeholder="用户身份证号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="用户身份证号" prop="yonghuIdNumber">
                            <el-input v-model="ruleForm.yonghuIdNumber"
                                      placeholder="用户身份证号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if="sessionTable !='yonghu' ">
                    <el-form-item class="upload" v-if="type!='info' && !ro.yonghuPhoto" label="用户头像" prop="yonghuPhoto">
                        <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (yonghuForm.yonghuPhoto || '').split(',')" :src="item" width="100" height="100">
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.yonghuPhoto" label="用户头像" prop="yonghuPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.yonghuPhoto || '').split(',')" :src="item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yonghu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="电子邮箱" prop="yonghuEmail">
                        <el-input v-model="yonghuForm.yonghuEmail"
                                  placeholder="电子邮箱" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="电子邮箱" prop="yonghuEmail">
                            <el-input v-model="ruleForm.yonghuEmail"
                                      placeholder="电子邮箱" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <input id="updateId" name="id" type="hidden">
            <input id="yonghuId" name="yonghuId" type="hidden">
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="贫困申请编号" prop="pinkuhushenqingUuidNumber">
                       <el-input v-model="ruleForm.pinkuhushenqingUuidNumber"
                                 placeholder="贫困申请编号" clearable  :readonly="ro.pinkuhushenqingUuidNumber"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="贫困申请编号" prop="pinkuhushenqingUuidNumber">
                           <el-input v-model="ruleForm.pinkuhushenqingUuidNumber"
                                     placeholder="贫困申请编号" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="姓名" prop="pinkuhushenqingName">
                       <el-input v-model="ruleForm.pinkuhushenqingName"
                                 placeholder="姓名" clearable  :readonly="ro.pinkuhushenqingName"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="姓名" prop="pinkuhushenqingName">
                           <el-input v-model="ruleForm.pinkuhushenqingName"
                                     placeholder="姓名" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="性别" prop="sexTypes">
                        <el-select v-model="ruleForm.sexTypes" :disabled="ro.sexTypes" placeholder="请选择性别">
                            <el-option
                                v-for="(item,index) in sexTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="性别" prop="sexValue">
                        <el-input v-model="ruleForm.sexValue"
                            placeholder="性别" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="年龄" prop="age">
                       <el-input v-model="ruleForm.age"
                                 placeholder="年龄" clearable  :readonly="ro.age"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="年龄" prop="age">
                           <el-input v-model="ruleForm.age"
                                     placeholder="年龄" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="政治面貌" prop="zhengzhiTypes">
                        <el-select v-model="ruleForm.zhengzhiTypes" :disabled="ro.zhengzhiTypes" placeholder="请选择政治面貌">
                            <el-option
                                v-for="(item,index) in zhengzhiTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="政治面貌" prop="zhengzhiValue">
                        <el-input v-model="ruleForm.zhengzhiValue"
                            placeholder="政治面貌" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="联系方式" prop="pinkuhushenqingShenfenzhengPhone">
                       <el-input v-model="ruleForm.pinkuhushenqingShenfenzhengPhone"
                                 placeholder="联系方式" clearable  :readonly="ro.pinkuhushenqingShenfenzhengPhone"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="联系方式" prop="pinkuhushenqingShenfenzhengPhone">
                           <el-input v-model="ruleForm.pinkuhushenqingShenfenzhengPhone"
                                     placeholder="联系方式" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="身份证号" prop="pinkuhushenqingShenfenzhengIdNumber">
                       <el-input v-model="ruleForm.pinkuhushenqingShenfenzhengIdNumber"
                                 placeholder="身份证号" clearable  :readonly="ro.pinkuhushenqingShenfenzhengIdNumber"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="身份证号" prop="pinkuhushenqingShenfenzhengIdNumber">
                           <el-input v-model="ruleForm.pinkuhushenqingShenfenzhengIdNumber"
                                     placeholder="身份证号" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="24">
                    <el-form-item class="upload" v-if="type!='info' && !ro.pinkuhushenqingShenfenzhengRenxiangPhoto" label="身份证人像面" prop="pinkuhushenqingShenfenzhengRenxiangPhoto">
                        <file-upload
                            tip="点击上传身份证人像面"
                            action="file/upload"
                            :limit="3"
                            :multiple="true"
                            :fileUrls="ruleForm.pinkuhushenqingShenfenzhengRenxiangPhoto?ruleForm.pinkuhushenqingShenfenzhengRenxiangPhoto:''"
                            @change="pinkuhushenqingShenfenzhengRenxiangPhotoUploadChange"
                        ></file-upload>
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.pinkuhushenqingShenfenzhengRenxiangPhoto" label="身份证人像面" prop="pinkuhushenqingShenfenzhengRenxiangPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.pinkuhushenqingShenfenzhengRenxiangPhoto || '').split(',')" :src="item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="24">
                    <el-form-item class="upload" v-if="type!='info' && !ro.pinkuhushenqingShenfenzhengGuohuiPhoto" label="身份证国徽面" prop="pinkuhushenqingShenfenzhengGuohuiPhoto">
                        <file-upload
                            tip="点击上传身份证国徽面"
                            action="file/upload"
                            :limit="3"
                            :multiple="true"
                            :fileUrls="ruleForm.pinkuhushenqingShenfenzhengGuohuiPhoto?ruleForm.pinkuhushenqingShenfenzhengGuohuiPhoto:''"
                            @change="pinkuhushenqingShenfenzhengGuohuiPhotoUploadChange"
                        ></file-upload>
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.pinkuhushenqingShenfenzhengGuohuiPhoto" label="身份证国徽面" prop="pinkuhushenqingShenfenzhengGuohuiPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.pinkuhushenqingShenfenzhengGuohuiPhoto || '').split(',')" :src="item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="申请类型" prop="pinkuhushenqingShenqingTypes">
                        <el-select v-model="ruleForm.pinkuhushenqingShenqingTypes" :disabled="ro.pinkuhushenqingShenqingTypes" placeholder="请选择申请类型">
                            <el-option
                                v-for="(item,index) in pinkuhushenqingShenqingTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="申请类型" prop="pinkuhushenqingShenqingValue">
                        <el-input v-model="ruleForm.pinkuhushenqingShenqingValue"
                            placeholder="申请类型" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="24">
                    <el-form-item class="upload" v-if="type!='info' && !ro.pinkuhushenqingJuweihuiFile" label="居委会开具证明" prop="pinkuhushenqingJuweihuiFile">
                        <file-upload
                                tip="点击上传居委会开具证明"
                                action="file/upload"
                                :limit="3"
                                :multiple="true"
                                :fileUrls="ruleForm.pinkuhushenqingJuweihuiFile?ruleForm.pinkuhushenqingJuweihuiFile:''"
                                @change="pinkuhushenqingJuweihuiFileUploadChange"
                        ></file-upload>
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.pinkuhushenqingJuweihuiFile" label="居委会开具证明" prop="pinkuhushenqingJuweihuiFile">
                            <a type="text" style="text-decoration:none" class="el-button" :href="ruleForm.pinkuhushenqingJuweihuiFile"  >居委会开具证明下载</a>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="24">
                    <el-form-item v-if="type!='info'"  label="申请内容" prop="pinkuhushenqingContent">
                        <editor style="min-width: 200px; max-width: 600px;"
                                v-model="ruleForm.pinkuhushenqingContent"
                                class="editor"
                                action="file/upload">
                        </editor>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.pinkuhushenqingContent" label="申请内容" prop="pinkuhushenqingContent">
                            <span v-html="ruleForm.pinkuhushenqingContent"></span>
                        </el-form-item>
                    </div>
                </el-col>
               <el-col :span="12" v-if="type=='info'">
                   <el-form-item class="input" v-if="type!='info'"  label="一级单位审核结果" prop="pinkuhushenqingYiJieguo">
                       <el-input v-model="ruleForm.pinkuhushenqingYiJieguo"
                                 placeholder="一级单位审核结果" clearable  :readonly="ro.pinkuhushenqingYiJieguo"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="一级单位审核结果" prop="pinkuhushenqingYiJieguo">
                           <el-input v-model="ruleForm.pinkuhushenqingYiJieguo"
                                     placeholder="一级单位审核结果" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12" v-if="type=='info'">
                   <el-form-item class="input" v-if="type!='info'"  label="一级单位审核意见" prop="pinkuhushenqingYiYijian">
                       <el-input v-model="ruleForm.pinkuhushenqingYiYijian"
                                 placeholder="一级单位审核意见" clearable  :readonly="ro.pinkuhushenqingYiYijian"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="一级单位审核意见" prop="pinkuhushenqingYiYijian">
                           <el-input v-model="ruleForm.pinkuhushenqingYiYijian"
                                     placeholder="一级单位审核意见" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12" v-if="type=='info'">
                    <el-form-item v-if="type!='info'"  class="input" label="一级单位审核时间" prop="pinkuhushenqingYiTime">
                        <el-date-picker
                                value-format="yyyy-MM-dd HH:mm:ss"
                                v-model="ruleForm.pinkuhushenqingYiTime"
                                type="datetime"
                                placeholder="一级单位审核时间"
                                :disabled="ro.pinkuhushenqingYiTime">
                        </el-date-picker>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.pinkuhushenqingYiTime" label="一级单位审核时间" prop="pinkuhushenqingYiTime">
                            <span v-html="ruleForm.pinkuhushenqingYiTime"></span>
                        </el-form-item>
                    </div>
                </el-col>

               <el-col :span="12" v-if="type=='info'">
                   <el-form-item class="input" v-if="type!='info'"  label="二级单位审核结果" prop="pinkuhushenqingErJieguo">
                       <el-input v-model="ruleForm.pinkuhushenqingErJieguo"
                                 placeholder="二级单位审核结果" clearable  :readonly="ro.pinkuhushenqingErJieguo"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="二级单位审核结果" prop="pinkuhushenqingErJieguo">
                           <el-input v-model="ruleForm.pinkuhushenqingErJieguo"
                                     placeholder="二级单位审核结果" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12" v-if="type=='info'">
                   <el-form-item class="input" v-if="type!='info'"  label="二级单位审核意见" prop="pinkuhushenqingErYijian">
                       <el-input v-model="ruleForm.pinkuhushenqingErYijian"
                                 placeholder="二级单位审核意见" clearable  :readonly="ro.pinkuhushenqingErYijian"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="二级单位审核意见" prop="pinkuhushenqingErYijian">
                           <el-input v-model="ruleForm.pinkuhushenqingErYijian"
                                     placeholder="二级单位审核意见" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12" v-if="type=='info'">
                    <el-form-item v-if="type!='info'"  class="input" label="二级单位审核时间" prop="pinkuhushenqingErTime">
                        <el-date-picker
                                value-format="yyyy-MM-dd HH:mm:ss"
                                v-model="ruleForm.pinkuhushenqingErTime"
                                type="datetime"
                                placeholder="二级单位审核时间"
                                :disabled="ro.pinkuhushenqingErTime">
                        </el-date-picker>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.pinkuhushenqingErTime" label="二级单位审核时间" prop="pinkuhushenqingErTime">
                            <span v-html="ruleForm.pinkuhushenqingErTime"></span>
                        </el-form-item>
                    </div>
                </el-col>

               <el-col :span="12" v-if="type=='info'">
                   <el-form-item class="input" v-if="type!='info'"  label="三级单位审核结果" prop="pinkuhushenqingSanJieguo">
                       <el-input v-model="ruleForm.pinkuhushenqingSanJieguo"
                                 placeholder="三级单位审核结果" clearable  :readonly="ro.pinkuhushenqingSanJieguo"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="三级单位审核结果" prop="pinkuhushenqingSanJieguo">
                           <el-input v-model="ruleForm.pinkuhushenqingSanJieguo"
                                     placeholder="三级单位审核结果" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12" v-if="type=='info'">
                   <el-form-item class="input" v-if="type!='info'"  label="三级单位审核意见" prop="pinkuhushenqingSanYijian">
                       <el-input v-model="ruleForm.pinkuhushenqingSanYijian"
                                 placeholder="三级单位审核意见" clearable  :readonly="ro.pinkuhushenqingSanYijian"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="三级单位审核意见" prop="pinkuhushenqingSanYijian">
                           <el-input v-model="ruleForm.pinkuhushenqingSanYijian"
                                     placeholder="三级单位审核意见" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12" v-if="type=='info'">
                    <el-form-item v-if="type!='info'"  class="input" label="三级单位审核时间" prop="pinkuhushenqingSanTime">
                        <el-date-picker
                                value-format="yyyy-MM-dd HH:mm:ss"
                                v-model="ruleForm.pinkuhushenqingSanTime"
                                type="datetime"
                                placeholder="三级单位审核时间"
                                :disabled="ro.pinkuhushenqingSanTime">
                        </el-date-picker>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.pinkuhushenqingSanTime" label="三级单位审核时间" prop="pinkuhushenqingSanTime">
                            <span v-html="ruleForm.pinkuhushenqingSanTime"></span>
                        </el-form-item>
                    </div>
                </el-col>

            </el-row>
            <el-form-item class="btn">
                <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
                <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
                <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
    import styleJs from "../../../utils/style.js";
    // 数字，邮件，手机，url，身份证校验
    import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
    export default {
        data() {
            return {
                addEditForm:null,
                id: '',
                type: '',
                sessionTable : "",//登录账户所在表名
                role : "",//权限
                userId:"",//当前登录人的id
                yonghuForm: {},
                ro:{
                    yonghuId: false,
                    pinkuhushenqingUuidNumber: false,
                    pinkuhushenqingName: false,
                    sexTypes: false,
                    age: false,
                    zhengzhiTypes: false,
                    pinkuhushenqingShenfenzhengPhone: false,
                    pinkuhushenqingShenfenzhengIdNumber: false,
                    pinkuhushenqingShenfenzhengRenxiangPhoto: false,
                    pinkuhushenqingShenfenzhengGuohuiPhoto: false,
                    pinkuhushenqingShenqingTypes: false,
                    pinkuhushenqingJuweihuiFile: false,
                    pinkuhushenqingContent: false,
                    insertTime: false,
                    pinkuhushenqingYiJieguo: false,
                    pinkuhushenqingYiYijian: false,
                    pinkuhushenqingYiTime: false,
                    pinkuhushenqingErJieguo: false,
                    pinkuhushenqingErYijian: false,
                    pinkuhushenqingErTime: false,
                    pinkuhushenqingSanJieguo: false,
                    pinkuhushenqingSanYijian: false,
                    pinkuhushenqingSanTime: false,
                },
                ruleForm: {
                    yonghuId: '',
                    pinkuhushenqingUuidNumber: new Date().getTime(),
                    pinkuhushenqingName: '',
                    sexTypes: '',
                    age: '',
                    zhengzhiTypes: '',
                    pinkuhushenqingShenfenzhengPhone: '',
                    pinkuhushenqingShenfenzhengIdNumber: '',
                    pinkuhushenqingShenfenzhengRenxiangPhoto: '',
                    pinkuhushenqingShenfenzhengGuohuiPhoto: '',
                    pinkuhushenqingShenqingTypes: '',
                    pinkuhushenqingJuweihuiFile: '',
                    pinkuhushenqingContent: '',
                    insertTime: '',
                    pinkuhushenqingYiJieguo: '',
                    pinkuhushenqingYiYijian: '',
                    pinkuhushenqingYiTime: '',
                    pinkuhushenqingErJieguo: '',
                    pinkuhushenqingErYijian: '',
                    pinkuhushenqingErTime: '',
                    pinkuhushenqingSanJieguo: '',
                    pinkuhushenqingSanYijian: '',
                    pinkuhushenqingSanTime: '',
                },
                sexTypesOptions : [],
                zhengzhiTypesOptions : [],
                pinkuhushenqingShenqingTypesOptions : [],
                yonghuOptions : [],
                rules: {
                   yonghuId: [
                              { required: true, message: '用户不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   pinkuhushenqingUuidNumber: [
                              { required: true, message: '贫困申请编号不能为空', trigger: 'blur' },
                          ],
                   pinkuhushenqingName: [
                              { required: true, message: '姓名不能为空', trigger: 'blur' },
                          ],
                   sexTypes: [
                              { required: true, message: '性别不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   age: [
                              { required: true, message: '年龄不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   zhengzhiTypes: [
                              { required: true, message: '政治面貌不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   pinkuhushenqingShenfenzhengPhone: [
                              { required: true, message: '联系方式不能为空', trigger: 'blur' },
                          ],
                   pinkuhushenqingShenfenzhengIdNumber: [
                              { required: true, message: '身份证号不能为空', trigger: 'blur' },
                          ],
                   pinkuhushenqingShenfenzhengRenxiangPhoto: [
                              { required: true, message: '身份证人像面不能为空', trigger: 'blur' },
                          ],
                   pinkuhushenqingShenfenzhengGuohuiPhoto: [
                              { required: true, message: '身份证国徽面不能为空', trigger: 'blur' },
                          ],
                   pinkuhushenqingShenqingTypes: [
                              { required: true, message: '申请类型不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   pinkuhushenqingJuweihuiFile: [
                              { required: true, message: '居委会开具证明不能为空', trigger: 'blur' },
                          ],
                   pinkuhushenqingContent: [
                              { required: true, message: '申请内容不能为空', trigger: 'blur' },
                          ],
                   insertTime: [
                              { required: true, message: '申请时间不能为空', trigger: 'blur' },
                          ],
                   pinkuhushenqingYiJieguo: [
                              { required: true, message: '一级单位审核结果不能为空', trigger: 'blur' },
                          ],
                   pinkuhushenqingYiYijian: [
                              { required: true, message: '一级单位审核意见不能为空', trigger: 'blur' },
                          ],
                   pinkuhushenqingYiTime: [
                              { required: true, message: '一级单位审核时间不能为空', trigger: 'blur' },
                          ],
                   pinkuhushenqingErJieguo: [
                              { required: true, message: '二级单位审核结果不能为空', trigger: 'blur' },
                          ],
                   pinkuhushenqingErYijian: [
                              { required: true, message: '二级单位审核意见不能为空', trigger: 'blur' },
                          ],
                   pinkuhushenqingErTime: [
                              { required: true, message: '二级单位审核时间不能为空', trigger: 'blur' },
                          ],
                   pinkuhushenqingSanJieguo: [
                              { required: true, message: '三级单位审核结果不能为空', trigger: 'blur' },
                          ],
                   pinkuhushenqingSanYijian: [
                              { required: true, message: '三级单位审核意见不能为空', trigger: 'blur' },
                          ],
                   pinkuhushenqingSanTime: [
                              { required: true, message: '三级单位审核时间不能为空', trigger: 'blur' },
                          ],
                }
            };
        },
        props: ["parent"],
        computed: {
        },
        created() {
            //获取当前登录用户的信息
            this.sessionTable = this.$storage.get("sessionTable");
            this.role = this.$storage.get("role");
            this.userId = this.$storage.get("userId");


            if (this.role != "管理员"){
            }
            this.addEditForm = styleJs.addStyle();
            this.addEditStyleChange()
            this.addEditUploadStyleChange()
            //获取下拉框信息
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=sex_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.sexTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=zhengzhi_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.zhengzhiTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=pinkuhushenqing_shenqing_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.pinkuhushenqingShenqingTypesOptions = data.data.list;
                    }
                });

         this.$http({
             url: `yonghu/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.yonghuOptions = data.data.list;
            }
         });

        },
        mounted() {
        },
        methods: {
            // 下载
            download(file){
                window.open(`${file}`)
            },
            // 初始化
            init(id,type) {
                if (id) {
                    this.id = id;
                    this.type = type;
                }
                if(this.type=='info'||this.type=='else'){
                    this.info(id);
                }
                // 获取用户信息
                this.$http({
                    url:`${this.$storage.get("sessionTable")}/session`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        var json = data.data;
                    } else {
                        this.$message.error(data.msg);
                    }
                });
            },
            yonghuChange(id){
                this.$http({
                    url: `yonghu/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.yonghuForm = data.data;
                    }
                });
            },
            // 多级联动参数
            info(id) {
                let _this =this;
                _this.$http({
                    url: `pinkuhushenqing/info/${id}`,
                    method: 'get'
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        _this.ruleForm = data.data;
                        _this.yonghuChange(data.data.yonghuId)
                    } else {
                        _this.$message.error(data.msg);
                    }
                });
            },
            // 提交
            onSubmit() {
                this.$refs["ruleForm"].validate(valid => {
                    if (valid) {
                        this.$http({
                            url:`pinkuhushenqing/${!this.ruleForm.id ? "save" : "update"}`,
                            method: "post",
                            data: this.ruleForm
                        }).then(({ data }) => {
                            if (data && data.code === 0) {
                                this.$message({
                                    message: "操作成功",
                                    type: "success",
                                    duration: 1500,
                                    onClose: () => {
                                        this.parent.showFlag = true;
                                        this.parent.addOrUpdateFlag = false;
                                        this.parent.pinkuhushenqingCrossAddOrUpdateFlag = false;
                                        this.parent.search();
                                        this.parent.contentStyleChange();
                                    }
                                });
                            } else {
                                this.$message.error(data.msg);
                            }
                        });
                    }
                });
            },
            // 获取uuid
            getUUID () {
                return new Date().getTime();
            },
            // 返回
            back() {
                this.parent.showFlag = true;
                this.parent.addOrUpdateFlag = false;
                this.parent.pinkuhushenqingCrossAddOrUpdateFlag = false;
                this.parent.contentStyleChange();
            },
            //图片
            pinkuhushenqingShenfenzhengRenxiangPhotoUploadChange(fileUrls){
                this.ruleForm.pinkuhushenqingShenfenzhengRenxiangPhoto = fileUrls;
                this.addEditUploadStyleChange()
            },
            pinkuhushenqingShenfenzhengGuohuiPhotoUploadChange(fileUrls){
                this.ruleForm.pinkuhushenqingShenfenzhengGuohuiPhoto = fileUrls;
                this.addEditUploadStyleChange()
            },
            pinkuhushenqingJuweihuiFileUploadChange(fileUrls){
                this.ruleForm.pinkuhushenqingJuweihuiFile = fileUrls;
                this.addEditUploadStyleChange()
            },

            addEditStyleChange() {
                this.$nextTick(()=>{
                    // input
                    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputFontColor
                        el.style.fontSize = this.addEditForm.inputFontSize
                        el.style.borderWidth = this.addEditForm.inputBorderWidth
                        el.style.borderStyle = this.addEditForm.inputBorderStyle
                        el.style.borderColor = this.addEditForm.inputBorderColor
                        el.style.borderRadius = this.addEditForm.inputBorderRadius
                        el.style.backgroundColor = this.addEditForm.inputBgColor
                    })
                    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputLableColor
                        el.style.fontSize = this.addEditForm.inputLableFontSize
                    })
                    // select
                    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectFontColor
                        el.style.fontSize = this.addEditForm.selectFontSize
                        el.style.borderWidth = this.addEditForm.selectBorderWidth
                        el.style.borderStyle = this.addEditForm.selectBorderStyle
                        el.style.borderColor = this.addEditForm.selectBorderColor
                        el.style.borderRadius = this.addEditForm.selectBorderRadius
                        el.style.backgroundColor = this.addEditForm.selectBgColor
                    })
                    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectLableColor
                        el.style.fontSize = this.addEditForm.selectLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
                        el.style.color = this.addEditForm.selectIconFontColor
                        el.style.fontSize = this.addEditForm.selectIconFontSize
                    })
                    // date
                    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateFontColor
                        el.style.fontSize = this.addEditForm.dateFontSize
                        el.style.borderWidth = this.addEditForm.dateBorderWidth
                        el.style.borderStyle = this.addEditForm.dateBorderStyle
                        el.style.borderColor = this.addEditForm.dateBorderColor
                        el.style.borderRadius = this.addEditForm.dateBorderRadius
                        el.style.backgroundColor = this.addEditForm.dateBgColor
                    })
                    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateLableColor
                        el.style.fontSize = this.addEditForm.dateLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
                        el.style.color = this.addEditForm.dateIconFontColor
                        el.style.fontSize = this.addEditForm.dateIconFontSize
                        el.style.lineHeight = this.addEditForm.dateHeight
                    })
                    // upload
                    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
                    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.uploadHeight
                        el.style.color = this.addEditForm.uploadLableColor
                        el.style.fontSize = this.addEditForm.uploadLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
                        el.style.color = this.addEditForm.uploadIconFontColor
                        el.style.fontSize = this.addEditForm.uploadIconFontSize
                        el.style.lineHeight = iconLineHeight
                        el.style.display = 'block'
                    })
                    // 多文本输入框
                    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
                        el.style.height = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaFontColor
                        el.style.fontSize = this.addEditForm.textareaFontSize
                        el.style.borderWidth = this.addEditForm.textareaBorderWidth
                        el.style.borderStyle = this.addEditForm.textareaBorderStyle
                        el.style.borderColor = this.addEditForm.textareaBorderColor
                        el.style.borderRadius = this.addEditForm.textareaBorderRadius
                        el.style.backgroundColor = this.addEditForm.textareaBgColor
                    })
                    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
                        // el.style.lineHeight = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaLableColor
                        el.style.fontSize = this.addEditForm.textareaLableFontSize
                    })
                    // 保存
                    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
                        el.style.width = this.addEditForm.btnSaveWidth
                        el.style.height = this.addEditForm.btnSaveHeight
                        el.style.color = this.addEditForm.btnSaveFontColor
                        el.style.fontSize = this.addEditForm.btnSaveFontSize
                        el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
                        el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
                        el.style.borderColor = this.addEditForm.btnSaveBorderColor
                        el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnSaveBgColor
                    })
                    // 返回
                    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
                        el.style.width = this.addEditForm.btnCancelWidth
                        el.style.height = this.addEditForm.btnCancelHeight
                        el.style.color = this.addEditForm.btnCancelFontColor
                        el.style.fontSize = this.addEditForm.btnCancelFontSize
                        el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
                        el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
                        el.style.borderColor = this.addEditForm.btnCancelBorderColor
                        el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnCancelBgColor
                    })
                })
            },
            addEditUploadStyleChange() {
                this.$nextTick(()=>{
                    document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                })
            },
        }
    };
</script>
<style lang="scss">
.editor{
  height: 500px;

  & /deep/ .ql-container {
	  height: 310px;
  }
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
}
.btn .el-button {
  padding: 0;
}</style>

