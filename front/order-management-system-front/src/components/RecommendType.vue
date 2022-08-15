<template>
  <div class='recommend'>
    <div></div>
    <h4>推荐商家</h4>
    <div></div>
  </div>
  <ul class='recommend-type'>
    <p>综合排序<font-awesome-icon :icon="['fas','caret-down']"/></p>
    <p>距离最近</p>
    <p>销量最高</p>
    <p>筛选<font-awesome-icon :icon="['fas','filter']"/></p>
  </ul>
</template>

<script lang="ts" setup>
</script>

<style scoped lang="less">
@import "./less/recommendType.less";
</style>