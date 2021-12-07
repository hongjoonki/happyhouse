<template>
  <b-row>
    <b-col cols="2"></b-col>
    <b-col cols="10">
      <post-presenter
        v-for="(post, index) in posts"
        :key="index"
        v-bind="post"
        v-show="!loading"
      />
    </b-col>
    <b-col cols="2"></b-col>
  </b-row>
</template>

<script>
import { seeFeed } from "@/api/post.js";
import PostPresenter from "./PostPresenter.vue";

export default {
  components: { PostPresenter },
  name: "Post",
  data() {
    return {
      loading: false,
      posts: [],
    };
  },
  created() {
    // 뷰가 생성되고 데이터가 이미 감시 되고 있을 때 데이터를 가져온다.
    this.fetchData();
  },
  watch: {
    // 라우트가 변경되면 메소드를 다시 호출됩니다.
    $route: "fetchData",
  },
  methods: {
    fetchData() {
      let param = {
        user_id: "ssafy",
      };
      this.loading = true;
      // `getPost`를 데이터 가져오기 위한 유틸리티/API 래퍼로 변경합니다.
      seeFeed(
        param,
        (response) => {
          this.posts = response.data;
        },
        (error) => {
          console.log(error);
        }
      );
      this.loading = false;
    },
  },
};
</script>

<style></style>
