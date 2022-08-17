<template>
  <TempHead title="商家列表"/>
  <LittleBusinessList :businesses="businesses"/>
</template>

<script lang="ts" setup>
import TempHead from "@/components/TempHead";
import LittleBusinessList from "@/components/LittleBusinessList.vue";
import axios from "axios";
import {ref} from "vue";
import {useRoute} from "vue-router";
import {useStore} from "vuex";
const businesses = ref();
const route = useRoute();
const typeId = route.query.typeId;
const store = useStore();
console.log(typeId)
const getBusiness = () => {
  axios.get("index/businessesByType",{
    params:{
      typeId:typeId
    }
  }).then((res) => {
    businesses.value = res.data;
  })
}
getBusiness()
</script>

<style scoped lang="less">

</style>