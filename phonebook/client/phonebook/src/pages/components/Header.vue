<template>
    <div class="header">
      通讯录
      <router-link tag="div" to="/add" class="iconfont add-icon">&#xe81b;</router-link>
    </div>
</template>

<script>
    export default {
        name: "Header"
    }
</script>

<style lang="stylus" scoped>

  @import "~@/assets/styles/varibles.styl"

  .header
    position: relative
    overflow: hidden
    background: $bgColor
    font-size: .35rem
    font-weight: 700
    text-align: center
    height: .86rem
    line-height: .86rem
    .add-icon
      position: fixed
      right: .45rem
      top: 0rem
</style>
