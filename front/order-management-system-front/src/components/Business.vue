<template>
  <ul class="business">
    <li v-for="business in businesses">
      <div class="business-left">
        <img :src="business.img" :alt="business.name"/>
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
            <el-rate v-model="business.rate" allow-half/>
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
          <span>各种饺子</span>
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
import {ref} from "vue";
import wjjz from '@/components/img/sj01.png'
import xgfdfg from '@/components/img/sj02.png'

const businesses = ref([
  {
    name: '万家饺子(软件园E18号店)',
    img: wjjz,
    rate: 4.9,
    numberOfOrders: 315,
    startPrice: 15.0,
    deliveryPrice: 3.0
  },
  {
    name: '小锅饭豆腐馆（全运店）',
    img: xgfdfg,
    rate: 3.5,
    numberOfOrders: 345,
    startPrice: 15.0,
    deliveryPrice: 3.0
  }
])
</script>

<style lang="less" scoped>
@import "./less/Business.less";
</style>