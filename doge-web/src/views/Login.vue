<template>
  <div id="app">
    <v-app id="background">
        <v-content>
        <v-container fluid fill-height>
            <v-layout align-center justify-center>
            <v-flex xs12 sm8 md4>
                <div class="text-xs-center">
                <img src="https://i.kym-cdn.com/entries/icons/original/000/013/564/doge.jpg" class="circle"/>
                </div>
                <v-card-text>
                    <v-form>
                        <v-text-field prepend-icon="person" name="login" label="Login" type="text" v-model="username"></v-text-field>
                        <v-text-field prepend-icon="lock" name="password" label="Password" id="password" type="password" v-model="password"></v-text-field>
                        <div class="text-xs-center">
                        <v-btn color="orange" dark @click="login()">Sign in</v-btn>
                        <v-btn color="indigo darken-4" dark>Facebook</v-btn>
                        <h1>{{test}}</h1>
                        </div>
                    </v-form>
                </v-card-text>
            </v-flex>
            </v-layout>
        </v-container>
        </v-content>
    </v-app>
</div>
</template>
<script>
import axios from 'axios'
import { mapActions,mapGetters } from 'vuex'

export default {
  components: {},
  data() {
    return {
      username: "",
      password: "",
      test:""
    };
  },
  computed: {
    ...mapGetters(['getUser'])
  },
  methods:{
    ...mapActions(['setUsername']),
    login(){
      const data = axios
        .post("http://localhost:1234/users/signin", {
          username: this.username,
          password: this.password
        })
        .then(function(response) {
          console.log(response.data)
          if(response.data==='Sign in success'){
            console.log('******************')
          }
        })
        .catch(function(response) {
          alert("มีบางอย่าง error !!!");
        });
    }
  }
};
</script>
<style>
.circle {
  height: 200px;
  width: 220px;
  border-radius: 50%;
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
}
#background {
      background-image: url('');
      background-size: 150%
}
</style>