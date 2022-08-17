<template>
  <el-affix :offset="0">
    <div class="temp-title">
        <h3>{{props.title}}</h3>
    </div>
  </el-affix>
</template>

<script lang="ts" setup>

const props = defineProps<{
  title?: string
}>()
// interface Props {
//   title?:string
// }
// const props = withDefaults(defineProps<Props>(),{
//   title: 'title'
// })
//
// defineProps({
//   title:String
// })

</script>

<style lang="less" scoped>
@import "./less/TempHead.less";
</style>