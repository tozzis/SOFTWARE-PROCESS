<template>
<v-card>
<v-bottom-nav
      :active.sync="menu"
      :value="true"
      absolute
      color="transparent"
      shift
      fixed app
    >
      <v-btn value="/" color="deep-orange darken-2" flat to="/">
        <span>หน้าเเรก</span>
        <v-icon>home</v-icon>
      </v-btn>

      <v-btn value="/search" color="deep-orange darken-2" flat>
        <span>หมวดหมู่</span>
        <v-icon>search</v-icon>
      </v-btn>

      <v-btn value="/cart" color="deep-orange darken-2" flat>
        <span>รถเข็น</span>
        <v-icon>shopping_cart</v-icon>
      </v-btn>

      <v-btn value="/login" color="deep-orange darken-2" flat to="/login">
        <span>ผู้ใช้</span>
        <v-icon>account_circle</v-icon>
      </v-btn>
</v-bottom-nav>
</v-card>
</template>
<script>
export default {
  data() {
    return {
      menu: ''
    };
  },
  methods:{
    
  }
};
</script>