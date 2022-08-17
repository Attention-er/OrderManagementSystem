<template>
  <div>
    <span name="message">订单信息</span>
    <el-collapse accordion>
      <el-collapse-item name="1">
        <template style="width: 100%" #title>
          <div class="pay-div">
            <div>
              {{ props.order.business.name }}
            </div>
            <div style="color: red">￥{{ props.order.price }}</div>
          </div>
        </template>
        <ul>
          <li v-for="foodNumItem in props.order.foodNum">
            {{ foodNumItem.food.name }}*
            {{ foodNumItem.num }}
          </li>
          <li>
            配送费:{{ props.order.business.deliveryPrice }}
          </li>
        </ul>
      </el-collapse-item>
    </el-collapse>
    <el-radio-group class="my-group" v-model="choose">
      <el-radio class="my-radio" :label="1">
        <el-image :src="'/img?filename='+'img/alipay.png'"/>
      </el-radio>
      <el-radio class="my-radio" :label="2">
        <el-image :src="'/img?filename='+'img/wechat.png'"/>
      </el-radio>
    </el-radio-group>
    <div class="button">
      <el-button @click="payOrder" class="my-button" type="success">确认支付</el-button>
    </div>
  </div>
</template>

<script lang="ts" setup>
import {ref} from "vue";
import axios from "axios";
import {useRouter} from "vue-router";
import {ElMessage} from "element-plus";

const router = useRouter();

const props = defineProps<{
  order: any
}>()
const choose = ref(1)
// console.log(order.value)
const payOrder = () => {
  axios.post('pay/payOrder', props.order
  ).then((res) => {

    if (("支付成功".localeCompare(res.data)) ==0) {
      successMessage()
      router.push('/orderView')
    }else {
      const divForm = document.getElementsByTagName("test");
      if (divForm.length) {
        document.body.removeChild(divForm[0])
      }
      const div = document.createElement('test');
      div.innerHTML = res.data;
      document.body.appendChild(div);
      document.forms[0].setAttribute("target", "_blank");
      document.forms[0].submit();
    }
  })
}
const check = () => {
  if (props.order.payState == 1) {
    alert("订单已支付，请勿重新支付")
    router.push('/orderView')
  }
}
const successMessage = ()=>{
  ElMessage({
    message: '支付成功.',
    type: 'success',
  })
}
check()
</script>

<style lang="less" scoped>
.my-radio {
  width: 90%;
  display: flex;
  flex-direction: row-reverse;
  justify-content: space-between;
  padding: 0;
  margin: 0;
}

.my-group {
  display: flex;
  flex-direction: column;
  //width: 100%;
}

.pay-div {
  display: flex;
  //flex-direction: row;
  justify-content: space-between;
  width: 80%;
}

.button {
  margin-top: 5%;
  width: 100%;
  flex-direction: column;
  display: flex;
  align-items: center;
  justify-items: center;
}

.my-button {
  min-width: 90%;
  font-size: 20px;
  min-height: 40px;
  padding: 15px;
}
</style>