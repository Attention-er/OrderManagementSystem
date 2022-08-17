<template>
  <!--    <img alt="Vue logo" src="../assets/logo.png">-->
  <!--    <HelloWorld msg="Welcome to Your Vue.js + TypeScript App"/>-->
  <Head/>
  <Search/>
  <BusinessType :business-types="business_data.bts"/>
  <Banner/>
  <SuperMember/>
  <RecommendType/>
  <Business :businesses="business_data.bss"/>
  <Foot/>
</template>

<script setup lang="ts">
import Head from "@/components/Head";
import Foot from "@/components/Foot.vue";
import Search from "@/components/Search";
import BusinessType from "@/components/BusinessType";
import Banner from "@/components/Banner";
import SuperMember from "@/components/SuperMember";
import Business from "@/components/Business";
import RecommendType from "@/components/RecommendType";
import {onBeforeMount, ref} from "vue";
import axios from "axios";

const business_data = ref({
  bts:[],
  bss:[]
})
const getBusiness = () => {
  axios.get("index/fullPage").then((res) => {
    business_data.value = res.data;
  })
}
onBeforeMount(()=>{

  getBusiness()
})

</script>
