<template>
  <div>
    <phone-book-header></phone-book-header>
    <phone-book-search></phone-book-search>
    <phone-book-list></phone-book-list>
  </div>
</template>

<script>
  import axios from 'axios'
  import {getServerUrl} from '@/config/sys.js'
  import PhoneBookHeader from './components/Header'
  import PhoneBookSearch from './components/Search'
  import PhoneBookList from './components/List'

  export default {
    name: "PhoneBook",
    components: {
      PhoneBookHeader,
      PhoneBookSearch,
      PhoneBookList
    },
    methods: {
      refreshToken() {
        let token = window.localStorage.getItem("token")
        axios.defaults.headers.common['token'] = token
        let url = getServerUrl("refreshToken");
        axios.get(url)
          .then(response => {
            console.log("token刷新：" + response.data.token)
            window.localStorage.setItem("token", response.data.token);
          }).catch(error => {
          console.log(error)
        })
      },
      getPhoneBooks() {
        let token = window.localStorage.getItem("token")
        axios.defaults.headers.common['token'] = token
        let url = getServerUrl("phoneBook/loadAll");
        axios.get(url)
          .then(response => {
            console.log(response)
          }).catch(error => {
          console.log(error)
        })
      }
    },
    mounted() {
      setInterval(this.refreshToken, 1000 * 60 * 10); // 10分钟刷新一次token
      this.getPhoneBooks(); // 加载所有电话簿信息
    }
  }
</script>

<style scoped>

</style>
