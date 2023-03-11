import axios from "axios";
const UserStore = {
  namespaced: true,
  state: {},
  mutations: {},
  actions: {
    async login(context, loginData) {
      let isSuccess;

      await axios
        .post(`${context.rootState.serverIp}/user/login`, loginData)
        .then(function (response) {
          localStorage.setItem("loginToken", response.data);
          context.rootState.loginToken = response.data;

          context.rootState.loginUser = JSON.parse(
            atob(response.data.split(".")[1])
          );

          isSuccess = true;
        })
        .catch(function (err) {
          localStorage.setItem("loginToken", "");
          context.rootState.loginToken = "";
          context.rootState.loginUser = null;
          isSuccess = false;

          throw err;
        })
        .finally(function () {
          console.log(localStorage.getItem("loginToken"));
        });

      return isSuccess;
    },
  },
};

export default UserStore;
