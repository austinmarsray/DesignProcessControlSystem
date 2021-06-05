<template>
  <div style="text-align: center;width: 60%;line-height: height">
      <el-form :model="loginForm" :rules="rules" label-position="left"
               label-width="90px">
        <el-form-item prop="employeeNo" label="员工编号">
        <el-input type="text" v-model="loginForm.employeeNo"
                    auto-complete="off" placeholder="员工编号"></el-input>
        </el-form-item>

        <el-form-item prop="employeeName" label="员工姓名">
          <el-input type="text" v-model="loginForm.employeeName"
                    auto-complete="off" placeholder="员工姓名"></el-input>
        </el-form-item>

        <el-form-item prop="ID" label="身份证号">
          <el-input type="text" v-model="loginForm.ID"
                    auto-complete="off" placeholder="身份证号"></el-input>
        </el-form-item>

        <el-form-item label="性别" prop="gender">
            <el-select v-model="loginForm.gender" placeholder="请选择性别" style="width: 100%;">
                <el-option label="男" value="男"></el-option>
                <el-option label="女" value="女"></el-option>
            </el-select>
        </el-form-item>

        <el-form-item label="政治面貌" prop="political">
            <el-select v-model="loginForm.political" placeholder="请选择政治面貌" style="width: 100%;">
                <el-option label="群众" value="群众"></el-option>
                <el-option label="共青团员" value="共青团员"></el-option>
                <el-option label="共产党员" value="共产党员"></el-option>
            </el-select>
        </el-form-item>

        <el-form-item prop="birthday" label="出生日期">
            <el-date-picker type="date" placeholder="选择日期" v-model="loginForm.birthday" style="width: 100%;"></el-date-picker>
        </el-form-item>

        <el-form-item prop="entry" label="入职日期">
          <el-date-picker type="date" placeholder="选择日期" v-model="loginForm.entry" style="width: 100%;"></el-date-picker>
        </el-form-item>

        <el-form-item label="所属部门" prop="team">
            <el-select v-model="loginForm.team" placeholder="请选择所属部门" style="width: 100%;">
                <el-option label="前台" value="前台"></el-option>
                <el-option label="建模团队" value="建模团队"></el-option>
                <el-option label="渲染团队" value="渲染团队"></el-option>
                <el-option label="后期团队" value="后期团队"></el-option>
            </el-select>
        </el-form-item>

        <el-form-item prop="position" label="职位">
          <el-input type="text" v-model="loginForm.position"
                    auto-complete="off" placeholder="职位"></el-input>
        </el-form-item>

        <el-form-item prop="phone" label="电话号码1">
          <el-input type="text" v-model="loginForm.phone"
                    auto-complete="off" placeholder="电话号码1"></el-input>
        </el-form-item>

        <el-form-item prop="telphone" label="电话号码2">
          <el-input type="text" v-model="loginForm.telphone"
                    auto-complete="off" placeholder="电话号码2"></el-input>
        </el-form-item>

        <el-form-item prop="email" label="Email">
          <el-input type="text" v-model="loginForm.email"
                    auto-complete="off" placeholder="email"></el-input>
        </el-form-item>
        <el-form-item style="width: 100%">
          <el-button type="primary" style="width: 40%;background: #505458;border: none" v-on:click="register">添加</el-button>
        </el-form-item>
      </el-form>
  </div>
</template>

<script>
    export default {
        name: 'employeeInput',
      data () {
        return {
          dialogFormVisible: false,
          rules: {
            employeeName: [{required: true, message: '姓名不能为空', trigger: 'blur'}],
            birthday: [{required: true, message: '生日不能为空', trigger: 'blur'}],
            entry: [{required: true, message: '入职日期不能为空', trigger: 'blur'}],
            ID: [{required: true, message: '身份证号不能为空', trigger: 'blur'}],
            gender: [{required: true, message: '性别信息不能为空', trigger: 'blur'}],
            phone: [{required: true, message: '联系电话不能为空', trigger: 'blur'}]
          },
          loginForm: {
            employeeNo: 'E00031',
            employeeName: '刘明',
            gender: '男',
            birthday: '1999-12-30',
            entry: '2018-1-1',
            team: '建模团队',
            phone: '12163542465',
            telphone: '14165465',
            email: 'liuming@foxmail.com',
            ID: '5320151211315121351',
            political: '群众',
            position: 1
          }
        }
      },
      methods: {
        clear () {
          this.loginForm = {
            employeeNo: '',
            employeeName: '',
            gender: '',
            birthday: '',
            entry: '',
            team: '',
            phone: '',
            telphone: '',
            email: '',
            ID: '',
            political: '',
            position: ''
          }
        },
        register () {
          this.$axios
            .post('/employee/add', { //添加路径
                employeeNo: this.loginForm.employeeNo,
                employeeName: this.loginForm.employeeName,
                gender: this.loginForm.gender,
                birthday: this.loginForm.birthday,
                entry: this.loginForm.entry,
                team: this.loginForm.team,
                phone: this.loginForm.phone,
                telphone: this.loginForm.telphone,
                email: this.loginForm.email,
                id: this.loginForm.ID,
                political: this.loginForm.political,
                position: this.loginForm.position,
                pwd: '123'
            })
            .then(resp => {
              if (resp.data.code === 200) {
                this.$alert('添加成功', '提示', {
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
        }
      }
    }
</script>

<style scoped>
  .add-button {
    margin: 18px 0 0 10px;
  }
</style>
