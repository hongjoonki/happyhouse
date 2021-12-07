<template>
  <div class="container">
    <b-form inline>
      <label class="sr-only" for="inline-form-input-name">places</label>
      <b-form-input
        id="places"
        class="mb-2 mr-sm-2 mb-sm-0"
        placeholder="places..."
        v-model="address"
        @keyup.enter="geocodeAddress"
      ></b-form-input>

      <b-button variant="primary" @click="geocodeAddress">search</b-button>
    </b-form>
    <GmapMap :center="center" :zoom="zoom" style="width: 90% margin: auto">
      <GmapMarker
        :key="index"
        v-for="(m, index) in markers"
        :position="m.position"
        :clickable="true"
        :draggable="true"
        @click="
          center = m.position;
          zoom = 14;
        "
      />
    </GmapMap>
  </div>
</template>
<script>
import { getLocation } from "@/api/map.js";

export default {
  name: "Map",
  data() {
    return {
      address: "",
      center: {
        lat: 37.5012743,
        lng: 127.039585,
      },
      zoom: 12,
      markers: [
        {
          title: "",
          position: {},
        },
      ],
    };
  },
  methods: {
    geocodeAddress() {
      console.log("geocodeAddress 함수 실행");
      let param = {
        address: this.address,
      };
      getLocation(
        param.address,
        (response) => {
          console.log(response.data.results);
          if (response.data.results.length > 0) {
            this.center = response.data.results[0].geometry.location;
            this.zoom = 16;
            let marker = {
              title: this.address,
              position: response.data.results[0].geometry.location,
            };
            this.markers = [marker];
          }
        },
        (error) => {
          console.log(error);
        }
      );
    },
  },
};
</script>
<style>
.vue-map-container {
  height: 500px;
}
</style>
