<template>
  <div class="background" >

    <div id="JoinArea"  >

      <LoginComponent v-show="false" ></LoginComponent>
      <JoinComponent v-show="true"></JoinComponent>
    </div>

  </div>

</template>

<script>
import LoginComponent from '@/components/LoginComponent.vue';
import JoinComponent from '@/components/JoinComponent.vue';
export default {

  name: "ComponentTest",
    data() {
      return {
        
      }
    },
  components: {
    LoginComponent: LoginComponent,
    JoinComponent:JoinComponent
  },
  methods: {

    
  }


}
</script>

<style scoped>

    .background{
        height: 100%;
        background-color: #e4e4e4;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    #loginArea{
      width: 20%;
      height: 30%;
    }
    #JoinArea{
      display: flex;
      justify-content: center;
      align-items: center;
      width: 50%;
      height: 60%;
    }

</style>