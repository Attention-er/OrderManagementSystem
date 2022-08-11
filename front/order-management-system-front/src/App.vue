<template>
  <Head/>
  <Search/>
  <BusinessType/>
  <Banner/>
</template>

<style lang="less">
</style>
<script>
import Head from "@/components/Head";
import Search from "@/components/Search";
import BusinessType from "@/components/BusinessType";
import Banner from "@/components/Banner";
export default {
  components: {Banner, BusinessType, Head,Search}
}
</script>