<template>
  <div class="nav-bar">
    <b-container>
      <b-navbar toggleable="lg" type="dark">
        <b-navbar-brand href="#">
          <router-link to="/">
            <img
              src="@/assets/logossafy.png"
              class="d-inline-block align-middle"
              width="90px"
              alt="Kitten"
            />
          </router-link>
        </b-navbar-brand>

        <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>
      </b-navbar>
    </b-container>
  </div>
</template>

<script>
import { mapState, mapMutations } from "vuex";

const memberStore = "memberStore";

export default {
  name: "NaviBar",
  computed: {
    ...mapState(memberStore, ["isLogin", "userInfo"]),
  },
  methods: {
    ...mapMutations(memberStore, ["SET_IS_LOGIN", "SET_USER_INFO"]),
    onClickLogout() {
      this.SET_IS_LOGIN(false);
      this.SET_USER_INFO(null);
      sessionStorage.removeItem("access-token");
      if (this.$route.path != "/") this.$router.push({ name: "Home" });
    },
  },
};
</script>

<style>
div > .nav-bar {
  background-color: white;
}

.navbar-toggler > .navbar-toggler-icon {
  background-color: black;
}
</style>
