<template>
  <ul class="business-type">
    <li v-for="businessType in businessTypes">
      <el-image :src="'http://192.168.1.6:8080/system/file/getFile?filename='+businessType.img"/>
      <p>{{ businessType.name }}</p>
    </li>
  </ul>
</template>

<script setup lang="ts">

import {ref} from "vue";
import axios from "axios";
const businessTypes = ref()
const getBusiness = () => {
  axios.get("index").then((res) => {
    businessTypes.value = res.data.bts;
  })
}
getBusiness()

</script>

<style lang="less" scoped>

@import "./less/businessType.less";

</style>