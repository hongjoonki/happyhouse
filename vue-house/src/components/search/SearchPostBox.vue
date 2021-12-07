<template>
  <b-list-group-item href="#" class="flex-column align-items-start">
    <div class="w-30 justify-content-between">
      <h3 class="mb-1">{{ title }}</h3>
      <p>{{ content.length > 22 ? content.substr(0, 18) + "..." : content }}</p>
      <h5 class="mb-1">
        <b-img
          thumbnail
          :src="user_picture_url"
          alt="Image 1"
          style="width: 40px"
          rounded="circle"
        ></b-img>
        {{ user_id }}
      </h5>
    </div>
  </b-list-group-item>
</template>

<script>
export default {
  name: "SearchPostBox",
  props: {
    content: String,
    grade: Number,
    lat: String,
    like: Number,
    lng: String,
    picture_url: String,
    post_no: Number,
    regtime: String,
    title: String,
    user_id: String,
    user_picture_url: String,
  },
};
</script>

<style></style>
