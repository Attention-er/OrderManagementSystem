<template>
  <div class="car-foot">
    <div class="shopping">
      <div class="shopping-left">
        <div class="shopping-car">
          <el-badge :value="props.totalNum">
            <el-icon :size="40">
              <ShoppingCart/>
            </el-icon>
            <el-icon v-if="false">
              <ShoppingCartFull/>
            </el-icon>
          </el-badge>
        </div>
      </div>
      <div class="shopping-center">
        <p>￥{{ props.totalPrice }}</p>
        <span>另需配送费{{ props.deliveryPrice }}元</span>
      </div>
      <!--      <div class="shopping-right"><h2>去结算</h2></div>-->
      <el-button @click="show_order" class="shopping-right" :disabled="!(props.totalPrice>props.startPrice)"
                 :type="props.totalPrice>props.startPrice?'success':'info'">去结算
      </el-button>
    </div>
  </div>
</template>

<script lang="ts" setup>
import {ShoppingCart, ShoppingCartFull} from "@element-plus/icons-vue";
import {useStore} from "vuex";
import {ref} from "vue";
import axios from "axios";
import {useRouter} from "vue-router";

const store = useStore();
const totalPrice = ref();
const router = useRouter();
const props = defineProps<{
  businessId: any,
  startPrice: any,
  deliveryPrice: any,
  totalPrice: any,
  totalNum: any
}>()
const show_order = () => {
  const order = ref({
    businessId: props.businessId,
    userId: store.state.userId,
    address: '黄土高坡',
    price: props.totalPrice + props.deliveryPrice,
    pay: 0,
    foodIdNums: []
  })
  const foodNumList = ref()
  foodNumList.value = store.getters.getOrderByBusiness(props.businessId);

  foodNumList.value.forEach((foodNums: any) => {
    order.value.foodIdNums.push({
      foodId: foodNums.foodId,
      foodNum: foodNums.num
    })
  })

  axios.post('order/saveOrder', {
    businessId: props.businessId,
    userId: store.state.userId,
    address: '黄土高坡',
    price: props.totalPrice + props.deliveryPrice,
    pay: 0,
    foodIdNums:order.value.foodIdNums
  }).then((res) => {
    router.push({
      path:'/payView',
      query:{
        orderId:res.data
      }
    })
  })
}
</script>

<style lang="less" scoped>
@import "./less/CarFoot.less";
</style>