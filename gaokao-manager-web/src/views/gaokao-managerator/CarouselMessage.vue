<template>
  <div class="app-container">
    <cus-wraper>
      <cus-filter-wraper>
                        <!-- <el-button type="primary" @click="getList" icon="el-icon-search" v-waves>查询</el-button> -->
        <el-button type="primary" @click="handleCreate" icon="el-icon-plus" v-waves>添加</el-button>        
              </cus-filter-wraper>
      <div class="table-container">
        <el-table v-loading="listLoading" :data="list" size="mini" element-loading-text="Loading" fit border highlight-current-row>
	        	        	        <el-table-column label="消息id" prop="id" align="center"></el-table-column>
	        	        	        	        <el-table-column label="订单id" prop="orderId" align="center"></el-table-column>
	        	        	        	        <el-table-column label="消息内容" prop="message" align="center"></el-table-column>
	        	        	        	        <el-table-column label="消息类别" prop="type" align="center"></el-table-column>
	        	        	        	        <el-table-column label="显示状态" prop="status" align="center">
                                          <template slot-scope="scope">
              <el-switch
                v-model="scope.row.status"
                :active-value=1
                :inactive-value=0
                active-text="显示"
                inactive-text="不显示"
                @change="changeStatus(scope.row)">
              </el-switch>
            </template>
                                        </el-table-column>
	        	        	        	        <el-table-column label="创建时间" align="center">
	            <template slot-scope="scope">
	                <span>{{scope.row.cTime|dateTimeFilter}}</span>
	            </template>
	        </el-table-column>
	        	        	        	        <el-table-column label="创建人" prop="cUserId" align="center"></el-table-column>
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
                <!-- <el-form-item label="消息id:" prop="id">
            <el-input v-model="form.id"></el-input>
        </el-form-item> -->
                <el-form-item label="订单id:" prop="orderId">
            <el-input v-model="form.orderId"></el-input>
        </el-form-item>
                <el-form-item label="消息内容:" prop="message">
            <el-input v-model="form.message"></el-input>
        </el-form-item>
                <el-form-item label="消息类别:" prop="type">
            <el-input v-model="form.type"></el-input>
        </el-form-item>
                <!-- <el-form-item label="状态，0不显示消息，1显示消息:" prop="status">
            <el-input v-model="form.status"></el-input>
        </el-form-item> -->
                <!-- <el-form-item label="创建时间:" prop="cTime">
            <el-input v-model="form.cTime"></el-input>
        </el-form-item> -->
                <!-- <el-form-item label="创建人:" prop="cUserId">
            <el-input v-model="form.cUserId"></el-input>
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
 import { getCarouselMessageInfoPage, saveOrUpdateCarouselMessageInfo, deleteCarouselMessageInfo, changeCarouselStatus } from "@/api/gaokao/carouselMessageInfo";

export default {
  name: 'CarouselMessageInfo',
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
	     	     id: undefined, //消息id
	     	     orderId: undefined, //订单id
	     	     message: undefined, //消息内容
	     	     type: undefined, //消息类别
	     	     status: undefined, //状态，0不显示消息，1显示消息
	     	     cTime: undefined, //创建时间
	     	     cUserId: undefined, //创建人
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
      getCarouselMessageInfoPage(this.listQuery).then(response => {
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
			  			  			  			  			  			  			        deleteCarouselMessageInfo(id).then(response => {
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
            saveOrUpdateCarouselMessageInfo(this.form).then(response => {
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
                            id: undefined, //消息id
                            orderId: undefined, //订单id
                            message: undefined, //消息内容
                            type: undefined, //消息类别
                            status: undefined, //状态，0不显示消息，1显示消息
                            cTime: undefined, //创建时间
                            cUserId: undefined, //创建人
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
        changeCarouselStatus(id, status).then(response => {
          if (response.code == 200) {
            this.submitOk(response.message)
          } else {
            this.submitFail(response.message)
          }
        })
      }
  }
}
</script>
