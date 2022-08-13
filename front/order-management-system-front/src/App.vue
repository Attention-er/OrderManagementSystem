<template>
  <Head/>
  <Search/>
  <BusinessType/>
  <Banner/>
  <SuperMember/>
  <RecommendType/>
  <Business/>
  <Foot/>
</template>

<script>
import Head from "@/components/Head";
import Search from "@/components/Search";
import BusinessType from "@/components/BusinessType";
import Banner from "@/components/Banner";
import SuperMember from "@/components/SuperMember";
import Business from "@/components/Business";
import RecommendType from "@/components/RecommendType";
import Foot from "@/components/Foot";

export default {
  components: {Foot, RecommendType, Business, SuperMember, Banner, BusinessType, Head, Search}
}
</script>


<style lang="less" scoped>
*{
  //margin: 0;
  padding: 0;
}
</style>