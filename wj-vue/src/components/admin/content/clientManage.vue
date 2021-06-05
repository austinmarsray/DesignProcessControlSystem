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
        <el-breadcrumb-item>客户管理</el-breadcrumb-item>
        <el-breadcrumb-item>客户信息</el-breadcrumb-item>
      </el-breadcrumb>
    </el-row>

    <el-card style="margin: 18px 2%;width: 95%">
      <el-table
        :data="users"
        stripe
        :default-sort = "{prop: 'id', order: 'ascending'}"
        style="width: 100%"
        :max-height="tableHeight">
        <el-table-column
          type="selection"
          width="55">
        </el-table-column>
        <el-table-column
          prop="clientNo"
          label="客户编号"
          sortable
          width="100">
        </el-table-column>
        <el-table-column
          prop="clientName"
          label="客户姓名"
          fit>
        </el-table-column>
        <el-table-column
          prop="funit"
          label="单位"
          fit>
        </el-table-column>
        <el-table-column
          prop="phone"
          label="手机号"
          fit>
        </el-table-column>
        <el-table-column
          prop="email"
          label="邮箱"
          show-overflow-tooltip
          fit>
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
            <el-button
              @click="delUser(scope.row)"
              type="text"
              size="small">
              移除
            </el-button>
          </template>
        </el-table-column>
      </el-table>
      <div style="margin: 20px 0 20px 0;float: left">
        <el-button>取消选择</el-button>
        <el-button>批量删除</el-button>
      </div>
    </el-card>
  </div>
</template>

<script>
    export default {
      name: 'clientManage',
      data () {
          return {
            users: [],
            roles: [],
            dialogFormVisible: false,
            selectedUser: [],
            selectedRolesIds: []
          }
      },
      mounted () {
        this.listUsers()
      },
      computed: {
        tableHeight () {
          return window.innerHeight - 320
        }
      },
      methods: {
        listUsers () {
          var _this = this
          this.$axios.get('/client/getList').then(resp => {
            if (resp && resp.data.code === 200) {
              _this.users = resp.data.result
            }
          })
        },
        onSubmit (user) {
          this.$axios
            .post('/client/update', { //添加路径
                clientNo: user.clientNo,
                clientName: user.clientName,
                phone: user.phone,
                telphone: user.telphone,
                qq: user.qq,
                email: user.email,
                funit: user.funit,
                sunit: user.sunit,
                tunit: user.tunit
            })
            .then(resp => {
              if (resp.data.code === 200) {
                this.$alert('修改成功', '提示', {
                  confirmButtonText: '确定'
                })
                this.clear()
                this.$emit('onSubmit')
              } else {
                this.$alert(resp.data.message, '提示', {
                  confirmButtonText: '确定'
                })
              }
            })
            .catch(failResponse => {})
            this.dialogFormVisible = false
        },
        editUser (user) {
          this.dialogFormVisible = true
          this.selectedUser = user
        },
        delUser (user) {
          this.selectedUser = user
          let roleIds = this.selectedUser.clientNo
          this.$axios.post('/client/delete', {
            clientNo: roleIds,
          }).then(resp => {
            if (resp && resp.data.code === 200) {
              this.$alert(resp.data.message)
              this.listUsers()
            } else {
              this.$alert(resp.data.message)
            }
          })
        }
      }
    }
</script>

<style scoped>

</style>
