<template>
  <TempHead title="用户界面"/>
  <LoginComponent v-if="showPage==='login'" @login="loginToLogin" @register="loginToRegister"/>
  <RegisterComponent @login="registerToLogin" @register="registerToRegister" v-if="showPage==='register'"/>
  <UserMessage @out="outLogin" v-if="showPage === 'userView'"/>
  <Foot/>
</template>

<script lang="ts" setup>

import LoginComponent from "@/components/LoginComponent.vue";
import Foot from "@/components/Foot.vue";
import TempHead from "@/components/TempHead.vue";
import RegisterComponent from "@/components/RegisterComponent.vue";
import UserMessage from "@/UserMessage.vue";
import {onBeforeMount, ref} from "vue";
import {useStore} from "vuex";

const store = useStore();
const showPage = ref('userView');
const user = ref();
// 从登录页面跳转到注册
const loginToRegister = () => {
  showPage.value = 'register'
}
// 更新user
const update = () => {
  if (store.state.userId === -1)
    showPage.value = 'login'
  else
    showPage.value = 'userView'
}
// 于注册页面跳转登录页面
const registerToLogin = () => {
  showPage.value = 'login'
}
// 于登录页面登录后
const loginToLogin = () => {
  update()
  showPage.value = 'userView'
}
const registerToRegister = () => {
  showPage.value = 'login'
}
const outLogin = ()=>{
  store.commit('removeUser')
  update()
}

update()
</script>

<style lang="less" scoped>

</style>