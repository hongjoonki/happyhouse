<template>
  <b-list-group-item href="#" class="flex-column align-items-start">
    <div class="d-flex w-30 justify-content-between">
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
    <p class="mb-1 d-flex">{{ user_intro }}</p>
  </b-list-group-item>
</template>

<script>
export default {
  name: "SearchUserBox",
  props: {
    user_id: String,
    user_picture_url: String,
    user_intro: String,
  },
};
</script>

<style></style>
