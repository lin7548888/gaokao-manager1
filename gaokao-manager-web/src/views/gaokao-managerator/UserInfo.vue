<template>
  <div class="app-container">
    <cus-wraper>
      <cus-filter-wraper>
                        <!-- <el-button type="primary" @click="getList" icon="el-icon-search" v-waves>查询</el-button>
        <el-button type="primary" @click="handleCreate" icon="el-icon-plus" v-waves>添加</el-button>         -->
              </cus-filter-wraper>
      <div class="table-container">
        <el-table v-loading="listLoading" :data="list" size="mini" element-loading-text="Loading" fit border highlight-current-row>
	        	        	        <!-- <el-table-column label="用户id" prop="id" align="center"></el-table-column> -->
	        	        	        	        <el-table-column label="手机号" prop="phoneNum" align="center"></el-table-column>
	        	        	        	        <!-- <el-table-column label="用户名" prop="username" align="center"></el-table-column> -->
	        	        	        	        <!-- <el-table-column label="密码" prop="password" align="center"></el-table-column> -->
	        	        	        	        <!-- <el-table-column label="用户角色 1普通用户  2专家" prop="role" align="center"></el-table-column> -->
	        	        	        	        <el-table-column label="性别 1男  2女 0未知" prop="sex" align="center"></el-table-column>
	        	        	        	        <el-table-column label="年龄" prop="age" align="center"></el-table-column>
	        	        	        	        <el-table-column label="真实姓名" prop="realname" align="center"></el-table-column>
	        	        	        	        <el-table-column label="显示状态" prop="status" align="center">
	        	        	        	        <template slot-scope="scope">
              <el-switch
                v-model="scope.row.status"
                :active-value=1
                :inactive-value=0
                active-text=""
                inactive-text=""
                @change="changeStatus(scope.row)">
              </el-switch>
            </template>
            </el-table-column>
                                                <el-table-column label="是否购买了vip" prop="buyVip" align="center"></el-table-column>
	        	        	        	        <el-table-column label="是否购买了专家一对一" prop="buyExpert" align="center"></el-table-column>
	        	        	        	        <el-table-column label="最后一次登录时间" align="center">
	            <template slot-scope="scope">
	                <span>{{scope.row.lastLoginTime|dateTimeFilter}}</span>
	            </template>
	        </el-table-column>
	        	        	        	        <!-- <el-table-column label="微信同一个开发者帐号多个应用之间UnionID相同" prop="wxUnionId" align="center"></el-table-column> -->
	        	        	        	        <el-table-column label="头像" prop="headImage" align="center"></el-table-column>
	        	        	        	        <el-table-column label="高考年份" prop="gkYear" align="center"></el-table-column>
	        	        	        	        <el-table-column label="高考省份" prop="gkProvinceId" align="center"></el-table-column>
	        	        	        	        <el-table-column label="高考分数" prop="gkScore" align="center"></el-table-column>
	        	        	        	        <el-table-column label="文理科：1文科  2理科" prop="gkSubject" align="center"></el-table-column>
	        	        	        	        <el-table-column label="每一科的分数" prop="gkPerScore" align="center"></el-table-column>
	        	        	        	        <!-- <el-table-column label="用户当前的sessionId，用于实现单一设备登录" prop="currentSessionId" align="center"></el-table-column> -->
	        	        	        	        <!-- <el-table-column label="用户当前的deviceId，用于实现单一设备登录" prop="currentDeviceId" align="center"></el-table-column> -->
	        	        	        	        <el-table-column label="测评分数，地址栏参数" prop="evaluationScore" align="center"></el-table-column>
	        	        	        	        <el-table-column label="创建时间" align="center">
	            <template slot-scope="scope">
	                <span>{{scope.row.cTime|dateTimeFilter}}</span>
	            </template>
	        </el-table-column>
	        	        	        	        <!-- <el-table-column label="创建人" prop="cUserId" align="center"></el-table-column> -->
	        	        	        	        <!-- <el-table-column label="修改时间" align="center">
	            <template slot-scope="scope">
	                <span>{{scope.row.mTime|dateTimeFilter}}</span>
	            </template>
	        </el-table-column> -->
	        	        	        	        <!-- <el-table-column label="修改人" prop="mUserId" align="center"></el-table-column> -->
	        	                  <el-table-column align="center" label="操作">
            <template slot-scope="scope">
              <el-button size="mini" type="primary" @click="handleUpdate(scope.row)" icon="el-icon-edit" plain v-waves>编辑</el-button>
              <!-- <cus-del-btn @ok="handleDelete(scope.row)"></cus-del-btn> -->
            </template>
          </el-table-column>
        </el-table>
        <!-- 分页 -->
        <cus-pagination v-show="total>0" :total="total" :page.sync="listQuery.page" :limit.sync="listQuery.limit" @pagination="getList"/>
      </div>

      <el-dialog :title="titleMap[dialogStatus]" :visible.sync="dialogVisible" width="40%" @close="handleDialogClose">
        <el-form ref="dataForm" :model="form" :rules="rules" label-width="100px" class="demo-ruleForm">
                <!-- <el-form-item label="用户id:" prop="id">
            <el-input v-model="form.id"></el-input>
        </el-form-item> -->
                <el-form-item label="手机号" prop="phoneNum">
            <el-input v-model="form.phoneNum"></el-input>
        </el-form-item>
                <el-form-item label="用户名:" prop="username">
            <el-input v-model="form.username"></el-input>
        </el-form-item>
                <!-- <el-form-item label="密码:" prop="password">
            <el-input v-model="form.password"></el-input>
        </el-form-item> -->
                <el-form-item label="用户角色 1普通用户  2专家:" prop="role">
            <el-input v-model="form.role"></el-input>
        </el-form-item>
                <el-form-item label="性别 1男  2女 0未知:" prop="sex">
            <el-input v-model="form.sex"></el-input>
        </el-form-item>
                <el-form-item label="年龄:" prop="age">
            <el-input v-model="form.age"></el-input>
        </el-form-item>
                <el-form-item label="真实姓名:" prop="realname">
            <el-input v-model="form.realname"></el-input>
        </el-form-item>
                <!-- <el-form-item label="当前状态 1正常 0禁用:" prop="status">
            <el-input v-model="form.status"></el-input>
        </el-form-item> -->
                <!-- <el-form-item label="是否购买了vip，1是 0否:" prop="buyVip">
            <el-input v-model="form.buyVip"></el-input>
        </el-form-item> -->
                <el-form-item label="是否购买了专家一对一，0否  1基础版  2高级版  3白金版:" prop="buyExpert">
            <el-input v-model="form.buyExpert"></el-input>
        </el-form-item>
                <el-form-item label="最后一次登录时间:" prop="lastLoginTime">
            <el-input v-model="form.lastLoginTime"></el-input>
        </el-form-item>
                <!-- <el-form-item label="微信同一个开发者帐号多个应用之间UnionID相同:" prop="wxUnionId">
            <el-input v-model="form.wxUnionId"></el-input>
        </el-form-item> -->
                <el-form-item label="头像:" prop="headImage">
            <el-input v-model="form.headImage"></el-input>
        </el-form-item>
                <el-form-item label="高考年份:" prop="gkYear">
            <el-input v-model="form.gkYear"></el-input>
        </el-form-item>
                <el-form-item label="高考省份:" prop="gkProvinceId">
            <el-input v-model="form.gkProvinceId"></el-input>
        </el-form-item>
                <el-form-item label="高考分数:" prop="gkScore">
            <el-input v-model="form.gkScore"></el-input>
        </el-form-item>
                <el-form-item label="文理科：1文科  2理科:" prop="gkSubject">
            <el-input v-model="form.gkSubject"></el-input>
        </el-form-item>
                <el-form-item label="每一科的分数:" prop="gkPerScore">
            <el-input v-model="form.gkPerScore"></el-input>
        </el-form-item>
                <!-- <el-form-item label="用户当前的sessionId，用于实现单一设备登录:" prop="currentSessionId">
            <el-input v-model="form.currentSessionId"></el-input>
        </el-form-item> -->
                <!-- <el-form-item label="用户当前的deviceId，用于实现单一设备登录:" prop="currentDeviceId">
            <el-input v-model="form.currentDeviceId"></el-input>
        </el-form-item> -->
                <el-form-item label="测评分数，地址栏参数:" prop="evaluationScore">
            <el-input v-model="form.evaluationScore"></el-input>
        </el-form-item>
                <el-form-item label="创建时间:" prop="cTime">
            <el-input v-model="form.cTime"></el-input>
        </el-form-item>
                <!-- <el-form-item label="创建人:" prop="cUserId">
            <el-input v-model="form.cUserId"></el-input>
        </el-form-item> -->
                <!-- <el-form-item label="修改时间:" prop="mTime">
            <el-input v-model="form.mTime"></el-input>
        </el-form-item> -->
                <!-- <el-form-item label="修改人:" prop="mUserId">
            <el-input v-model="form.mUserId"></el-input>
        </el-form-item> -->
                </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="dialogVisible = false" v-waves>取 消</el-button>
          <el-button type="primary" @click="submitForm" v-waves>确 定</el-button>
        </span>
      </el-dialog>
    </cus-wraper>
  </div>
