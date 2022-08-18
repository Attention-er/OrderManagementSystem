<template>
  <div>
    <el-form
        :model="registerUser"
        class="demo-ruleForm"
        :rules="rules"
    >
      <el-form-item prop="phoneNumber">
        <el-input prefix-icon="Phone" placeholder="电话号" v-model="registerUser.phoneNumber"/>
      </el-form-item>
      <el-form-item prop="password">
        <el-input prefix-icon="Key" :type="tips" placeholder="密码" v-model="registerUser.password">
          <template #suffix>
            <el-icon @click="change">
              <hide v-if="!showPassword"/>
              <key v-if="showPassword"/>
            </el-icon>
          </template>
        </el-input>
      </el-form-item>
      <el-form-item prop="twicePassword">
        <el-input prefix-icon="Key" :type="twiceTips" placeholder="确认密码" v-model="registerUser.twicePassword">
          <template #suffix>
            <el-icon @click="changeTwice">
              <hide v-if="!showTwicePassword"/>
              <key v-if="showTwicePassword"/>
            </el-icon>
          </template>
        </el-input>
      </el-form-item>
      <el-form-item prop="userName">
        <el-input prefix-icon="User" placeholder="用户名" v-model="registerUser.userName"/>
      </el-form-item>
      <el-form-item label="性别：" prop="sex">
        <el-radio-group v-model="registerUser.sex">
          <el-radio label="男">男</el-radio>
          <el-radio label="女">女</el-radio>
        </el-radio-group>
      </el-form-item>
      <div class="buttons">
        <el-button @click="signup" type="success">登录</el-button>
        <el-button @click="register(registerUser)" type="primary">注册</el-button>
      </div>
    </el-form>
  </div>
</template>

<script lang="ts" setup>
import {reactive, ref} from "vue";
import axios from "axios";
import {ElMessage, FormRules} from "element-plus";
import {useStore} from "vuex";

const showPassword = ref(false)

const showTwicePassword = ref(false)
const tips = ref("password")
const twiceTips = ref("password")

const signup = () => {
  emits('register')
}
const store = useStore();

const emits = defineEmits(['login','register']);

const registerUser = ref({
  phoneNumber: "",
  password: "",
  twicePassword: "",
  userName: "",
  sex: "男"
})

let validatePass = (rule: any, value: any, callback: any) => {
  if (value !== registerUser.value.password) {
    callback(new Error('两次密码输入不一致!'));
  } else {
    callback()
  }
};
const rules = reactive<FormRules>({
      name: [
        {
          required: true,
          message: '请输入姓名',
          trigger: 'blur'
        }
      ],
      password: [
        {
          required: true,
          message: '请输入密码',
          trigger: 'blur'
        },
        {
          min: 7,
          max: 20,
          message: '密码长度应该在7到20位',
          trigger: 'blur'
        }
      ],
      twicePassword: [
        {
          required: true,
          message: '请输入确认密码',
          trigger: 'blur'
        },
        {
          validator: validatePass, trigger: 'blur', required: true
        }
      ],
      phoneNumber: [
        {
          pattern: /^[1](([3][0-9])|([4][5-9])|([5][0-3,5-9])|([6][5,6])|([7][0-8])|([8][0-9])|([9][1,8,9]))[0-9]{8}$/,
          required: true,
          message: '请输入正确的手机号',
          trigger: 'blur'
        }
      ]
    }
)

const register = (registerUser: any) => {
  axios.post('user/register', registerUser).then((res) => {
    if (res.data == "") {
      errorMessage('当前手机号已注册！')
    } else {
      successMessage('注册成功！')
      // store.commit('updateUser', res.data)
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

const changeTwice = () => {
  showTwicePassword.value = !showTwicePassword.value;
  if (twiceTips.value == "password") {
    twiceTips.value = "text"
  } else {
    twiceTips.value = "password"
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