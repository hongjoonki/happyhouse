<template>
  <b-container class="bv-example-row mt-3 text-center" id="main">
    <!-- <h3 class="underline-orange">
      <b-icon icon="house-fill"></b-icon> Search Service
    </h3> -->
    <b-form inline>
      <b-icon icon="search" font-scale="1.5" variant="dark"></b-icon>
      &nbsp;
      <b-form-input
        class="mb-2 mr-sm-2 mb-sm-0"
        placeholder="search.."
        v-model.trim="searchTerm"
      ></b-form-input>
    </b-form>
    <b-tabs content-class="mt-3">
      <b-tab title="User" active>
        <search-user-controller :searchTerm="searchTerm" />
      </b-tab>
      <b-tab title="Post">
        <search-post-controller :searchTerm="searchTerm" />
      </b-tab>
    </b-tabs>
  </b-container>
</template>
<script>
// import HouseSearchBar from "@/components/house/HouseSearchBar.vue";
// import HouseList from "@/components/house/HouseList.vue";
// import HouseDetail from "@/components/house/HouseDetail.vue";
import SearchUserController from "@/components/search/SearchUserController.vue";
import SearchPostController from "@/components/search/SearchPostController.vue";

export default {
  name: "Search",
  data() {
    return {
      selected: "Post",
      searchTerm: "",
    };
  },
  components: {
    // HouseSearchBar,
    // HouseList,
    // HouseDetail,
    SearchUserController,
    SearchPostController,
  },
};
</script>
<style scoped>
.underline-orange {
  display: inline-block;
  background: linear-gradient(
    180deg,
    rgba(255, 255, 255, 0) 70%,
    rgba(231, 149, 27, 0.3) 30%
  );
}
</style>