</template>

<script>
 import { getUserInfoPage, saveOrUpdateUserInfo, deleteUserInfo, changeUserInfoStatus } from "@/api/gaokao/userInfo";

export default {
  name: 'UserInfo',
  data() {
    return {
      dialogVisible: false,
      list: [],
      listLoading: true,
      total: 0,
      listQuery: {
        page: 1,
        limit: 10,
	    	    	          },
      input: '',
      form: {
	     	     id: undefined, //用户id
	     	     phoneNum: undefined, //手机号，目前通过手机号+验证码登录
	     	     username: undefined, //用户名
	     	     password: undefined, //密码
	     	     role: undefined, //用户角色 1普通用户  2专家
	     	     sex: undefined, //性别 1男  2女 0未知
	     	     age: undefined, //年龄
	     	     realname: undefined, //真实姓名
	     	     status: undefined, //当前状态 1正常 0禁用
	     	     buyVip: undefined, //是否购买了vip，1是 0否
	     	     buyExpert: undefined, //是否购买了专家一对一，0否  1基础版  2高级版  3白金版
	     	     lastLoginTime: undefined, //最后一次登录时间
	     	     wxUnionId: undefined, //微信同一个开发者帐号多个应用之间UnionID相同
	     	     headImage: undefined, //头像
	     	     gkYear: undefined, //高考年份
	     	     gkProvinceId: undefined, //高考省份
	     	     gkScore: undefined, //高考分数
	     	     gkSubject: undefined, //文理科：1文科  2理科
	     	     gkPerScore: undefined, //每一科的分数
	     	     currentSessionId: undefined, //用户当前的sessionId，用于实现单一设备登录
	     	     currentDeviceId: undefined, //用户当前的deviceId，用于实现单一设备登录
	     	     evaluationScore: undefined, //测评分数，地址栏参数
	     	     cTime: undefined, //创建时间
	     	     cUserId: undefined, //创建人
	     	     mTime: undefined, //修改时间
	     	     mUserId: undefined, //修改人
	           },
     dialogStatus: "",
     titleMap: {
        update: "编辑",
        create: "创建"
     },
     rules: {
         name: [
            { required: true, message: '请输入项目名称', trigger: 'blur' }
         ]
      }
    }
  },
  created() {
    this.getList();
  },
  methods: {
    getList() {
      this.listLoading = true;
      getUserInfoPage(this.listQuery).then(response => {
        this.list = response.data.records;
    	this.total = response.data.total;
    	this.listLoading = false;
		});
    },
    handleCreate() {
        this.resetForm();
        this.dialogStatus = "create";
        this.dialogVisible = true;
    },
    handleUpdate(row) {
        this.form = Object.assign({}, row);
        this.dialogStatus = "update";
        this.dialogVisible = true;
    },
    handleDelete(row) {
      				 let id = row.id;
			  			  			  			  			  			  			  			  			  			  			  			  			  			  			  			  			  			  			  			  			  			  			  			  			  			        deleteUserInfo(id).then(response => {
            if (response.code == 200) {
            this.getList();
            this.submitOk(response.message);
        } else {
            this.submitFail(response.message);
        }
    });
    },
    submitForm() {
    this.$refs.dataForm.validate(valid => {
        if (valid) {
            saveOrUpdateUserInfo(this.form).then(response => {
                if (response.code == 200) {
                    this.getList();
                    this.submitOk(response.message);
                    this.dialogVisible = false;
                } else {
                     this.submitFail(response.message);
                }
        }).catch(err => { console.log(err);  });
            }
        });
    },
    resetForm() {
        this.form = {
                            id: undefined, //用户id
                            phoneNum: undefined, //手机号，目前通过手机号+验证码登录
                            username: undefined, //用户名
                            password: undefined, //密码
                            role: undefined, //用户角色 1普通用户  2专家
                            sex: undefined, //性别 1男  2女 0未知
                            age: undefined, //年龄
                            realname: undefined, //真实姓名
                            status: undefined, //当前状态 1正常 0禁用
                            buyVip: undefined, //是否购买了vip，1是 0否
                            buyExpert: undefined, //是否购买了专家一对一，0否  1基础版  2高级版  3白金版
                            lastLoginTime: undefined, //最后一次登录时间
                            wxUnionId: undefined, //微信同一个开发者帐号多个应用之间UnionID相同
                            headImage: undefined, //头像
                            gkYear: undefined, //高考年份
                            gkProvinceId: undefined, //高考省份
                            gkScore: undefined, //高考分数
                            gkSubject: undefined, //文理科：1文科  2理科
                            gkPerScore: undefined, //每一科的分数
                            currentSessionId: undefined, //用户当前的sessionId，用于实现单一设备登录
                            currentDeviceId: undefined, //用户当前的deviceId，用于实现单一设备登录
                            evaluationScore: undefined, //测评分数，地址栏参数
                            cTime: undefined, //创建时间
                            cUserId: undefined, //创建人
                            mTime: undefined, //修改时间
                            mUserId: undefined, //修改人
                    };
    },
    // 监听dialog关闭时的处理事件
    handleDialogClose(){
        if(this.$refs['dataForm']){
             this.$refs['dataForm'].clearValidate(); // 清除整个表单的校验
        }
    },
    changeStatus(row) {
        let id = row.id
        let status = row.status
        changeUserInfoStatus(id, status).then(response => {
          if (response.code == 200) {
            this.submitOk(response.message)
          } else {
            this.submitFail(response.message)
          }
        })
      },
  }
}
</script>
