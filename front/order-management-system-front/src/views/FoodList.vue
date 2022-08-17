<template>
  <TempHead :title="title"/>
  <div class="business-top">
    <el-image :src="'/img?filename='+business.img"/>
    <h3>{{ business.name }}</h3>
    <p>{{ business.startPrice }}起送 | {{ business.deliveryPrice }}配送</p>
    <span>{{ business.explain }}</span>
  </div>
  <LittleFoodList @update="update" :businessId="business.id"/>
  <CarFoot :business-id="business.id"
           :delivery-price="business.deliveryPrice"
           :start-price="business.startPrice"
           :total-num="totalNum"
           :total-price="totalPrice"/>
</template>

<script lang="ts" setup>

import {useRoute} from "vue-router";
import {onBeforeMount, ref, toRefs} from "vue";
import Head from "@/components/Head.vue";
import LittleFoodList from '@/components/LittleFoodList.vue'
import TempHead from "@/components/TempHead.vue";
import CarFoot from "@/components/CarFoot.vue";
import {useStore} from "vuex";

const title = ref("商家信息");
const route = useRoute();
const business = ref({
  id: Number
});
const totalNum = ref()
const totalPrice = ref()
const store = useStore();
onBeforeMount(() => {
  business.value = JSON.parse(route.query.business as string);
  totalNum.value = store.getters.getOrderTotalNum(business.value.id)
  totalPrice.value = store.getters.getOrderTotalPrice(business.value.id)
})
const update = ()=>{
  totalNum.value = store.getters.getOrderTotalNum(business.value.id)
  totalPrice.value = store.getters.getOrderTotalPrice(business.value.id)
}
const to_order = ()=>{
  const form = {

  }
}
</script>

<style lang="less" scoped>
@import "../components/less/FoodList.less";
</style>