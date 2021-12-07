<template>
  <div class="container">
    <b-form @submit="onSubmit" @reset="onReset" v-if="show">
      <b-form-group
        id="input-group-1"
        label="사진:"
        label-for="input-1"
        description=""
      >
        <b-form-file
          v-model="form.files"
          :state="Boolean(form.files)"
          placeholder="Choose a file or drop it here..."
          drop-placeholder="Drop file here..."
          accept=".jpg, .png, .gif, .jpeg"
          multiple
        ></b-form-file>
      </b-form-group>

      <b-form-group
        id="input-group-2"
        label="장소:"
        label-for="input-2"
        description=""
      >
        <b-form-input
          list="my-list-id"
          id="input-2"
          v-model="form.title"
          type="text"
          placeholder="enter title..."
          required
        ></b-form-input>

        <!-- <datalist id="my-list-id">
          <option>Manual Option</option>
          <option
            v-for="(size, index) in sizes"
            :key="index"
            v-bind="sizes"
          ></option>
        </datalist> -->
      </b-form-group>

      <b-form-group
        id="input-group-3"
        label="설명:"
        label-for="input-3"
        description=""
      >
        <b-form-textarea
          id="input-3"
          v-model="form.content"
          type="textArea"
          placeholder="enter contents..."
          rows="4"
          required
        ></b-form-textarea>
      </b-form-group>

      <b-form-group
        id="input-group-4"
        label="자랑거리:"
        label-for="input-4"
        description="이 장소만의 특별한 점을 말해주세요! ex) 주차가능, 넓음"
      >
        <b-form-tags input-id="input-4" v-model="form.caption"></b-form-tags>
      </b-form-group>

      <b-form-group
        id="input-group-4"
        label="평점:"
        label-for="input-4"
        description=""
      >
        <b-form-rating
          v-model="form.grade"
          variant="warning"
          class="mb-2"
        ></b-form-rating>
      </b-form-group>

      <b-button type="submit" variant="primary">Upload</b-button>
      &nbsp;
      <b-button type="reset" variant="danger">Reset</b-button>
    </b-form>
    <!-- <b-card class="mt-3" header="Form Data Result">
      <pre class="m-0">{{ form }}</pre>
    </b-card> -->
  </div>
</template>

<script>
import { uploadPost } from "@/api/post.js";
import { mapState } from "vuex";
const memberStore = "memberStore";

export default {
  name: "Upload",
  computed: {
    ...mapState(memberStore, ["userInfo"]),
  },
  data() {
    return {
      form: {
        grade: 1,
        title: "",
        content: "",
        files: [],
        caption: [],
      },
      show: true,
      sizes: ["Small", "Medium"],
    };
  },
  methods: {
    onSubmit(event) {
      event.preventDefault();
      //   alert(JSON.stringify(this.form.files[0].name));
      let post = {
        user_id: this.userInfo.user_id,
        user_picture_url: this.userInfo.user_picture_url,
        picture_url: "https://picsum.photos/250/250/?image=58",
        title: this.form.title,
        content: this.form.content,
        grade: this.form.grade,
        lat: 0,
        lng: 0,
        like: 0,
      };
      uploadPost(
        post,
        () => {
          alert("정상적으로 등록되었습니다.");
          this.$router.push({ name: "Home" });
        },
        (error) => {
          console.log(error);
        }
      );
    },
    onReset(event) {
      event.preventDefault();
      // Reset our form values
      this.form.title = "";
      this.form.content = "";
      this.form.grade = 1;
      this.form.files = [];
      this.form.caption = [];
      // Trick to reset/clear native browser form validation state
      this.show = false;
      this.$nextTick(() => {
        this.show = true;
      });
    },
  },
};
</script>
