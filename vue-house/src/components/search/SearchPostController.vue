<template>
  <div>
    <b-list-group>
      <search-post-box
        v-for="(post, index) in posts"
        :key="index"
        v-bind="post"
      />
    </b-list-group>
  </div>
</template>

<script>
import { seePostTitle } from "@/api/post.js";
import SearchPostBox from "./SearchPostBox.vue";

export default {
  components: { SearchPostBox },
  name: "SearchPostController",
  props: {
    searchTerm: String,
  },
  data() {
    return {
      posts: [],
    };
  },
  created() {
    this.fetchData();
  },
  watch: {
    searchTerm: "fetchData",
  },
  methods: {
    fetchData() {
      if (this.searchTerm.length > 0) {
        let param = {
          title: this.searchTerm,
        };
        this.loading = true;
        // `getPost`를 데이터 가져오기 위한 유틸리티/API 래퍼로 변경합니다.
        seePostTitle(
          param.title,
          (response) => {
            this.posts = response.data;
          },
          (error) => {
            console.log(error);
          }
        );
        this.loading = false;
      }
    },
  },
};
</script>

<style></style>
