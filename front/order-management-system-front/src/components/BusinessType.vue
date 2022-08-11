<template>
  <ul class="business-type">
    <li v-for="businessType in businessTypes">
      <img src="@/components/img/dcfl01.png"/>
      <p>{{ businessType.name }}</p>
    </li>
  </ul>
</template>

<script setup lang="ts">

import {ref} from "vue";

const businessTypes = ref()
businessTypes.value = [
  {
    name: '美食',
    img: "@/components/img/dcfl01.png"
  },
  {
    name: '美食',
    img: "@/components/img/dcfl01.png"
  },
  {
    name: '美食',
    img: "@/components/img/dcfl01.png"
  },
  {
    name: '美食',
    img: "@/components/img/dcfl01.png"
  },
  {
    name: '美食',
    img: "@/components/img/dcfl01.png"
  },
  {
    name: '美食',
    img: "@/components/img/dcfl01.png"
  },
  {
    name: '美食',
    img: "@/components/img/dcfl01.png"
  },
  {
    name: '美食',
    img: "@/components/img/dcfl01.png"
  },
  {
    name: '美食',
    img: "@/components/img/dcfl01.png"
  },
  {
    name: '美食',
    img: "@/components/img/dcfl01.png"
  }
]

</script>

<style lang="less" scoped>

@import "less/businessType.less";

</style>