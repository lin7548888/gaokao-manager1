<template>
  <div class="app-container">
    <cus-wraper>
      <cus-filter-wraper>
                        <!-- <el-button type="primary" @click="getList" icon="el-icon-search" v-waves>查询</el-button> -->
        <!-- <el-button type="primary" @click="handleCreate" icon="el-icon-plus" v-waves>添加</el-button>         -->
              </cus-filter-wraper>
      <div class="table-container">
        <el-table v-loading="listLoading" :data="list" size="mini" element-loading-text="Loading" fit border highlight-current-row>
	        	        	        <el-table-column label="键" prop="configKey" align="center"></el-table-column>
	        	        	        	        <el-table-column label="值" prop="configValue" align="center"></el-table-column>
	        	        	        	        <el-table-column label="描述" prop="configDesc" align="center"></el-table-column>
	        	                  <el-table-column align="center" label="操作">
            <template slot-scope="scope">
              <el-button size="mini" type="primary" @click="handleUpdate(scope.row)" icon="el-icon-edit" plain v-waves>编辑</el-button>
              <cus-del-btn @ok="handleDelete(scope.row)"></cus-del-btn>
            </template>
          </el-table-column>
        </el-table>
        <!-- 分页 -->
        <cus-pagination v-show="total>0" :total="total" :page.sync="listQuery.page" :limit.sync="listQuery.limit" @pagination="getList"/>
      </div>

      <el-dialog :title="titleMap[dialogStatus]" :visible.sync="dialogVisible" width="40%" @close="handleDialogClose">
        <el-form ref="dataForm" :model="form" :rules="rules" label-width="100px" class="demo-ruleForm">
                <el-form-item label="键:" prop="configKey">
            <el-input v-model="form.configKey"></el-input>
        </el-form-item>
                <el-form-item label="值:" prop="configValue">
            <el-input v-model="form.configValue"></el-input>
        </el-form-item>
                <el-form-item label="描述:" prop="configDesc">
            <el-input v-model="form.configDesc"></el-input>
        </el-form-item>
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
 import { getGlobalConfigPage, saveOrUpdateGlobalConfig, deleteGlobalConfig } from "@/api/gaokao/banner";

export default {
  name: 'GlobalConfig',
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
	     	     configKey: undefined, //键
	     	     configValue: undefined, //值
	     	     configDesc: undefined, //描述
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
      getGlobalConfigPage(this.listQuery).then(response => {
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
      				 let id = row.configKey;
			  			  			        deleteGlobalConfig(id).then(response => {
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
            saveOrUpdateGlobalConfig(this.form).then(response => {
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
                            configKey: undefined, //键
                            configValue: undefined, //值
                            configDesc: undefined, //描述
                    };
    },
    // 监听dialog关闭时的处理事件
    handleDialogClose(){
        if(this.$refs['dataForm']){
             this.$refs['dataForm'].clearValidate(); // 清除整个表单的校验
        }
    }
  }
}
</script>
