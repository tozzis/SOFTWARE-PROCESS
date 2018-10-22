<template>
  <div class="hello">
    <h1 class="text-center">{{ msg }}</h1>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: 'HelloWorld',
  data () {
    return {
      msg: ''
    }
  },
    async created() {
    const { data } = await axios.get("http://localhost:1234/hello/1");
    this.msg = data.text;
  }
}
</script>
