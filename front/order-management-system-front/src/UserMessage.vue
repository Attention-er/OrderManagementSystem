<template>
  <div>
    <p>用户名：{{ user.userName }}</p>
    <p>手机号：{{ user.phoneNumber }}</p>
    <el-button type="danger" @click="outLogin">登出</el-button>
  </div>
</template>

<script lang="ts" setup>

import {useRoute, useRouter} from "vue-router";
import {ref} from "vue";
import {useStore} from "vuex";
import {ElMessage} from "element-plus";

const route = useRoute();
const router = useRouter();
const user = ref();
const store = useStore();
const emits = defineEmits(['out'])
user.value = store.state.user
const successMessage = (message: string) => {
  ElMessage({
    message: message,
    type: 'success'
  })
}
const outLogin = ()=>{
  successMessage('登出成功！')
  emits('out')
}
</script>

<style lang="less" scoped>

</style>