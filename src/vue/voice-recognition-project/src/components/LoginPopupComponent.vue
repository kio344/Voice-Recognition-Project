<template>
    <el-button @click="loginPopupVisible = true" type="primary">로그인/회원가입</el-button>
    <el-dialog align-center="true" width="25%" v-model="loginPopupVisible">
        <LoginComponent :loginScCallBack="this.loginScCallBack" :loginFaileCallBack="this.loginFaileCallBack"  ></LoginComponent>
    </el-dialog>
</template>

<script>
import LoginComponentVue from './LoginComponent.vue'
export default {
    components: {
        LoginComponent: LoginComponentVue
    },
    props: {

        /**
         * 로그인 성공 시 콜백
         */
        loginScCallBack: {
            type: Function
        },
        /**
         * 로그인 실패 시 콜백
         */
        loginFaileCallBack: {
            type: Function
        }

    },
    data() {
        return {
            loginPopupVisible: false

        }
    },
    methods: {


    }
}
</script>

<style scoped ></style>