<template>
  <TempHead :title="title"/>
  <PayComponent v-if="order!=null" :order="order"/>
  <Foot/>
</template>

<script lang="ts" setup>

import TempHead from "@/components/TempHead.vue";
import {onBeforeMount, ref} from "vue";
import Foot from "@/components/Foot.vue";
import PayComponent from "@/components/PayComponent.vue";
import {useRoute} from "vue-router";
import axios from "axios";


const route = useRoute();
const title = ref("在线支付");
const orderId = Number(route.query.orderId);
console.log(orderId)
const order = ref();
axios.get('order/getOrder', {
  params: {
    orderId: orderId
  }
}).then((res) => {
  order.value = res.data
})

</script>

<style lang="less" scoped>

</style>