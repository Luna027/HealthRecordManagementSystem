<template>
  <div style="height: 100%">
    <el-container style="height: 100%">
      <el-aside :width="sideWidth+'px'" style="background-color: rgb(238, 241, 246);box-shadow: 2px 0 6px rgb(0 21 41/35%)">
        <Aside :isCollapse="isCollapse"/>
      </el-aside>

      <el-container>
        <el-header style="border-bottom: 1px solid #cccccc;">
          <Header :collapseBtnClass="collapseBtnClass" :collapse="collapse"/>
        </el-header>

<!--        <div >-->
<!--          <el-breadcrumb separator="/"  >-->
<!--            <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>-->
<!--            <el-breadcrumb-item>用户管理</el-breadcrumb-item>-->
<!--          </el-breadcrumb>-->
<!--        </div>-->

        <el-main>
<!--          //表示当前页面的子路由会在router-view里展示-->
          <router-view />
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>

import Aside from "@/components/Aside";
import Header from "@/components/Header";
import User from "@/views/User.vue";

// import request from "@/utils/request";
// import {fillParams} from "vue-router/src/util/params";

export default {
  name: 'Home',
  data(){
    return{
      collapseBtnClass:'el-icon-s-fold',
      isCollapse:false,
      sideWidth:200
    }
  },
  // created() {
  //   // 请求分页查询 res.json方法将返回的字符串转换为json
  //   this.load()
  // },
  components:{
    Aside,
    Header
  },

  methods:{
    collapse(){//点击收缩按钮触发
      this.isCollapse=!this.isCollapse
      if(this.isCollapse){
        this.sideWidth = 64
        this.collapseBtnClass = 'el-icon-s-unfold'
      }else{
        this.sideWidth = 200
        this.collapseBtnClass = 'el-icon-s-fold'
      }
    },
  }
}
</script>
