<template>
  <div>
    <el-dialog
      title="修改客户信息"
      :visible.sync="dialogFormVisible">
      <el-form v-model="selectedUser" style="text-align: left" ref="dataForm">

        <el-form-item label="客户编号" label-width="120px" prop="clientNo">
          <label>{{selectedUser.clientNo}}</label>
        </el-form-item>

        <el-form-item label="客户名" label-width="120px" prop="clientName">
          <label>{{selectedUser.clientName}}</label>
        </el-form-item>

        <el-form-item prop="phone" label-width="120px" label="电话号码1">
          <el-input type="text" v-model="selectedUser.phone"
                    auto-complete="off" placeholder="电话号码1"></el-input>
        </el-form-item>

        <el-form-item prop="telphone" label-width="120px" label="电话号码2">
          <el-input type="text" v-model="selectedUser.telphone"
                    auto-complete="off" placeholder="电话号码2"></el-input>
        </el-form-item>

        <el-form-item prop="QQ" label-width="120px" label="QQ">
          <el-input type="text" v-model="selectedUser.qq"
                    auto-complete="off" placeholder="QQ"></el-input>
        </el-form-item>

        <el-form-item prop="email" label-width="120px" label="Email">
          <el-input type="text" v-model="selectedUser.email"
                    auto-complete="off" placeholder="email"></el-input>
        </el-form-item>

        <el-form-item prop="Funit" label-width="120px" label="一级单位">
          <el-input type="text" v-model="selectedUser.funit"
                    auto-complete="off" placeholder="一级单位"></el-input>
        </el-form-item>

        <el-form-item prop="Sunit" label-width="120px" label="二级单位">
          <el-input type="text" v-model="selectedUser.sunit"
                    auto-complete="off" placeholder="二级单位"></el-input>
        </el-form-item>
        <el-form-item prop="Tunit" label-width="120px" label="三级单位">
          <el-input type="text" v-model="selectedUser.tunit"
                    auto-complete="off" placeholder="三级单位"></el-input>
        </el-form-item>

      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="onSubmit(selectedUser)">确 定</el-button>
      </div>
    </el-dialog>


    <el-row style="margin: 18px 0px 0px 18px ">
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item :to="{ path: '/admin/dashboard' }">管理中心</el-breadcrumb-item>
        <el-breadcrumb-item>项目管理</el-breadcrumb-item>
        <el-breadcrumb-item>项目信息</el-breadcrumb-item>
      </el-breadcrumb>
    </el-row>

    <el-card style="margin: 18px 2%;width: 95%">
      <el-table
        :data="pros"
        stripe
        :default-sort = "{prop: 'id', order: 'ascending'}"
        style="width: 100%"
        :max-height="tableHeight">
        <el-table-column
          type="selection"
          width="55">
        </el-table-column>
        <el-table-column
          prop="ProNo"
          label="项目编号"
          sortable
          width="100">
        </el-table-column>
        <el-table-column
          prop="ProName"
          label="项目名称"
          fit>
        </el-table-column>
        <el-table-column
          prop="setDate"
          label="项目创建日期"
          fit>
        </el-table-column>
        <el-table-column
          prop="isFinish"
          label="完成状态"
          fit>
        <template slot-scope="scope">
            <el-tag
                :type="scope.row.isFinish == '1' ? '' : scope.row.isFinish == '0'?'success':'danger'"
                disable-transitions>{{scope.row.isFinish == '1' ?"已完成":"未完成"}}
            </el-tag>
        </template>
        </el-table-column>

        <el-table-column
          label="操作"
          width="120">
          <template slot-scope="scope">
            <el-button
              @click="editUser(scope.row)"
              type="text"
              size="small">
              编辑
            </el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-card>
  </div>
</template>

<script>
    export default {
      name: 'clientManage',
      data () {
          return {
            pros: [],
            users: [],
            roles: [],
            dialogFormVisible: false,
            selectedUser: [],
            selectedRolesIds: []
          }
      },
      mounted () {
        this.listPros()
      },
      computed: {
        tableHeight () {
          return window.innerHeight - 320
        }
      },
      methods: {
        listPros () {
          this.pros = [
              {"ProNo":"P00001","ProName":"广汉商城地产设计","setDate":"2020-12-20","isFinish":1},
              {"ProNo":"P00002","ProName":"谷齐家园小区设计","setDate":"2021-1-18","isFinish":0},
              {"ProNo":"P00003","ProName":"XX地产设计","setDate":"2020-11-20","isFinish":0},
              {"ProNo":"P00004","ProName":"XX商城地产设计","setDate":"2020-12-2","isFinish":1},
              {"ProNo":"P00005","ProName":"YY地产设计","setDate":"2020-12-23","isFinish":0}
          ]
        }
      }
    }
</script>

<style scoped>

</style>
