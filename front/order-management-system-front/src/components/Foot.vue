<template>
  <div class='foot-div'>
    <ul class='foot'>
      <li @click="router.push('/')">
        <p><font-awesome-icon :icon="['fas','home']"/></p>
        <p>首页</p>
      </li>
      <li>
        <p><font-awesome-icon :icon="['fas','compass']"/></p>
        <p>发现</p>
      </li>
      <li @click="router.push('/orderView')">
        <p><font-awesome-icon :icon="['fas','file-text']"/></p>
        <p>订单</p>
      </li>
      <li @click="router.push('/userView')">
        <p><font-awesome-icon :icon="['fas','user']"/></p>
        <p>我的</p>
      </li>
    </ul>
  </div>
</template>

<script lang="ts" setup>
import {useRoute, useRouter} from "vue-router";

const router = useRouter();
const route = useRoute();

</script>

<style scoped lang="less">
@import "./less/foot.less";
</style>