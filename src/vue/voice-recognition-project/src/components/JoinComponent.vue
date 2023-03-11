<template>
    <div id="JoinComponent" :class="{ blur: addressPopup.viewAddressPopup }">

        <h1>
            Join
        </h1>

        <div class="inputArea ">

            <dl>
                <dt>
                    <p>아이디</p>
                </dt>
                <dd>
                    <el-input v-model="joinRequest.memId" placeholder="아이디" />
                </dd>
            </dl>

            <dl>
                <dt>
                    <p>비밀번호</p>
                </dt>
                <dd>
                    <el-input v-model="joinRequest.pwd" type="password" placeholder="비밀번호" />
                </dd>
            </dl>

            <dl>
                <dt>
                    <p>비밀번호 확인</p>
                </dt>
                <dd>
                    <el-input v-model="joinRequest.pwdRe" type="password" placeholder="비밀번호 확인" />
                </dd>
            </dl>

            <dl>
                <dt>
                    <p>회원명</p>
                </dt>
                <dd>
                    <el-input v-model="joinRequest.name" placeholder="회원명" />
                </dd>
            </dl>

            <dl>
                <dt>
                    <p>이메일</p>
                </dt>
                <dd>
                    <el-input v-model="joinRequest.email" placeholder="이메일" />
                </dd>
            </dl>

            <dl>
                <dt>
                    <p>모바일</p>
                </dt>
                <dd>
                    <el-input v-model="joinRequest.mobile" placeholder="휴대폰 번호" />
                </dd>
            </dl>

            <dl>
                <dt>
                    <p>주소</p>
                </dt>
                <dd>
                    <el-input readonly class="addressInput" v-model="joinRequest.roadAddress" placeholder="도로명 주소">
                        <template #append>
                            <p @click="setAddressPs" id="addressbtn">
                                입력하기
                            </p>
                        </template>
                    </el-input>

                </dd>

            </dl>

            <dl>
                <dt>
                </dt>

                <dd>
                    <el-input placeholder="상세주소" v-model="joinRequest.detailAddress"></el-input>
                </dd>
            </dl>

            <dl>
                <dt>
                </dt>

                <dd>
                    <el-input readonly placeholder="주소" v-model="getAddress"></el-input>
                </dd>
            </dl>



            <div class="btnGroup">
                <el-button @click="joinPs" style="width: 100%;" type="primary">회원가입</el-button>
            </div>

        </div>



    </div>

    <div v-show="addressPopup.viewAddressPopup" id="addressPopupArea">

        <VueDaumPostcode @complete="onComplete" id="addressPopup" :options="options" />

    </div>
</template>

<script>
import { VueDaumPostcode } from 'vue-daum-postcode'

export default {
    name: "JoinComponent",
    components: {
        VueDaumPostcode: VueDaumPostcode
    },
    props: {
        /**
         * 회원가입 성공 시 콜백
         */
        joinScCallBack: {
            type: Function,
        },
        /**
         * 회원가입 실패 시 콜백
         */
        joinFaileCallBack: {
            type: Function,
        }
    },
    data() {
        return {
            joinRequest: {
                memId: "",
                pwd: "",
                pwdRe: "",
                name: "",
                email: "",
                mobile: "",
                address: "",
                zipCode: "",
                roadAddress: "",
                detailAddress: ""
            },
            addressPopup: {
                viewAddressPopup: false,
                result: ""

            }

        }
    },

    computed: {

        getAddress() {

            return `(${this.joinRequest.zipCode})${this.joinRequest.roadAddress} ${this.joinRequest.detailAddress}`
        }

    },

    watch: {
        getAddress: function (newValue) {
            this.joinRequest.address = newValue
        }
    },

    methods: {
        setAddressPs() {
            this.addressPopup.viewAddressPopup = true
        },
        onComplete(result) {
            console.log(result)

            this.joinRequest.roadAddress = result.address
            this.joinRequest.zipCode = result.zonecode

            this.addressPopup.viewAddressPopup = false
        },
        async joinPs() {
            let isSc = false
            await this.$axios().post(`${this.$store.state.serverIp}/user/join`, this.joinRequest)
                .then(function (resposne) {
                    console.log(resposne)
                    isSc = true
                })
                .catch(function (err) {
                    console.log(err)
                    isSc = false
                })

            if (isSc) {
                this.joinScCallBack ? this.joinFaileCallBack() : console.log("회원가입 성공(콜백처리 X)")
            } else {
                this.joinFaileCallBack ? this.joinFaileCallBack() : console.log("회원가입 실패(콜백처리 X)")
            }
        }
    },
}
</script>

<style scoped >
#JoinComponent {
    width: 100%;
    height: 100%;
    border: 1px solid black;
    background-color: white;
    padding: 20px;
    display: flex;

    flex-direction: column;
    justify-content: center;

}

#JoinComponent h1 {
    text-align: left;
    padding-left: 10px;
}

#JoinComponent .inputArea {}

#JoinComponent .inputArea dl {
    display: flex;
    align-items: center;
    margin-top: 20px;
    margin-bottom: 20px;

}



#JoinComponent .inputArea dl dt {
    width: 150px;
    text-align: left;
    padding-left: 20px;
    display: flex;
    justify-content: space-between;

}

#JoinComponent .inputArea dl dt::after {

    content: "";
    width: 4px;

    border-radius: 3px;
    background-color: rgb(219, 219, 219);

}

#JoinComponent .inputArea dl dd {
    padding-left: 20px;
    flex-grow: 1;
}

#addressPopupArea {
    position: absolute;
    width: 100%;
    height: 100%;
    top: 0;
    left: 0;

}

#addressPopup {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    border: 1px solid black;
    height: 60%;
    width: 35%;
    display: flex;
    flex-direction: column;


}

::v-deep #addressPopup>div {
    flex-grow: 1;
}

.blur {
    filter: blur(5px);
    -webkit-filter: blur(5px);
}
</style>