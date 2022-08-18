<template>
  <ul class="business">
    <li @click="router.push({
    path:'/foodList',
    query:{
      business:JSON.stringify(business)
    }
    })"  v-for="business in props.businesses">
      <div class="business-left">
        <!--        <el-image src="http://localhost:8080/system/image/getImage" />-->
        <el-image :src="'/api/file/getFile?filename='+business.img" :alt="business.name"/>
      </div>
      <div class="business-right">
        <div class="businessHead">
          <h3>{{ business.name }}</h3>
          <p>
            <font-awesome-icon :icon="['fas','mobile']"/>
          </p>
        </div>
        <div class="businessStar">
          <div class="businessStarLeft">
            <el-rate disabled v-model="business.rate" allow-half/>
            <p>{{ business.rate }} 月售{{ business.numberOfOrders }}</p>
          </div>
          <div class='businessStarRight'>
            蜂鸟专送
          </div>
        </div>
        <div class='businessDeliver'>
          <div class='businessDeliverLeft'>
            <i class="fa fa-jpy"></i>{{ business.startPrice }}起送 | <i
              class="fa fa-jpy"></i>{{ business.deliveryPrice }}配送
          </div>
          <div class='businessDeliverRight'>
            3.22km | 30分钟
          </div>
        </div>
        <div class='businessExplain'>
          <span>{{ business.explain }}</span>
        </div>
        <div class='businessNew'>
          <div class='businessNewLeft'>
            <div>新</div>
            <p>饿了么新用户首单立减9元</p>
          </div>
          <div class='businessNewRight'>
            两个活动<i class='fa fa-caret-down'></i>
          </div>
        </div>
        <div class='businessTe'>
          <div>特</div>
          <p>特价商品5元起</p>
        </div>
      </div>
    </li>
  </ul>
</template>

<script lang="ts" setup>
import {ref, toRef, toRefs} from "vue";
import axios from "axios";
import {useRouter} from "vue-router";

const props = defineProps<{
  businesses: any
}>()
const router = useRouter();
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