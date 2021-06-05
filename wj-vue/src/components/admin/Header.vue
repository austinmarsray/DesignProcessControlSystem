<template>
<div class="admin-header">
  <el-card style="height: 80px">
    <i class="el-icon-switch-button" v-on:click="logout" style="font-size: 40px"></i>
  </el-card>
</div>
</template>

<script>
  import {createRouter} from '../../router'

  export default {
    name: 'Header',
    methods: {
      logout () {
        // var _this = this
        // this.$axios.get('/logout').then(resp => {
        //   if (resp && resp.data.code === 200) {
        //     _this.$store.commit('logout')
        //     _this.$router.replace('/index')
        //     // 清空路由，防止路由重复加载
        //     const newRouter = createRouter()
        //     _this.$router.matcher = newRouter.matcher
        //   }
        // }).catch(failResponse => {})
        this.$store.commit('logout')
        this.$router.replace('/index')
        // 清空路由，防止路由重复加载
        const newRouter = createRouter()
        this.$router.matcher = newRouter.matcher
      }
    }
  }
</script>

<style scoped>
  .admin-header {
    position: fixed !important;
    display: inline-block;
    background-color: #ffffff;
    left: 250px;
    height: 80px;
    width: 1300px !important;
  }
  .el-icon-switch-button {
    position: absolute !important;
    right: 100px;
    cursor: pointer;
    outline:0;
  }
</style>
