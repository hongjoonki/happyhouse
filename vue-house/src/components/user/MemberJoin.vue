<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <b-alert variant="secondary" show><h3>회원가입</h3></b-alert>
      </b-col>
    </b-row>
    <b-row>
      <b-col></b-col>
      <b-col cols="8">
        <b-card class="text-center mt-3" style="max-width: 40rem" align="left">
          <b-form class="text-left">
            <b-form-group label="아이디:" label-for="user_id">
              <b-form-input
                id="user_id"
                v-model="user.user_id"
                required
                placeholder="아이디 입력...."
                @keyup.enter="confirm"
              ></b-form-input>
            </b-form-group>
            <b-form-group label="비밀번호:" label-for="user_password">
              <b-form-input
                type="password"
                id="user_password"
                v-model="user.user_password"
                required
                placeholder="비밀번호 입력...."
                @keyup.enter="confirm"
              ></b-form-input>
            </b-form-group>
            <b-form-group label="이름:" label-for="user_name">
              <b-form-input
                id="user_name"
                v-model="user.user_name"
                required
                placeholder="이름 입력...."
                @keyup.enter="confirm"
              ></b-form-input>
            </b-form-group>
            <b-form-group label="핸드폰 번호:" label-for="user_phone">
              <b-form-input
                id="user_phone"
                v-model="user.user_phone"
                required
                placeholder="핸드폰 번호 입력...."
                @keyup.enter="confirm"
              ></b-form-input>
            </b-form-group>
            <b-form-group label="자기소개:" label-for="user_intro">
              <b-form-input
                id="user_intro"
                v-model="user.user_intro"
                required
                placeholder="자기소개 입력...."
                @keyup.enter="confirm"
              ></b-form-input>
            </b-form-group>
            <b-button
              type="button"
              variant="primary"
              class="m-1"
              @click="confirm"
              >회원가입</b-button
            >
            <b-button
              type="button"
              variant="success"
              class="m-1"
              @click="movePage"
              >취소</b-button
            >
          </b-form>
        </b-card>
      </b-col>
      <b-col></b-col>
    </b-row>
  </b-container>
</template>

<script>
import { userRegist } from "@/api/member.js";

export default {
  name: "MemberJoin",
  data() {
    return {
      user: {
        user_id: null,
        user_password: null,
        user_name: null,
        user_phone: null,
        user_intro: null,
      },
    };
  },
  methods: {
    async confirm() {
      await userRegist(this.user);
      this.$router.push({ name: "login" });
    },
    movePage() {
      this.$router.push({ name: "login" });
    },
  },
};
</script>

<style></style>
