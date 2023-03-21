import { createStore } from "vuex";
import ApplicationContext from "./ApplicationContext";
import UserStore from "./UserStore";

import axios from "axios";
export default createStore({
  state: {
    serverIp: "http://localhost:8080",
    loginToken: localStorage.getItem("loginToken"),
    loginUser: null,

    axios() {
      return axios.create({
        method: "post",
        url: "http://localhost:8080",
        headers: {
          "Content-Type": "application/json",
          Authorization: "Bearer " + localStorage.getItem("loginToken"),
        },
      });
    },
  },

  getters: {},
  mutations: {
    SET_LOGIN_TOKEN(state, token) {
      state.loginToken = token;
    },
  },
  actions: {},
  modules: {
    ApplicationContext: ApplicationContext,
    UserStore: UserStore,
  },
});
