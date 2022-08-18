<template>
  <ul class="business">
    <li v-for="food in foodList">

      <el-badge :value="food.num" :hidden="food.num==null||food.num===0" :max="10">
        <div class="business-left">
          <el-image :src="'/api/file/getFile?filename='+food.img" :alt="food.name"/>
        </div>
      </el-badge>
      <div class="business-right">
        <div class="businessHead">
          <h3>{{ food.name }}</h3>
        </div>
        <div class="businessStar">
          <div class="businessStarLeft">
            <p>{{ food.explain }}</p>
          </div>
        </div>
        <div class='businessExplain'>
          <span>￥{{ food.price }}</span>
        </div>
      </div>
      <div>
      </div>
      <div class="count-and-sub">
        <el-icon v-if="food.num !== 0" :size="20">
          <Remove @click="sub(food)"/>
        </el-icon>
        <span v-if="food.num !== 0">{{ food.num }}</span>
        <el-icon :size="20">
          <CirclePlus @click="count(food)"/>
        </el-icon>
      </div>
    </li>
  </ul>
</template>

<script lang="ts" setup>
import {onBeforeMount, ref, toRef, toRefs} from "vue";
import axios from "axios";
import {useRoute, useRouter} from "vue-router";
import {useStore} from "vuex";
import {CirclePlus, Remove} from "@element-plus/icons-vue";

const route = useRoute();
const router = useRouter();
const props = defineProps<{
  businessId: any
}>()
const emit = defineEmits(['update'])
const foodList = ref()
const businessId = props.businessId;
const store = useStore();
const food_nums = store.state.order_food_nums
let temp;
const get_data = (businessId: Number) => {
  axios.get('foodList', {
    params: {
      businessId: businessId
    }
  }).then((res) => {
        temp = res.data.foodList;
        temp.forEach((item: any, index: any) => {
          console.log(item.id)
          console.log(store.getters.getItemNum(1))
          item.num = store.getters.getItemNum(item.id)
        })
        foodList.value = temp;
      }
  )
  // foodList.value.forEach((item: any, index: any)=>{
  //   item.num = store.getters.getItemNum(item.id)
  // })
}
onBeforeMount(() => {
  get_data(businessId)
})
const saveData = () => {
  const user = store.state.user;
  const order_food_nums = store.state.order_food_nums;
  sessionStorage.setItem('user', JSON.stringify(user));
  sessionStorage.setItem('order_food_nums', JSON.stringify(order_food_nums));
}
const count = (food: any) => {
  if (store.state.userId === -1) {
    alert('您还未登录，请先登录！')
    router.push('/userView')
  } else {
    store.commit('count', food)
    saveData()
    emit('update')
  }
}
const sub = (food: any) => {
  if (store.state.userId === -1) {
    alert('您还未登录，请先登录！')
    router.push('/userView')
  } else {
    store.commit('subtraction', food)
    saveData()
    emit('update')
  }
}
</script>

<style lang="less" scoped>
@import "./less/Business.less";
</style>