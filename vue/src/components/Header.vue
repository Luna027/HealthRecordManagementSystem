<script>
export default {
  name: "Header",
  props: {
    collapseBtnClass:String,
    collapse:Function
  }
}
</script>

<template>
  <div style = "font-size: 12px;line-height:60px; display:flex">
    <div style="flex: 1;font-size: 20px">
      <span :class="collapseBtnClass" style="cursor:pointer" @click="collapse"></span>
    </div>
    <el-dropdown style="width:70px;cursor:pointer">
      <span>aa</span><i class="el-icon-arrow-down" style="margin-left: 5px"></i>
      <el-dropdown-menu slot="dropdown">
        <el-dropdown-item>个人信息</el-dropdown-item>
        <el-dropdown-item>
          <router-link to="/login">退出</router-link>
        </el-dropdown-item>
      </el-dropdown-menu>
    </el-dropdown>
  </div>
</template>

<style scoped>

</style>