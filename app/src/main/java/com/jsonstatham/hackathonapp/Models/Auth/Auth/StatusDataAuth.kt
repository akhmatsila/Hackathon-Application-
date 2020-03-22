package com.jsonstatham.hackathonapp.Models.Auth.Auth

class StatusDataAuth<T> (val data : T?, val message : String?, val status: Status)  {



    companion object{
        fun<T> onSigning() : StatusDataAuth<T> =
            StatusDataAuth(
                null,
                null,
                Status.SIGNING
            )
        fun<T> onLogout() : StatusDataAuth<T> =
            StatusDataAuth(
                null,
                null,
                Status.LOGOUT
            )
        fun<T> onLogin(data : T) : StatusDataAuth<T> =
            StatusDataAuth(
                data,
                null,
                Status.LOGIN
            )
        fun<T> onError(message : String) : StatusDataAuth<T> =
            StatusDataAuth(
                null,
                message,
                Status.ERROR
            )
    }

}

enum class Status {
    SIGNING,LOGOUT,LOGIN,ERROR
}