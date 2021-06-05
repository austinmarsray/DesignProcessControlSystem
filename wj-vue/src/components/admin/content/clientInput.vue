<template>
  <div style="text-align: center;width: 60%;line-height: height">
      <el-form :model="loginForm" :rules="rules" label-position="left"
               label-width="80px">
        <el-form-item prop="clientNo" label="客户编号">
        <el-input type="text" v-model="loginForm.clientNo"
                    auto-complete="off" placeholder="客户编号"></el-input>
        </el-form-item>


        <el-form-item prop="clientName" label="客户名">
          <el-input type="text" v-model="loginForm.clientName"
                    auto-complete="off" placeholder="客户名"></el-input>
        </el-form-item>

        <el-form-item prop="phone" label="电话号码1">
          <el-input type="text" v-model="loginForm.phone"
                    auto-complete="off" placeholder="电话号码1"></el-input>
        </el-form-item>

        <el-form-item prop="telphone" label="电话号码2">
          <el-input type="text" v-model="loginForm.telphone"
                    auto-complete="off" placeholder="电话号码2"></el-input>
        </el-form-item>

        <el-form-item prop="QQ" label="QQ">
          <el-input type="text" v-model="loginForm.QQ"
                    auto-complete="off" placeholder="QQ"></el-input>
        </el-form-item>

        <el-form-item prop="email" label="Email">
          <el-input type="text" v-model="loginForm.email"
                    auto-complete="off" placeholder="email"></el-input>
        </el-form-item>

        <el-form-item prop="Funit" label="一级单位">
          <el-input type="text" v-model="loginForm.Funit"
                    auto-complete="off" placeholder="一级单位"></el-input>
        </el-form-item>

        <el-form-item prop="Sunit" label="二级单位">
          <el-input type="text" v-model="loginForm.Sunit"
                    auto-complete="off" placeholder="二级单位"></el-input>
        </el-form-item>
        <el-form-item prop="Tunit" label="三级单位">
          <el-input type="text" v-model="loginForm.Tunit"
                    auto-complete="off" placeholder="三级单位"></el-input>
        </el-form-item>
        <el-form-item style="width: 100%">
          <el-button type="primary" style="width: 40%;background: #505458;border: none" v-on:click="register">添加</el-button>
        </el-form-item>
      </el-form>
  </div>
</template>

<script>
    export default {
        name: 'BulkRegistration',
      data () {
        return {
          dialogFormVisible: false,
          rules: {
            clientName: [{required: true, message: '客户名不能为空', trigger: 'blur'}]
          },
          loginForm: {
            clientNo: 'C00031',
            clientName: '王格比',
            phone: '12978564651',
            telphone: '2348975873',
            QQ: '1278165781',
            email: 'green@qq.com',
            Funit: '网图科技有限责任公司',
            Sunit: '',
            Tunit: ''
          }
        }
      },
      methods: {
        clear () {
          this.loginForm = {
            clientNo: '',
            clientName: '',
            phone: '',
            telphone: '',
            QQ: '',
            email: '',
            Funit: '',
            Sunit: '',
            Tunit: ''
          }
        },
        register () {
          this.$axios
            .post('/client/add', { //添加路径
                clientNo: this.loginForm.clientNo,
                clientName: this.loginForm.clientName,
                phone: this.loginForm.phone,
                telphone: this.loginForm.telphone,
                qq: this.loginForm.QQ,
                email: this.loginForm.email,
                funit: this.loginForm.Funit,
                sunit: this.loginForm.Sunit,
                tunit: this.loginForm.Tunit
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
