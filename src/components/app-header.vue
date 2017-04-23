<template>
  <div class="header">
    <router-link class="logo" to="/">
      <image class="image" src="https://news.ycombinator.com/favicon.ico"></image>
    </router-link>
    <div class="nav">
      <router-link to="/top" tag="li">
        <a class="link-header"><text class="title">Top</text></a>
      </router-link>
      <router-link to="/new" tag="li">
        <a class="link-header"><text class="title">New</text></a>
      </router-link>
      <router-link to="/show" tag="li">
        <a class="link-header"><text class="title">Show</text></a>
      </router-link>
      <router-link to="/ask" tag="li">
        <a class="link-header"><text class="title">Ask</text></a>
      </router-link>
      <router-link to="/job" tag="li">
        <a class="link-header"><text class="title">Job</text></a>
      </router-link>
    </div>
  </div>
</template>

<style scoped>
  .header {
    position: relative;
    height: 120px;
    margin-bottom: 3px;
    border-bottom-width: 2px;
    border-bottom-style: solid;
    border-bottom-color: #DDDDDD;
    background-color: #FF6600;
  }
  .logo {
    position: relative;
    width: 50px;
    height: 50px;
    top: 35px;
    left: 35px;
    border-width: 3px;
    border-style: solid;
    border-color: #FFFFFF;
  }
  .image {
    width: 44px;
    height: 44px;
  }
  .nav {
    display: flex;
    position: absolute;
    left: 120px;
    top: 35px;
    flex-direction: row;
    flex-wrap: nowrap;
    justify-content: center;
    align-items: center;
  }
  .link-header {
    padding: 0 15px;
  }
  .title {
    font-family: Verdana, Geneva, sans-serif;
    font-size: 32px;
    line-height: 44px;
    color: #FFFFFF;
  }
</style>
