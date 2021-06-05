<template>
  <div style="text-align: center;width: 60%;line-height: height">
      <el-form :model="loginForm" :rules="rules" label-position="left"
               label-width="150px">
        <el-form-item prop="projectNo" label="项目编号">
        <el-input type="text" v-model="loginForm.projectNo"
                    auto-complete="off" placeholder="项目编号"></el-input>
        </el-form-item>

        <el-form-item prop="clientNo" label="客户编号">
        <el-input type="text" v-model="loginForm.clientNo"
                    auto-complete="off" placeholder="客户编号"></el-input>
        </el-form-item>


        <el-form-item prop="projectName" label="项目名">
          <el-input type="text" v-model="loginForm.projectName"
                    auto-complete="off" placeholder="项目名"></el-input>
        </el-form-item>

        <el-form-item prop="projectInfo" label="项目信息">
          <el-input type="text" v-model="loginForm.projectInfo"
                    auto-complete="off" placeholder="项目信息"></el-input>
        </el-form-item>

        <el-form-item prop="projectLocation" label="项目存储位置">
          <el-input type="text" v-model="loginForm.projectLocation"
                    auto-complete="off" placeholder="项目存储位置"></el-input>
        </el-form-item>

        <el-form-item prop="contractDate" label="合同约定交付时间">
           <el-date-picker type="date" placeholder="选择日期" v-model="loginForm.contractDate" style="width: 100%;"></el-date-picker>
        </el-form-item>

        <el-form-item prop="pCost" label="预算成本">
          <el-input type="text" v-model="loginForm.pCost"
                    auto-complete="off" placeholder="预算成本"></el-input>
        </el-form-item>

        <el-form-item prop="pValue" label="预算收益">
          <el-input type="text" v-model="loginForm.pValue"
                    auto-complete="off" placeholder="预算收益"></el-input>
        </el-form-item>

        <el-form-item prop="setDate" label="创建日期">
           <el-date-picker type="date" placeholder="选择日期" v-model="loginForm.setDate" style="width: 100%;"></el-date-picker>
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
            .post('', { //添加路径
                clientNo: this.loginForm.clientNo,
                clientName: this.loginForm.clientName,
                phone: this.loginForm.phone,
                telphone: this.loginForm.telphone,
                QQ: this.loginForm.QQ,
                email: this.loginForm.email,
                Funit: this.loginForm.Funit,
                Sunit: this.loginForm.Sunit,
                Tunit: this.loginForm.Tunit
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
