import Vue from 'vue'
import App from './App'
import router from './router'
import mavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'
import 'echarts/theme/macarons.js'
import store from './store'

import {
  Pagination,
  Dialog,
  Menu,
  Submenu,
  MenuItem,
  MenuItemGroup,
  Input,
  Checkbox,
  CheckboxButton,
  CheckboxGroup,
  Switch,
  Select,
  Option,
  Button,
  ButtonGroup,
  Table,
  TableColumn,
  Tooltip,
  Breadcrumb,
  BreadcrumbItem,
  Form,
  FormItem,
  Tabs,
  TabPane,
  Tag,
  Tree,
  Alert,
  Icon,
  Row,
  Col,
  Upload,
  Progress,
  Spinner,
  Badge,
  Card,
  Rate,
  Steps,
  Step,
  Carousel,
  CarouselItem,
  Container,
  Header,
  Aside,
  Main,
  Footer,
  Timeline,
  TimelineItem,
  Link,
  Divider,
  Image,
  Loading,
  MessageBox,
  Message,
  Notification,
  DatePicker
} from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

Vue.use(Pagination)
Vue.use(Dialog)
Vue.use(Menu)
Vue.use(Submenu)
Vue.use(MenuItem)
Vue.use(MenuItemGroup)
Vue.use(Input)
Vue.use(Checkbox)
Vue.use(CheckboxButton)
Vue.use(CheckboxGroup)
Vue.use(Switch)
Vue.use(Select)
Vue.use(Option)
Vue.use(Button)
Vue.use(ButtonGroup)
Vue.use(Table)
Vue.use(TableColumn)
Vue.use(Tooltip)
Vue.use(Breadcrumb)
Vue.use(BreadcrumbItem)
Vue.use(Form)
Vue.use(FormItem)
Vue.use(Tabs)
Vue.use(TabPane)
Vue.use(Tag)
Vue.use(Tree)
Vue.use(Alert)
Vue.use(Icon)
Vue.use(Row)
Vue.use(Col)
Vue.use(Upload)
Vue.use(Progress)
Vue.use(Spinner)
Vue.use(Badge)
Vue.use(Card)
Vue.use(Rate)
Vue.use(Steps)
Vue.use(Step)
Vue.use(Carousel)
Vue.use(CarouselItem)
Vue.use(Container)
Vue.use(Header)
Vue.use(Aside)
Vue.use(Main)
Vue.use(Footer)
Vue.use(Timeline)
Vue.use(TimelineItem)
Vue.use(Link)
Vue.use(Divider)
Vue.use(Image)
Vue.use(DatePicker)

Vue.use(Loading.directive)

Vue.prototype.$loading = Loading.service
Vue.prototype.$msgbox = MessageBox
Vue.prototype.$alert = MessageBox.alert
Vue.prototype.$confirm = MessageBox.confirm
Vue.prototype.$prompt = MessageBox.prompt
Vue.prototype.$notify = Notification
Vue.prototype.$message = Message

var axios = require('axios')
axios.defaults.baseURL = 'http://localhost:8443/api'
// ???????????????????????????
axios.defaults.withCredentials = true

Vue.prototype.$axios = axios
Vue.config.productionTip = false
Vue.use(mavonEditor)

router.beforeEach((to, from, next) => {
    if (store.state.username && to.path.startsWith('/admin')) {
      initAdminMenu(router, store)
    }
    if (store.state.username && to.path.startsWith('/login')) {
      next({
        name: 'Dashboard'
      })
    }

    console.log("????????????")
    next()
    // // ????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
    // if (to.meta.requireAuth) {
    //   console.log(store.state.username);
    //   if (store.state.username) {
    //     console.log("????????????")
    //     next()
    //     // axios.get('/authentication').then(resp => {
    //     //   if (resp) {
    //     //     next()
    //     //   }
    //     // })
    //   } else {
    //     next({
    //       path: 'login',
    //       query: {redirect: to.fullPath}
    //     })
    //   }
    // } 
    // console.log("judge");
    // next() 
  }
)

