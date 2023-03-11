import { createRouter, createWebHashHistory } from "vue-router";
import ComponentTest from "../views/ComponentTest.vue";

const routes = [
  {
    path: "/",
    name: "ComponentTest",
    component: ComponentTest,
  },
];

const router = createRouter({
  history: createWebHashHistory(),
  routes,
});

export default router;
