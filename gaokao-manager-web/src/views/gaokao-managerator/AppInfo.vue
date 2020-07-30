<template>
  <div class="app-container">
    <cus-wraper>
      <cus-filter-wraper>
        <!--<el-button type="primary" @click="getList" icon="el-icon-search" v-waves>查询</el-button>-->
        <el-button type="primary" @click="handleCreate" icon="el-icon-plus" v-waves>添加</el-button>
      </cus-filter-wraper>
      <div class="table-container">
        <el-table v-loading="listLoading" :data="list" size="mini" element-loading-text="Loading" fit border
                  highlight-current-row>
          <!--<el-table-column label="流水号" prop="id" align="center"></el-table-column>
          <el-table-column label="app类型，1android 2ios" prop="type" align="center"></el-table-column>-->
          <el-table-column label="版本号" prop="version" align="center"></el-table-column>
          <el-table-column label="下载" prop="downloadUrl" align="center">
            <template slot-scope="scope">
              <a :href="scope.row.downloadUrl" target="_blank">下载安装包</a>
            </template>
          </el-table-column>
          <el-table-column label="更新日志" prop="updateLog" align="center">
            <template slot-scope="scope">
              <div v-html="changeToBr(scope.row.updateLog)" style="text-align: left"></div>
            </template>
          </el-table-column>
          <el-table-column label="是否强制升级？" prop="forceUpdate" align="center">
            <template slot-scope="scope">
              <span>{{ scope.row.forceUpdate==0 ? '否':'是' }}</span>
            </template>
          </el-table-column>
          <el-table-column label="发布状态" prop="status" align="center">
            <template slot-scope="scope">
              <el-switch
                v-model="scope.row.status"
                :active-value=1
                :inactive-value=0
                active-text="已发布"
                inactive-text="未发布"
                @change="changeStatus(scope.row)">
              </el-switch>
            </template>
          </el-table-column>
          <el-table-column label="创建时间" align="center">
            <template slot-scope="scope">
              <span>{{scope.row.ctime|dateTimeFilter}}</span>
            </template>
          </el-table-column>
          <!--<el-table-column label="创建人" prop="cUserId" align="center"></el-table-column>
          <el-table-column label="修改时间" align="center">
            <template slot-scope="scope">
              <span>{{scope.row.mTime|dateTimeFilter}}</span>
            </template>
          </el-table-column>
          <el-table-column label="修改人" prop="mUserId" align="center"></el-table-column>-->
          <el-table-column align="center" label="操作">
            <template slot-scope="scope">
              <el-button size="mini" type="primary" @click="handleUpdate(scope.row)" icon="el-icon-edit" plain v-waves>
                编辑
              </el-button>
              <cus-del-btn @ok="handleDelete(scope.row)"></cus-del-btn>
            </template>
          </el-table-column>
        </el-table>
        <!-- 分页 -->
        <cus-pagination v-show="total>0" :total="total" :page.sync="listQuery.page" :limit.sync="listQuery.limit"
                        @pagination="getList"/>
      </div>

      <el-dialog :title="titleMap[dialogStatus]" :visible.sync="dialogVisible" width="40%" @close="handleDialogClose">
        <el-form ref="dataForm" :model="form" :rules="rules" label-width="100px" class="demo-ruleForm">
          <el-form-item label="版本号:" prop="version">
            <el-input v-model="form.version"></el-input>
          </el-form-item>
          <el-form-item label="更新日志，多条用“|”分隔:" prop="updateLog">
            <el-input v-model="form.updateLog"></el-input>
          </el-form-item>
          <el-form-item label="强制升级:" prop="forceUpdate">
            <el-radio-group v-model="form.forceUpdate">
              <el-radio :label="1">是</el-radio>
              <el-radio :label="0">否</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="升级包:" prop="icon">
            <el-upload
              ref="myUploadApk"
              class="upload-demo"
              :action="uploadUrl"
              drag
              accept=".apk"
              :before-upload="beforeUpload"
              :on-success="handleImageSuccess"
              :headers="headers">
              <i class="el-icon-upload"></i>
              <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
              <div class="el-upload__tip" slot="tip">只能上传.apk文件，且不超过100MB</div>
            </el-upload>
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
  import { getAppInfoPage, saveOrUpdateAppInfo, deleteAppInfo, changeAppStatus } from '@/api/gaokao/appInfo'
  import { getToken } from '@/utils/auth'

  export default {
    name: 'AppInfo',
    data() {
      return {
        headers: { 'X-Token': getToken() },
        uploadUrl: process.env.BASE_API + '/uploadFile',
        dialogVisible: false,
        list: [],
        listLoading: true,
        total: 0,
        listQuery: {
          page: 1,
          limit: 10
        },
        input: '',
        form: {
          id: undefined, //流水号
          version: undefined, //版本号
          downloadUrl: undefined, //下载地址
          updateLog: undefined, //更新日志，多条用|分隔
          forceUpdate: 1 //是否强制升级
        },
        dialogStatus: '',
        titleMap: {
          update: '编辑',
          create: '创建'
        },
        rules: {
          version: [
            { required: true, message: '请输入版本号', trigger: 'blur' }
          ]
        }
      }
    },
    created() {
      this.getList()
    },
    methods: {
      getList() {
        this.listLoading = true
        getAppInfoPage(this.listQuery).then(response => {
          this.list = response.data.records
          this.total = parseInt(response.data.total)
          this.listLoading = false
        })
      },
      handleCreate() {
        this.resetForm()
        this.dialogStatus = 'create'
        this.dialogVisible = true
      },
      handleUpdate(row) {
        this.form = Object.assign({}, row)
        this.dialogStatus = 'update'
        this.dialogVisible = true
      },
      handleDelete(row) {
        let id = row.id
        deleteAppInfo(id).then(response => {
          if (response.code == 200) {
            this.getList()
            this.submitOk(response.message)
          } else {
            this.submitFail(response.message)
          }
        })
      },
      submitForm() {
        this.$refs.dataForm.validate(valid => {
          if (valid) {
            if (this.form.id == undefined && this.form.downloadUrl == undefined) {
              alert('请选择升级包')
              return
            }
            saveOrUpdateAppInfo(this.form).then(response => {
              if (response.code == 200) {
                this.getList()
                this.submitOk(response.message)
                this.dialogVisible = false
                this.$refs['myUploadApk'].clearFiles()
              } else {
                this.submitFail(response.message)
              }
            }).catch(err => {
              console.log(err)
            })
          }
        })
      },
      resetForm() {
        this.form = {
          id: undefined, //流水号
          version: undefined, //版本号
          downloadUrl: undefined, //下载地址
          updateLog: undefined, //更新日志，多条用|分隔
          forceUpdate: 1 //是否强制升级
        }
      },
      // 监听dialog关闭时的处理事件
      handleDialogClose() {
        if (this.$refs['dataForm']) {
          this.$refs['dataForm'].clearValidate() // 清除整个表单的校验
          this.$refs['myUploadApk'].clearFiles()
        }
      },
      changeStatus(row) {
        let id = row.id
        let status = row.status
        changeAppStatus(id, status).then(response => {
          if (response.code == 200) {
            this.submitOk(response.message)
          } else {
            this.submitFail(response.message)
          }
        })
      },
      handleImageSuccess(response, file, fileList) {
        if (response.code == 200) {
          this.form.downloadUrl = response.data.fileUrl
        } else {
          this.submitFail(response.message)
        }
      },
      beforeUpload(file) {
        const isAPK = file.type === 'application/vnd.android.package-archive'
        const isLt2M = file.size / 1024 / 1024 < 100

        if (!isAPK) {
          this.submitFail('上传文件只能是.apk格式!')
          return false
        }
        if (!isLt2M) {
          this.submitFail('上传文件大小不能超过 100MB!')
          return false
        }
      }
    }
  }
</script>
