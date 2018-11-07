<template>
  <div>
    <Toolbar/>
  <v-content>
    <v-container v-for="(item,i) in products"
      :key="i">
      <v-hover>
        <v-card
      slot-scope="{ hover }"
      :class="`elevation-${hover ? 12 : 2}`"
      class="mx-auto"
      width="344"
    >
    <v-img
        :aspect-ratio="16/9"
        src="https://www.bigc.co.th/media/catalog/product/cache/1/image/497x497/9df78eab33525d08d6e5fb8d27136e95/8/8/8858862801288.jpg"
      ></v-img>
      <v-card-title>
        <div>
          <h3 class="headline mb-0">{{item.name}}</h3>
          <span class="">{{item.detail}}</span>
        </div>
        <v-spacer></v-spacer>
        <v-card-actions>
                  <v-spacer></v-spacer>
                  <v-btn icon>
                    <v-icon>shopping_cart</v-icon>
                  </v-btn>
        </v-card-actions>
      </v-card-title>
</v-card>
      </v-hover>
    </v-container>
  </v-content>
  </div>
</template>

<script>
import axios from "axios";
import Toolbar from "../components/Toolbar";
import { mapGetters } from 'vuex'

export default {
  name: "Home",
  components: {
    Toolbar
  },
  data() {
    return{
      products:'',
      user:''
    }
  },
  computed: {
    ...mapGetters(['getUser'])
  },
  methods: {
    async getProduct() {
      await axios
        .get(process.env.VUE_APP_PRODUCT_SERVICE_URL + "/products")
        .then(response => (this.products = response.data));
        console.log(this.products)
    }
  },
  mounted() {
    this.getProduct();
  }
};
</script>