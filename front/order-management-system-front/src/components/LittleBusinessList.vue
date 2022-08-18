<template>
  <ul class="business">
    <li @click="router.push({
    path:'/foodList',
    query:{
      business:JSON.stringify(business)
    }
    })" v-for="business in props.businesses">
      <el-badge :value="store.getters.getOrderTotalNum(business.id)"
                :hidden="store.getters.getOrderTotalNum(business.id)===0" :max="10">
        <div class="business-left">
          <!--        <el-image src="http://localhost:8080/system/image/getImage" />-->
          <el-image :src="'/api/file/getFile?filename='+business.img" :alt="business.name"/>
        </div>
      </el-badge>
      <div class="business-right">
        <div class="businessHead">
          <h3>{{ business.name }}</h3>
        </div>
        <div class="businessStar">
          <div class="businessStarLeft">
            <el-rate disabled v-model="business.rate" allow-half/>
            <p>{{ business.rate }}</p>
          </div>
        </div>
        <div class='businessDeliver'>
          <div class='businessDeliverLeft'>
            <i class="fa fa-jpy"></i>{{ business.startPrice }}起送 | <i
              class="fa fa-jpy"></i>{{ business.deliveryPrice }}配送
          </div>
        </div>
        <div class='businessExplain'>
          <span>{{ business.explain }}</span>
        </div>
      </div>

    </li>
  </ul>
</template>

<script lang="ts" setup>
import {ref, toRef, toRefs} from "vue";
import axios from "axios";
import {useRoute, useRouter} from "vue-router";
import {useStore} from "vuex";

const route = useRoute();
const router = useRouter();
const store = useStore();
const props = defineProps<{
  businesses: any
}>()
// const businesses = ref()
// const getBusiness = () => {
//   axios.get("index").then((res) => {
//     businesses.value = res.data.bss;
//   })
// }
// getBusiness()
</script>

<style lang="less" scoped>
@import "./less/Business.less";
</style>