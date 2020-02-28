<template>
  <div>电话薄主页</div>
</template>

<script>
  import axios from 'axios';
  import {getServerUrl} from "@/config/sys.js";

  export default {
    name: "PhoneBook",
    methods: {
      getPhoneBooks() {
        let token = window.localStorage.getItem("token");
        axios.defaults.headers.common["token"] = token;
        let url = getServerUrl("phoneBook/loadAll");
        axios.get(url)
          .then(reseponse => {
            console.log(reseponse)
          }).catch(error => {
          console.log(error)
        });
      },
      mounted(){
        this.getPhoneBooks();//加载所有的电话薄信息
      }
    }
  }
</script>

<style scoped>

</style>
