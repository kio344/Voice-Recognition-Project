import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import ElementPlus from "element-plus";
import "element-plus/dist/index.css";

import axios from "axios";

// Axios 인스턴스 생성
const axiosInstance = function () {
  return axios.create({
    // baseURL: "http://example.com/api",
    headers: {
      "Content-Type": "application/json",
      Authorization: "Bearer " + store.state.loginToken, // 로컬 스토리지에서 access_token을 가져와 포함
    },
  });
};

// Vue 전역에서 사용할 수 있도록 axiosInstance를 설정
const app = createApp(App);
app.config.globalProperties.$axios = axiosInstance;

app.use(router).use(ElementPlus).use(store).use(router).mount("#app");
