import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    // username: window.localStorage.getItem('username') == null ? '' : JSON.parse(window.localStorage.getItem('username' || '[]')),
    // position: window.localStorage.getItem('username') == null ? '' : JSON.parse(window.localStorage.getItem('username' || '[]')),
    username: window.localStorage.getItem('username') == null ? '' : window.localStorage.getItem('username'),
    position: window.localStorage.getItem('username') == null ? '' : window.localStorage.getItem('username'),
    adminMenus: []
  },
  mutations: {
    initAdminMenu (state, menus) {
      state.adminMenus = menus
    },
    login (state, data) {
      state.username = data.employeeNo
      // console.log(state.username)
      state.position = data.position
      // console.log(state.position)
      window.localStorage.setItem('username', state.username)
      window.localStorage.setItem('position', state.position)
    },
    logout (state) {
      // 注意不能用 null 清除，否则将无法判断 user 里具体的内容
      state.username = ''
      window.localStorage.removeItem('username')
      window.localStorage.removeItem('position')
      state.adminMenus = []
    }
  },
  actions: {
  }
})
