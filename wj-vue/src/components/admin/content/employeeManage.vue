<template>
  <div>
    <el-dialog
      title="修改员工信息"
      :visible.sync="dialogFormVisible">
      <el-form v-model="selectedUser" style="text-align: left" ref="dataForm">

        <el-form-item label="员工编号" label-width="120px" prop="clientNo">
          <label>{{selectedUser.employeeNo}}</label>
        </el-form-item>

        <el-form-item label="员工姓名" label-width="120px" prop="clientName">
          <label>{{selectedUser.employeeName}}</label>
        </el-form-item>

        <el-form-item prop="id" label="身份证号" label-width="120px">
          <el-input type="text" v-model="selectedUser.id"
                    auto-complete="off" placeholder="身份证号"></el-input>
        </el-form-item>

        <el-form-item prop="gender" label="性别" label-width="120px">
          <el-input type="text" v-model="selectedUser.gender"
                    auto-complete="off" placeholder="性别"></el-input>
        </el-form-item>

        <el-form-item label="政治面貌" prop="political" label-width="120px">
            <el-select v-model="selectedUser.political" placeholder="请选择政治面貌" style="width: 100%;">
                <el-option label="群众" value="群众"></el-option>
                <el-option label="共青团员" value="共青团员"></el-option>
                <el-option label="共产党员" value="共产党员"></el-option>
            </el-select>
        </el-form-item>

        <el-form-item prop="birthday" label="出生日期" label-width="120px">
            <el-date-picker type="date" placeholder="选择日期" v-model="selectedUser.birthday" style="width: 100%;"></el-date-picker>
        </el-form-item>

        <el-form-item prop="entry" label="入职日期" label-width="120px">
          <el-date-picker type="date" placeholder="选择日期" v-model="selectedUser.entry" style="width: 100%;"></el-date-picker>
        </el-form-item>

        <el-form-item label="所属部门" prop="team" label-width="120px">
            <el-select v-model="selectedUser.team" placeholder="请选择所属部门" style="width: 100%;">
                <el-option label="前台" value="前台"></el-option>
                <el-option label="建模团队" value="建模团队"></el-option>
                <el-option label="渲染团队" value="渲染团队"></el-option>
                <el-option label="后期团队" value="后期团队"></el-option>
            </el-select>
        </el-form-item>

        <el-form-item prop="position" label="职位" label-width="120px">
          <el-input type="text" v-model="selectedUser.position"
                    auto-complete="off" placeholder="职位"></el-input>
        </el-form-item>

        <el-form-item prop="phone" label-width="120px" label="电话号码1">
          <el-input type="text" v-model="selectedUser.phone"
                    auto-complete="off" placeholder="电话号码1"></el-input>
        </el-form-item>

        <el-form-item prop="telphone" label-width="120px" label="电话号码2">
          <el-input type="text" v-model="selectedUser.telphone"
                    auto-complete="off" placeholder="电话号码2"></el-input>
        </el-form-item>

        <el-form-item prop="email" label-width="120px" label="Email">
          <el-input type="text" v-model="selectedUser.email"
                    auto-complete="off" placeholder="email"></el-input>
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
        <el-breadcrumb-item>员工管理</el-breadcrumb-item>
        <el-breadcrumb-item>员工信息</el-breadcrumb-item>
      </el-breadcrumb>
    </el-row>

    <el-card style="margin: 18px 2%;width: 95%; height: 95%">
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
          prop="employeeNo"
          label="员工编号"
          sortable
          width="100">
        </el-table-column>
        <el-table-column
          prop="employeeName"
          label="员工姓名"
          fit>
        </el-table-column>
        <el-table-column
          prop="team"
          label="所属部门"
          :filters="[{ text: '前台', value: '前台' }, { text: '建模团队', value: '建模团队' },{ text: '渲染团队', value: '渲染团队' },{ text: '后期团队', value: '后期团队' }]"
          :filter-method="filterTeam"
          fit>
        </el-table-column>
        <el-table-column
          prop="gender"
          label="性别"
          :filters="[{ text: '男', value: '男' }, { text: '女', value: '女' }]"
          :filter-method="filterGender"
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
            Users: [],
            dialogFormVisible: false,
            selectedUser: [],
            selectedRolesIds: []
          }
      },
      // mounted () {
      //   this.listUsers()
      // },
      created (){
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
          this.$axios.get('/employee/getList').then(resp => {
            if (resp && resp.data.code == 200) {
              console.log(resp.data.result)
              _this.users = resp.data.result
              _this.Users = _this.users
            }
          })
        },
        listRoles () {
          var _this = this
          this.$axios.get('').then(resp => {
            if (resp && resp.data.code === 200) {
              _this.roles = resp.data.result
            }
          })
        },
        commitStatusChange (value, user) {
          if (user.username !== 'admin') {
            this.$axios.put('', {
              enabled: value,
              username: user.username
            }).then(resp => {
              if (resp && resp.data.code === 200) {
                if (value) {
                  this.$message('用户 [' + user.username + '] 已启用')
                } else {
                  this.$message('用户 [' + user.username + '] 已禁用')
                }
              }
            })
          } else {
            user.enabled = true
            this.$alert('不能禁用管理员账户')
          }
        },
        onSubmit (user) {
          // // 根据视图绑定的角色 id 向后端传送角色信息
          // let roles = []
          // for (let i = 0; i < _this.selectedRolesIds.length; i++) {
          //   for (let j = 0; j < _this.roles.length; j++) {
          //     if (_this.selectedRolesIds[i] === _this.roles[j].id) {
          //       roles.push(_this.roles[j])
          //     }
          //   }
          // }
            this.$axios.post('/employee/add', {
              employeeNo: user.employeeNo,
              employeeName: user.employeeName,
              gender: user.gender,
              birthday: user.birthday,
              entry: user.entry,
              team: user.team,
              phone: user.phone,
              telphone: user.telphone,
              email: user.email,
              id: user.id,
              political: user.political,
              position: user.position,
              pwd: '123'
            }).then(resp => {
              if (resp && resp.data.code === 200) {
                this.$alert("修改成功")
              }else{
                this.$alert("修改失败")
              }
            })
            this.dialogFormVisible = false
            this.listUsers();
        },
        editUser (user) {
          this.dialogFormVisible = true
          this.selectedUser = user
          // let roleIds = []
          // for (let i = 0; i < user.roles.length; i++) {
          //   roleIds.push(user.roles[i].id)
          // }
          // this.selectedRolesIds = roleIds
        },
        delUser (user) {
          this.selectedUser = user
          let roleIds = this.selectedUser.employeeNo
          this.$axios.post('/employee/delete', {
            employeeNo: roleIds,
          }).then(resp => {
            if (resp && resp.data.code === 200) {
              this.$alert(resp.data.message)
              this.listUsers()
            } else {
              this.$alert(resp.data.message)
            }
          })
          this.listUsers();
        },
        resetPassword (username) {
          this.$axios.put('', {
            username: username
          }).then(resp => {
            if (resp && resp.data.code === 200) {
              this.$alert('密码已重置为 123')
          }
          })
        },
        filterTeam (value, row, column) {
          const property = column['property'];
          return row[property] === value;
        },
        filterGender (value, row, column) {
          const property = column['property'];
          return row[property] === value;
        }
      }
    }
</script>

<style scoped>

</style>
