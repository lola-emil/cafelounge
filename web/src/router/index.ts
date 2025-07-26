import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import AuthView from '@/views/AuthView.vue'
import ReportView from "@/views/ReportView.vue";
import authGuard from '@/guards/auth-guard'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView,
      meta: {
        protectedRoute: true
      }
    },
    {
      path: "/reports",
      name: "reports",
      component: ReportView
    },
    {
      path: "/signin",
      name: "signin",
      component: AuthView
    }
  ],
});

router.beforeEach(authGuard)

export default router
