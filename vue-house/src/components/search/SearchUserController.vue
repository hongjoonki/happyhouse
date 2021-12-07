<template>
  <div>
    <b-list-group>
      <search-user-box
        v-for="(user, index) in users"
        :key="index"
        v-bind="user"
      />
    </b-list-group>
  </div>
</template>

<script>
import { userSearch } from "@/api/member.js";
import SearchUserBox from "./SearchUserBox.vue";

export default {
  components: { SearchUserBox },
  name: "SearchUserController",
  props: {
    searchTerm: String,
  },
  data() {
    return {
      users: [],
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
          user_id: this.searchTerm,
        };
        this.loading = true;
        // `getPost`를 데이터 가져오기 위한 유틸리티/API 래퍼로 변경합니다.
        userSearch(
          param.user_id,
          (response) => {
            this.users = response.data;
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