// http response ?????????
// axios.interceptors.response.use(
//   response => {
//     return response
//   },
//   error => {
//     if (error) {
//       console.log("here")
//       store.commit('logout')
//       router.replace('/login')
//     }
//     // ?????????????????????????????????
//     return Promise.reject(error)
//   })

const initAdminMenu = (router, store) => {
  // ????????????????????????????????????
  if (store.state.adminMenus.length > 0) {
    return
  }
  // axios.get('/menu').then(resp => {
  //   if (resp && resp.status === 200) {
  //     var fmtRoutes = formatRoutes(resp.data.result)
  //     router.addRoutes(fmtRoutes)
  //     store.commit('initAdminMenu', fmtRoutes)
  //   }
  // })
  let menus = []
  if(store.state.position == 0){
    menus = [{"id":1,"path":"/admin","name":null,"nameZh":"??????????????????","iconCls":"el-icon-user","component":"AdminIndex","parentId":0,"children":
              [
                {"id":2,"path":"/admin/content/employeeInput","name":"employeeInput","nameZh":"??????????????????","iconCls":"el-icon-user","component":"content/employeeInput","parentId":3,"children":[]},
                {"id":3,"path":"/admin/content/employeeManage","name":"employeeManage","nameZh":"??????????????????","iconCls":"el-icon-user","component":"content/employeeManage","parentId":3,"children":[]}
              ]},
              {"id":4,"path":"/admin","name":null,"nameZh":"??????????????????","iconCls":"el-icon-user","component":"AdminIndex","parentId":0,"children":
              [
                {"id":5,"path":"/admin/content/clientInput","name":"clientInput","nameZh":"??????????????????","iconCls":"el-icon-user","component":"content/clientInput","parentId":3,"children":[]},
                {"id":6,"path":"/admin/content/clientManage","name":"clientManage","nameZh":"??????????????????","iconCls":"el-icon-user","component":"content/clientManage","parentId":3,"children":[]}
              ]},
            ]
  }
  if(store.state.position == 1){
    menus = [{"id":1,"path":"/admin","name":null,"nameZh":"??????","iconCls":"el-icon-user","component":"AdminIndex","parentId":0,"children":
              [
                {"id":2,"path":"/admin/content/ProManage","name":"ProManage","nameZh":"????????????","iconCls":"el-icon-user","component":"content/ProManage","parentId":3,"children":[]},
                {"id":3,"path":"/admin/content/ProFileUpdate","name":"ProFileUpdate","nameZh":"??????????????????","iconCls":"el-icon-user","component":"content/ProFileUpdate","parentId":3,"children":[]},
                {"id":7,"path":"/admin/content/ProProgress","name":"ProProgress","nameZh":"????????????","iconCls":"el-icon-user","component":"content/ProProgress","parentId":3,"children":[]},

              ]},
              {"id":4,"path":"/admin","name":null,"nameZh":"??????????????????","iconCls":"el-icon-user","component":"AdminIndex","parentId":0,"children":
              [
                {"id":5,"path":"/admin/content/PersonInfo","name":"PersonInfo","nameZh":"??????????????????","iconCls":"el-icon-user","component":"content/PersonInfo","parentId":3,"children":[]},
                {"id":6,"path":"/admin/content/PersonSalary","name":"PersonSalary","nameZh":"??????????????????","iconCls":"el-icon-user","component":"content/PersonSalary","parentId":3,"children":[]},
                {"id":8,"path":"/admin/content/","name":"PersonJugde","nameZh":"??????????????????","iconCls":"el-icon-user","component":"content/PersonJugde","parentId":3,"children":[]},
              ]},
            ]
  }
  if(store.state.position == 2){
    console.log("??????")
    menus = [{"id":1,"path":"/admin","name":null,"nameZh":"??????","iconCls":"el-icon-user","component":"AdminIndex","parentId":0,"children":
              [
                {"id":9,"path":"/admin/content/ProInput","name":"ProInput","nameZh":"????????????","iconCls":"el-icon-user","component":"content/ProInput","parentId":3,"children":[]},
                {"id":2,"path":"/admin/content/ProManage","name":"ProManage","nameZh":"????????????","iconCls":"el-icon-user","component":"content/ProManage","parentId":3,"children":[]},
                {"id":3,"path":"/admin/content/ProFileUpdate","name":"ProFileUpdate","nameZh":"??????????????????","iconCls":"el-icon-user","component":"content/ProFileUpdate","parentId":3,"children":[]},
                {"id":7,"path":"/admin/content/ProProgress","name":"ProProgress","nameZh":"????????????","iconCls":"el-icon-user","component":"content/ProProgress","parentId":3,"children":[]}
              ]},
              {"id":4,"path":"/admin","name":null,"nameZh":"??????????????????","iconCls":"el-icon-user","component":"AdminIndex","parentId":0,"children":
              [
                {"id":5,"path":"/admin/content/PersonInfo","name":"PersonInfo","nameZh":"??????????????????","iconCls":"el-icon-user","component":"content/PersonInfo","parentId":3,"children":[]},
                {"id":6,"path":"/admin/content/PersonSalary","name":"PersonSalary","nameZh":"??????????????????","iconCls":"el-icon-user","component":"content/PersonSalary","parentId":3,"children":[]},
                {"id":8,"path":"/admin/content/","name":"PersonJugde","nameZh":"??????????????????","iconCls":"el-icon-user","component":"content/PersonJugde","parentId":3,"children":[]}
              ]}
            ]
  }
  if(store.state.position == 3){
    menus = [{"id":1,"path":"/admin","name":null,"nameZh":"????????????","iconCls":"el-icon-user","component":"AdminIndex","parentId":0,"children":
              [
                {"id":2,"path":"/admin/content/ProManage","name":"ProManage","nameZh":"????????????","iconCls":"el-icon-user","component":"content/ProManage","parentId":3,"children":[]},
                {"id":7,"path":"/admin/content/ProProgress","name":"ProProgress","nameZh":"????????????","iconCls":"el-icon-user","component":"content/ProProgress","parentId":3,"children":[]}
              ]},
            {"id":4,"path":"/admin","name":null,"nameZh":"????????????","iconCls":"el-icon-user","component":"AdminIndex","parentId":0,"children":
              [
                {"id":5,"path":"/admin/content/employeeManage","name":"employeeManage","nameZh":"????????????","iconCls":"el-icon-user","component":"content/employeeManage","parentId":3,"children":[]},
                {"id":6,"path":"/admin/content/SalaryManage","name":"SalaryManage","nameZh":"????????????","iconCls":"el-icon-user","component":"content/SalaryManage","parentId":3,"children":[]},
                {"id":8,"path":"/admin/content/JudgeManage","name":"JudgeManage","nameZh":"????????????","iconCls":"el-icon-user","component":"content/JudgeManage","parentId":3,"children":[]}
              ]},
            {"id":1,"path":"/admin","name":null,"nameZh":"????????????","iconCls":"el-icon-user","component":"AdminIndex","parentId":0,"children":
              [
                {"id":6,"path":"/admin/content/clientManage","name":"clientManage","nameZh":"????????????","iconCls":"el-icon-user","component":"content/clientManage","parentId":3,"children":[]}
              ]},
            ]
  }
  var fmtRoutes = formatRoutes(menus)
  router.addRoutes(fmtRoutes)
  store.commit('initAdminMenu', fmtRoutes)
  store.commit('initAdminMenu',menus)
}

const formatRoutes = (routes) => {
  let fmtRoutes = []
  routes.forEach(route => {
    if (route.children) {
      route.children = formatRoutes(route.children)
    }
    console.log(route.component)
    let fmtRoute = {
      path: route.path,
      component: resolve => {
        require(['./components/admin/' + route.component + '.vue'], resolve)
      },
      name: route.name,
      nameZh: route.nameZh,
      iconCls: route.iconCls,
      meta: {
        requireAuth: true
      },
      children: route.children
    }
    console.log(fmtRoute)
    fmtRoutes.push(fmtRoute)
  })
  return fmtRoutes
}

/* eslint-disable no-new */
new Vue({
  el: '#app',
  render: h => h(App),
  router,
  store,
  components: {App},
  template: '<App/>'
})
