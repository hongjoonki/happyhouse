import Vue from "vue";
import VueRouter from "vue-router";
import Home from "@/views/Home.vue";
import Instargram from "@/views/Instargram.vue";
import Upload from "@/views/Upload.vue";

import Member from "@/views/Member.vue";
import MemberLogin from "@/components/user/MemberLogin.vue";
import MemberJoin from "@/components/user/MemberJoin.vue";
import MemberMyPage from "@/components/user/MemberMyPage.vue";
import MemberModify from "@/components/user/MemberModify.vue";

import Board from "@/views/Board.vue";
import BoardList from "@/components/board/BoardList.vue";
import BoardWrite from "@/components/board/BoardWrite.vue";
import BoardView from "@/components/board/BoardView.vue";
import BoardUpdate from "@/components/board/BoardUpdate.vue";

import Search from "@/views/Search.vue";

import MapView from "@/views/MapView.vue";

import store from "@/store/index.js";

import login from "@/views/login.vue";

import HouseView from "@/views/House.vue";

Vue.use(VueRouter);

// https://router.vuejs.org/kr/guide/advanced/navigation-guards.html
const onlyAuthUser = async (to, from, next) => {
  // console.log(store);
  const checkUserInfo = store.getters["memberStore/checkUserInfo"];
  const getUserInfo = store._actions["memberStore/getUserInfo"];
  let token = sessionStorage.getItem("access-token");
  if (checkUserInfo == null && token) {
    await getUserInfo(token);
  }
  if (checkUserInfo === null) {
    alert("로그인이 필요한 페이지입니다..");
    // next({ name: "SignIn" });
    router.push({ name: "SignIn" });
  } else {
    console.log("로그인 했다.");
    next();
  }
};

const routes = [
  {
    path: "/",
    name: "login",
    component: login,
  },
  {
    path: "/Home",
    name: "Home",
    component: Home,
  },
  {
    path: "/instargram",
    name: "Instargram",
    component: Instargram,
  },
  {
    path: "/upload",
    name: "Upload",
    component: Upload,
  },
  {
    path: "/user",
    name: "Member",
    component: Member,
    children: [
      {
        path: "singin",
        name: "SignIn",
        component: MemberLogin,
      },
      {
        path: "singup",
        name: "SignUp",
        component: MemberJoin,
      },
      {
        path: "mypage",
        name: "MyPage",
        beforeEnter: onlyAuthUser,
        component: MemberMyPage,
      },
      {
        path: "/memberModify",
        name: "MemberModify",
        component: MemberModify,
      },
    ],
  },
  {
    path: "/board",
    name: "Board",
    component: Board,
    redirect: "/board/list",
    children: [
      {
        path: "list",
        name: "BoardList",
        component: BoardList,
      },
      {
        path: "write",
        name: "BoardWrite",
        beforeEnter: onlyAuthUser,
        component: BoardWrite,
      },
      {
        path: "detail/:articleno",
        name: "BoardView",
        beforeEnter: onlyAuthUser,
        component: BoardView,
      },
      {
        path: "update/:articleno",
        name: "BoardUpdate",
        beforeEnter: onlyAuthUser,
        component: BoardUpdate,
      },
    ],
  },
  {
    path: "/search",
    name: "Search",
    component: Search,
  },
  {
    path: "/map",
    name: "MapView",
    component: MapView,
  },
  {
    path: "/house",
    name: "HouseView",
    component: HouseView,
  },
  {
    path: "*",
    redirect: "/",
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
