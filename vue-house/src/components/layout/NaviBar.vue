<template>
  <div class="nav-bar">
    <b-container>
      <b-navbar toggleable="lg" type="dark">
        <b-navbar-brand href="#">
          <router-link to="/Home">
            <img
              src="@/assets/logossafy.png"
              class="d-inline-block align-middle"
              width="90px"
              alt="Kitten"
            />
          </router-link>
        </b-navbar-brand>

        <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

        <b-collapse id="nav-collapse" is-nav>
          <b-navbar-nav>
            <b-nav-item href="#"
              ><router-link :to="{ name: 'Home' }" class="link"
                ><b-icon icon="house" font-scale="1" variant="dark"></b-icon>
                HOME</router-link
              ></b-nav-item
            >
            <b-nav-item href="#"
              ><router-link :to="{ name: 'Search' }" class="link"
                ><b-icon icon="search" font-scale="1" variant="dark"></b-icon>
                Search</router-link
              ></b-nav-item
            >
            <b-nav-item href="#"
              ><router-link :to="{ name: 'Upload' }" class="link"
                ><b-icon
                  icon="plus-circle"
                  font-scale="1"
                  variant="dark"
                ></b-icon>
                Post</router-link
              ></b-nav-item
            >
            <b-nav-item href="#"
              ><router-link :to="{ name: 'HouseView' }" class="link"
                ><b-icon icon="house" font-scale="1" variant="dark"></b-icon>
                House</router-link
              ></b-nav-item
            >
            <b-nav-item href="#"
              ><router-link :to="{ name: 'MapView' }" class="link"
                ><b-icon icon="map" font-scale="1" variant="dark"></b-icon>
                Map</router-link
              ></b-nav-item
            >
          </b-navbar-nav>

          <b-navbar-nav class="ml-auto" v-if="userInfo">
            <b-nav-item class="align-self-center"
              ><b-avatar
                variant="dark"
                v-text="
                  userInfo ? userInfo.user_id.charAt(0).toUpperCase() : ''
                "
              ></b-avatar
              ><span style="color: black"
                >{{ userInfo.user_name }}({{ userInfo.user_id }})님
                환영합니다.</span
              ></b-nav-item
            >
            <b-nav-item class="align-self-center"
              ><router-link
                :to="{ name: 'MyPage' }"
                class="link align-self-center"
                style="color: black"
                >내정보보기</router-link
              ></b-nav-item
            >
            <b-nav-item
              class="link align-self-center"
              @click.prevent="onClickLogout"
              ><span style="color: black">로그아웃</span></b-nav-item
            >
          </b-navbar-nav>
          <b-navbar-nav class="ml-auto" v-else>
            <b-nav-item-dropdown right toggle-class="text-dark">
              <template #button-content>
                <b-icon icon="people" font-scale="2" variant="dark"></b-icon>
              </template>
              <b-dropdown-item href="#"
                ><router-link :to="{ name: 'SignUp' }" class="link"
                  ><b-icon icon="person-circle" variant="dark"></b-icon>
                  회원가입</router-link
                ></b-dropdown-item
              >
              <b-dropdown-item href="#"
                ><router-link :to="{ name: 'SignIn' }" class="link"
                  ><b-icon icon="key" variant="dark"></b-icon>
                  로그인</router-link
                ></b-dropdown-item
              >
            </b-nav-item-dropdown>
          </b-navbar-nav>
        </b-collapse>
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
      if (this.$route.path != "/") this.$router.push({ name: "login" });
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
