<template>
  <div id="app">
    <navi-bar v-if="userInfo" />
    <navi v-else />
    <router-view />
  </div>
</template>

<script>
import NaviBar from "./components/layout/NaviBar.vue";
import Navi from "./components/layout/Navi.vue";
import { mapState, mapMutations } from "vuex";
const memberStore = "memberStore";

export default {
  name: "App",
  computed: {
    ...mapState(memberStore, ["isLogin", "userInfo"]),
  },
  components: {
    NaviBar,
    Navi,
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
#app {
  background-color: lavenderblush;
}

a:hover {
  text-decoration: none;
  font-weight: bold;
}

a.router-link-exact-active {
  color: #42b983;
}
</style>
