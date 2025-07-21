import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import AuthView from '@/views/AuthView.vue'
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
      path: "/signin",
      name: "signin",
      component: AuthView
    }
  ],
});

router.beforeEach(authGuard)

export default router
