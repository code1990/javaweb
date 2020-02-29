<template>
    <ul class="list">
      <li class="item"
         v-for="(item,key) of letters">{{item}}</li>
    </ul>
</template>

<script>
    export default {
        name: "Alphabet",
        props:{
          phoneBooks:Object
        },
        computed:{
          letters(){
            const lettes=[]
            for (let i in this.phoneBooks){
              console.log(i)
              lettes.push(i)
            }
            return lettes;
          }
        }
    }
</script>

<style lang="stylus" scoped>

  .list
    display: flex
    flex-direction: column
    justify-content: center
    position: absolute;
    top: 1.58rem;
    right: 0;
    bottom: 0;
    width: .4rem;

    .item
      line-height: .4rem
      text-align: center
</style>
