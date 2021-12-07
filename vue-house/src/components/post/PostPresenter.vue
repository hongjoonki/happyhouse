<template>
  <div>
    <b-card align="left" tag="article" style="max-width: 400px">
      <b-card-header>
        <b-img
          thumbnail
          src="https://picsum.photos/250/250/?image=58"
          alt="Image 1"
          style="width: 40px"
          rounded="circle"
        ></b-img>
        <b @click="printUser"> {{ user_id }}</b>
        <p style="color: grey">{{ title }}</p>
      </b-card-header>
      <b-card-img :src="picture_url"></b-card-img>
      <b-card-text>{{ content }}</b-card-text>
      <b-card-text>#tag1 #tag2</b-card-text>
      <b-card-footer>
        <b-icon
          v-if="!isLike"
          icon="heart"
          font-scale="1.5"
          variant="dark"
          @click="toggleLike"
        ></b-icon>
        <b-icon
          v-else
          icon="heart-fill"
          font-scale="1.5"
          variant="dark"
          @click="toggleLike"
        ></b-icon>
        &nbsp;
        <b-icon icon="chat-dots" font-scale="1.5" variant="dark"></b-icon>
        <b-icon
          icon="three-dots"
          font-scale="1.5"
          variant="dark"
          style="float: right"
        ></b-icon>
      </b-card-footer>
    </b-card>
  </div>
</template>

<script>
export default {
  name: "PostPresenter",
  props: {
    content: String,
    grade: Number,
    lat: String,
    lng: String,
    like: Number,
    user_id: String,
    picture_url: String,
    user_picture_url: String,
    post_no: Number,
    regtime: String,
    title: String,
  },
  data() {
    return {
      isLike: false,
    };
  },
  methods: {
    printUser() {
      alert(this.user_id + "개인정보 화면으로 이동");
    },
    toggleLike() {
      this.isLike = !this.isLike;
    },
  },
};
</script>

<style></style>
