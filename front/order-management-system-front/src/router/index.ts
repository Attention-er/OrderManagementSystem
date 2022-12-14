import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import Home from '../views/Home.vue'

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/BusinessList.vue')
  },
  {
    path:'/foodList',
    name:'FoodList',
    component:()=> import('../views/FoodList.vue')
  },
  {
    path:'/payView',
    name:'PayView',
    component:()=> import('../views/PayView.vue')
  },
  {
    path:'/orderView',
    name:'OrderView',
    component:()=> import('../views/OrderView.vue')
  },
  {
    path:'/userView',
    name:'UserView',
    component:()=> import('../views/UserView.vue')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
