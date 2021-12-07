<template>
  <b-container class="mt-4" v-if="userInfo">
    <b-row>
      <b-col></b-col>
      <b-col cols="8">
        <b-jumbotron>
          <hr class="my-4" />

          <b-container class="mt-4">
            <b-card-img
              :src="userInfo.user_picture_url"
              style="width: 14rem"
            ></b-card-img>
            <b-row class="mt-4">
              <b-col cols="2"></b-col>
              <b-col cols="2" align-self="end">아이디</b-col
              ><b-col cols="4" align-self="start">{{ userInfo.user_id }}</b-col>
              <b-col cols="2"></b-col>
            </b-row>
            <b-row>
              <b-col cols="2"></b-col>
              <b-col cols="2" align-self="end">이름</b-col
              ><b-col cols="4" align-self="start">{{
                userInfo.user_name
              }}</b-col>
              <b-col cols="2"></b-col>
            </b-row>
            <b-row>
              <b-col cols="2"></b-col>
              <b-col cols="2" align-self="end">전화번호</b-col
              ><b-col cols="4" align-self="start">{{
                userInfo.user_phone
              }}</b-col>
              <b-col cols="2"></b-col>
            </b-row>
            <b-row>
              <b-col cols="2"></b-col>
              <b-col cols="2" align-self="end">소개</b-col
              ><b-col cols="4" align-self="start">{{
                userInfo.user_intro
              }}</b-col>
              <b-col cols="2"></b-col>
            </b-row>
          </b-container>
          <hr class="my-4" />

          <b-button variant="primary" @click="userModify" class="mr-1"
            >정보수정</b-button
          >
          <b-button variant="danger" @click="userDelete">회원탈퇴</b-button>
        </b-jumbotron>
      </b-col>
      <b-col></b-col>
    </b-row>
  </b-container>
</template>

<script>
import { mapState } from "vuex";
import { userDelete } from "@/api/member.js";
const memberStore = "memberStore";

export default {
  name: "MemberMyPage",
  components: {},
  computed: {
    ...mapState(memberStore, ["userInfo"]),
  },
  methods: {
    async userDelete() {
      await userDelete(this.userInfo.user_id);
      sessionStorage.clear();
      this.$router.go();
      this.$router.push({ name: "login" });
    },

    userModify() {
      this.$router.push({ name: "MemberModify" });
    },
  },
};
</script>

<style></style>
