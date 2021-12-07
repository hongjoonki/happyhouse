<template>
  <b-container class="bv-example-row mt-3 text-center">
    <post-controller />
  </b-container>
</template>

<script>
import PostController from "@/components/post/PostController.vue";
export default {
  name: "Main",
  props: {
    msg: String,
  },
  components: {
    PostController,
  },
};
</script>

<style scoped>
.underline-steelblue {
  display: inline-block;
  background: linear-gradient(
    180deg,
    rgba(255, 255, 255, 0) 70%,
    rgba(72, 190, 233, 0.3) 30%
  );
}
</style>
