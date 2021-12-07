import { apiInstance } from "./index.js";

const api = apiInstance();

function seeFeed(param, success, fail) {
  api.get(`/posts/feed`, { params: param }).then(success).catch(fail);
}

function seePostTitle(title, success, fail) {
  api.get(`/posts/title/${title}`).then(success).catch(fail);
}

function seeFullPost(user_id, success, fail) {
  api.get(`posts/${user_id}`).then(success).catch(fail);
}

function uploadPost(post, success, fail) {
  api.post(`posts/`, JSON.stringify(post)).then(success).catch(fail);
}

// function writeArticle(article, success, fail) {
//   api.post(`/board`, JSON.stringify(article)).then(success).catch(fail);
// }

// function getArticle(articleno, success, fail) {
//   api.get(`/board/${articleno}`).then(success).catch(fail);
// }

// function modifyArticle(article, success, fail) {
//   api.put(`/board`, JSON.stringify(article)).then(success).catch(fail);
// }

// function deleteArticle(articleno, success, fail) {
//   api.delete(`/board/${articleno}`).then(success).catch(fail);
// }

export { seeFeed, seePostTitle, seeFullPost, uploadPost };
