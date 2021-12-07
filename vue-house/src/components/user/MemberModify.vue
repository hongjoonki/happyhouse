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
              <b-col cols="2" align-self="end">비밀번호</b-col
              ><b-col cols="4" align-self="start"
                ><b-form-input
                  type="text"
                  v-model="user_password"
                  class="mt-2"
                ></b-form-input
              ></b-col>
              <b-col cols="2"></b-col>
            </b-row>
            <b-row>
              <b-col cols="2"></b-col>
              <b-col cols="2" align-self="end">이름</b-col
              ><b-col cols="4" align-self="start"
                ><b-form-input
                  type="text"
                  v-model="user_name"
                  class="mt-2"
                ></b-form-input
              ></b-col>
              <b-col cols="2"></b-col>
            </b-row>
            <b-row>
              <b-col cols="2"></b-col>
              <b-col cols="2" align-self="end">전화번호</b-col
              ><b-col cols="4" align-self="start"
                ><b-form-input
                  type="text"
                  v-model="user_phone"
                  class="mt-2"
                ></b-form-input
              ></b-col>
              <b-col cols="2"></b-col>
            </b-row>
            <b-row>
              <b-col cols="2"></b-col>
              <b-col cols="2" align-self="end">소개</b-col
              ><b-col cols="4" align-self="start"
                ><b-form-input
                  type="text"
                  v-model="user_intro"
                  class="mt-2"
                ></b-form-input
              ></b-col>
              <b-col cols="2"></b-col>
            </b-row>
          </b-container>
          <hr class="my-4" />

          <b-button variant="primary" @click="userModify" class="mr-1"
            >정보수정</b-button
          >
          <b-button variant="danger" @click="cancel">취소</b-button>
        </b-jumbotron>
      </b-col>
      <b-col></b-col>
    </b-row>
  </b-container>
</template>

<script>
import { mapState } from "vuex";
const memberStore = "memberStore";

export default {
  name: "MemberModify",
  data() {
    return {
      user_password: "",
      user_name: "",
      user_phone: "",
      user_intro: "",
    };
  },
  created() {
    console.log(this.userInfo);
    this.user_password = this.userInfo.user_password;
    this.user_name = this.userInfo.user_name;
    this.user_phone = this.userInfo.user_phone;
    this.user_intro = this.userInfo.user_intro;
  },
  components: {},
  computed: {
    ...mapState(memberStore, ["userInfo"]),
  },
  methods: {
    cancel() {
      console.log("cancel");
    },

    userModify() {
      this.$router.puush({ name: "MemberModify" });
    },

    create() {
      console.log("123");
      console.log(this.userInfo);
    },
  },
};
</script>

<style></style>
