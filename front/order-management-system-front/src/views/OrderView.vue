<template>
  <div>
    <TempHead/>
    <LittleOrderList/>
    <Foot/>
  </div>
</template>

<script lang="ts" setup>

import TempHead from "@/components/TempHead.vue";
import Foot from "@/components/Foot.vue";
import LittleOrderList from "@/components/LittleOrderList.vue";
import {useRouter} from "vue-router";
import {useStore} from "vuex";
const router = useRouter();
const store = useStore();
if (store.state.userId === -1){
  alert('您还未登录，请登录后查看')
  router.push('/')
}
</script>

<style lang="less" scoped>

</style>