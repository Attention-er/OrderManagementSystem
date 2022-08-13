<template>
  <ul class="business-type">
    <li v-for="businessType in businessTypes">
      <img :src="businessType.img"/>
      <p>{{ businessType.name }}</p>
    </li>
  </ul>
</template>

<script setup lang="ts">

import {ref} from "vue";
import img from '@/components/img/dcfl01.png';
const businessTypes = ref()
businessTypes.value = [
  {
    name: '美食',
    img: img
  },
  {
    name: '美食',
    img: img
  },
  {
    name: '美食',
    img: img
  },
  {
    name: '美食',
    img: img
  },
  {
    name: '美食',
    img: img
  },
  {
    name: '美食',
    img: img
  },
  {
    name: '美食',
    img: img
  },
  {
    name: '美食',
    img: img
  },
  {
    name: '美食',
    img: img
  },
  {
    name: '美食',
    img: img
  }
]

</script>

<style lang="less" scoped>

@import "./less/businessType.less";

</style>