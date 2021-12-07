import { geocoderInstance } from "./index.js";

const api = geocoderInstance();

function getLocation(address, success, fail) {
  api
    .get(`json?address=${address}&key=${process.env.VUE_APP_GOOGLE_APIKEY}`)
    .then(success)
    .catch(fail);
}

export { getLocation };
