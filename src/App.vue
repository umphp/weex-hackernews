<template>
    <div @androidback="back">
        <router-view style="flex:1"></router-view>
    </div>
</template>

<script>
  export default {
    methods: {
      back () {
        this.$router.back()
      }
    }
  }
</script>