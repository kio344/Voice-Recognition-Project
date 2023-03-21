<template>
  <div class="background">

    <div id="JoinArea">


      <LoginPopupComponent :loginFaileCallBack="this.loginFaile" :loginScCallBack="this.loginSc"  ></LoginPopupComponent>

      <!-- <LoginComponent v-if="true"   ></LoginComponent> -->
      <!-- <JoinComponent v-if="false"></JoinComponent> -->


    </div>
    
    <button @click="loginTest" >서버 정보 확인</button>

    <button @click="logout" >로그아웃(로그인 정보 삭제)</button>


  </div>
</template>

<script>
import LoginPopupComponentVue from '@/components/LoginPopupComponent.vue'
export default {

  name: "ComponentTest",
  data() {
    return {
      dialogVisible:false
    }
  },
  components: {
    LoginPopupComponent:LoginPopupComponentVue
  },
  methods: {

    loginSc() {
      let loginData = this.$store.state.loginUser
      let loginToken =this.$store.state.loginToken
      console.log(loginData.userId)
      console.log(loginData.memId)
      console.log(loginData.name)
      console.log(loginToken)
    },

    loginFaile() {
      console.log("faile")
    },

    loginTest() {
      console.log("테스트")

      this.$axios().post(`${this.$store.state.serverIp}/test`, this.joinRequest)
        .then(function (response) {
          console.log(response)
        })
    },

    logout() {

      console.log("로그아웃")

      this.$store.dispatch("UserStore/logout")

    }

  }


}
</script>

<style scoped>
.background {
  height: 100%;
  background-color: #e4e4e4;
  display: flex;
  justify-content: center;
  align-items: center;
}

#loginArea {
  width: 20%;
  height: 30%;
}

#JoinArea {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 50%;
  height: 60%;
}
</style>