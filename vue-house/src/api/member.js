import { apiInstance } from "./index.js";

const api = apiInstance();

async function login(user, success, fail) {
  await api.post(`/user/login`, JSON.stringify(user)).then(success).catch(fail);
}

async function findById(userid, success, fail) {
  api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
  await api.get(`/user/info/${userid}`).then(success).catch(fail);
}

async function userRegist(user, success, fail) {
  console.log(JSON.stringify(user));
  await api.post(`/user`, JSON.stringify(user)).then(success).catch(fail);
}

async function userDelete(user_id, success, fail) {
  await api.delete(`/user/${user_id}`).then(success).catch(fail);
}

async function userSearch(user_id, success, fail) {
  await api.get(`/user/search/${user_id}`).then(success).catch(fail);
}

// function logout(success, fail)

export { login, findById, userRegist, userDelete, userSearch };
