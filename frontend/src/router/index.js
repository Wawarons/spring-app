import { createRouter, createWebHistory } from "vue-router";
import ViewPatient from "../views/ViewPatient.vue";
import AddPatient from "../views/AddPatient.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "patient",
      component: ViewPatient,
    },
    {
      path: "/add",
      name: "add",
      component: () => import("../views/AddPatient.vue"),
    },
    {
      path: "/edit/:id",
      name: "edit",
      component: () => import("../views/UpdatePatient.vue"),
    },
  ],
});

export default router;
