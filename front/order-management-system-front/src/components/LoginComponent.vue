<template>
  <div>
    <el-form
        :model="loginUser"
        class="demo-ruleForm"
    >
      <el-form-item prop="phoneNumber">
        <el-input prefix-icon="Phone" placeholder="电话号" v-model="loginUser.phoneNumber"/>
      </el-form-item>
      <el-form-item prop="password">
        <el-input prefix-icon="Key" :type="tips" placeholder="密码" v-model="loginUser.password">
          <template #suffix>
            <el-icon @click="change">
              <hide v-if="!showPassword"/>
              <key v-if="showPassword"/>
            </el-icon>
          </template>
        </el-input>
      </el-form-item>
      <div class="buttons">
        <el-button @click="signup" type="success">注册</el-button>
        <el-button @click="login(loginUser)" type="primary">登录</el-button>
      </div>
    </el-form>
  </div>
</template>

<script setup lang="ts">
import {ref} from "vue";
import axios from "axios";
import {ElMessage} from "element-plus";
import {useStore} from "vuex";

const emits = defineEmits(['register', 'login'])
const showPassword = ref(false)

const tips = ref("password")

const signup = () => {
  emits('register')
}
const store = useStore();


const loginUser = ref({
  phoneNumber: "",
  password: ""
})
const login = (loginUser: any) => {
  axios.post('user/login', loginUser).then((res) => {
    if (res.data == "") {
      errorMessage('用户名或密码错误，请重新登陆')
    } else {
      successMessage('登陆成功！')
      store.commit('updateUser', res.data)
      emits('login')
    }
  })
}

const change = () => {
  showPassword.value = !showPassword.value;
  if (tips.value == "password") {
    tips.value = "text"
  } else {
    tips.value = "password"
  }
}

const errorMessage = (message: string) => {
  ElMessage({
    message: message,
    type: 'error'
  })
}

const successMessage = (message: string) => {
  ElMessage({
    message: message,
    type: 'success'
  })
}

</script>

<style lang="less" scoped>
.buttons {
  display: flex;
  align-items: center;
  justify-content: center;
  text-align: center;
}

.demo-ruleForm {
  width: 100%;
  font-family: "Times New Roman", serif;
  margin-top: 20px;
}
</style>