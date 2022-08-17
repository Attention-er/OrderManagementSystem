<template>
  <div class="payOrders">
    <p>未支付订单信息</p>
    <el-collapse v-model="activeNames">
      <el-collapse-item v-for="order in unPayOrders">
        <template #title>
          <div class="always-show">
            <span>{{ order.id }}:{{ order.business.name }}</span>
            <span>￥{{ order.price }} <el-button v-if="order.payState==0" @click.stop="payOrder(order.id)"
                                                type="warning">支付</el-button></span>
          </div>
        </template>
        <div class="do-not-show">
          <span v-for="food in order.foodNum">{{ food.food.name }} * {{ food.num }}  </span>
          <span>配送费:{{ order.business.deliveryPrice }}</span>
        </div>
      </el-collapse-item>
    </el-collapse>
    <p>已支付订单信息</p>
    <el-collapse v-model="activeNames">
      <el-collapse-item v-for="order in payOrders">
        <template #title>
          <div class="always-show">
            <span>{{ order.id }}:{{ order.business.name }}</span>
            <span>￥{{ order.price }} <el-button v-if="order.payState==0" @click.stop="payOrder(order.id)"
                                                type="warning">支付</el-button></span>
          </div>
        </template>
        <div class="do-not-show">
          <span v-for="food in order.foodNum">{{ food.food.name }} * {{ food.num }}  </span>
          <span>配送费:{{ order.business.deliveryPrice }}</span>
        </div>
      </el-collapse-item>
    </el-collapse>
  </div>
</template>

<script lang="ts" setup>
import {computed, ref} from "vue";
import axios from "axios";
import {useStore} from "vuex";
import {useRouter} from "vue-router";

const store = useStore()
const orders = ref([]);
const activeNames = ref();
axios.get('order/showOrderList', {
  params: {
    userId: store.state.userId
  }
}).then((res) => {
  orders.value = res.data
})
const payOrders = computed(() => {
  console.log(orders.value)
  let payOrders: any[] = [];
  orders.value.forEach((item: any) => {
    if (item.payState == 1)
      payOrders.push(item)
  })
  return payOrders
})
const unPayOrders = computed(() => {
  let unPayOrders: any[] = [];
  orders.value.forEach((item: any) => {
    if (item.payState == 0)
      unPayOrders.push(item)
  })
  return unPayOrders
})
const router = useRouter();
const payOrder = (orderId: any) => {
  router.push({
    path:'/payView',
    query:{
      orderId:orderId
    }
  })
}
const defaultProps = {
  children: 'food',
  label: 'name'
}
</script>

<style scoped>
.do-not-show {
  display: flex;
  flex-direction: column;
}

.always-show {
  width: 90%;
  display: flex;
  justify-content: space-between;
}
</style>