import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    username:'',
    user:{
    }
  },
  mutations: {
    setUsername: function (state, username) {
      state.username = username
    }
  },
  actions: {
    setUsername: function ({ commit }, username) {
      commit('setUsername', username)
    }
  },
  getters: {
    getUser: function (state) {
      return state.username
    }
  }
})
