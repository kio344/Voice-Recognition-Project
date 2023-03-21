<template>
    <div id="loginComponent">
        <h1 @click="localStorageClear">
            Login<span v-show="joinSc" style="font-size: 14px;margin-left: 10px;color: green;" >회원가입 성공</span>
            <i v-show="loading == 'loading'" class="xi-spinner-3 xi-spin"></i>
            <span style="color: red;font-size: 14px;margin-left: 10px;" v-show="loading == 'faile'" >로그인 실패</span>
        </h1>
        <div class="inputGroup">

            <el-input v-model="loginData.memId" placeholder="Please input" />
            <el-input v-model="loginData.pwd" type="password" placeholder="Please input password" show-password />

        </div>

        <div class="btnGroup">

            <el-button @click="()=>{dialogVisible = true;joinSc=false}" type="primary">Join</el-button>
            <el-button @click="loginPs" type="success">Login</el-button>

        </div>

        <el-dialog v-model="dialogVisible"  width="30%">
            
            <JoinComponent :joinScCallBack="this.joinPopupScClose"  ></JoinComponent>

            
        </el-dialog>

    </div>
</template>

<script>
import JoinComponentVue from './JoinComponent.vue'

export default {

    data() {
        return {
            loginData: {
                memId: "",
                pwd: ""
            },
            loginToken: localStorage.getItem("loginToken"),
            loading: "",
            dialogVisible: false,
            joinSc:false

        }
    },
    components: {
        JoinComponent:JoinComponentVue
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


    methods: {


        joinPopupScClose() {
            console.log("회원가입 팝업 닫기")
            this.dialogVisible = false
            this.joinSc=true
        }

        ,async loginPs() {

            this.loading = 'loading'

            let isSc
            let state

            await this.$store.dispatch('UserStore/login', this.loginData)
                .then(function (isSuccess) {
                    console.log(isSuccess)

                    state = "sc"
                    isSc = true

                }).catch(function (isSuccess) {
                    console.log(isSuccess)

                    state = "faile"
                    isSc = false
                })

            this.loading = state


            isSc ? (this.loginScCallBack ? this.loginScCallBack() : console.log("로그인 성공 (콜백 x)")) : (this.loginFaileCallBack ? this.loginFaileCallBack() : console.log("로그인 실패 (콜백 x)"))





        },

        localStorageClear() {
            localStorage.removeItem('loginToken')
            this.$store.state.loginToken = null
            this.$store.state.loginData = null
            console.log("clear")
        }
    }

}
</script>

<style scope >
#loginComponent {

    /* border: 1px solid rgb(183, 183, 183); */
    border-radius: 4px;
    background-color: white;
    padding: 20px;
    width: 100%;
    height: 100%;

    display: flex;
    flex-direction: column;
    justify-content: center;

}

#loginComponent h1 {
    margin-top: 8px;
    margin-bottom: 8px;
    text-align: left;
    padding-left: 5px;
}

#loginComponent .inputGroup {

    margin: 5px;

}

#loginComponent .inputGroup .el-input {}

#loginComponent .inputGroup .el-input:nth-child(2) {

    margin-top: 10px;

}


#loginComponent .btnGroup {
    margin: 5px;

    display: flex;
    justify-content: end;

}
</style>