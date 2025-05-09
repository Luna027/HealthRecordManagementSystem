import Vue from 'vue'
import VueRouter from 'vue-router' // 不要引用 vue-router/src/...

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Manage',
    component: () => import('../views/Manage.vue'),
    children:[
      {
        path: 'user', name: 'User', component: () => import('../views/User.vue')
      },
      {
        path: 'login', name: 'Login', component: () => import('../views/AboutView.vue')
      }

    ]
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/aa.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
