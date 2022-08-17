<template>
  <ul class="business-type">
    <li @click="go_to_list(businessType.id)" v-for="businessType in props.businessTypes">
      <el-image :src="'/img?filename='+businessType.img"/>
      <p>{{ businessType.name }}</p>
    </li>
  </ul>
</template>

<script setup lang="ts">

import {defineProps, ref} from "vue";
import axios from "axios";
import {useRouter} from "vue-router";

const props = defineProps<{
  businessTypes: any
}>()
// const businessTypes = ref()
// const getBusiness = () => {
//   axios.get("index").then((res) => {
//     businessTypes.value = res.data.bts;
//   })
// }
// getBusiness()
const router = useRouter();
const go_to_list = (typeId: number) => {
  console.log(typeId)
  router.push({
    path: '/about',
    query: {
      typeId: typeId
    }
  })
}
</script>

<style lang="less" scoped>

@import "./less/businessType.less";

</style>