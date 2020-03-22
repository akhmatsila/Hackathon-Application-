package com.jsonstatham.hackathonapp.Models.Auth.Registration

class StatusDataReg<T> (val data : T?, val message : String?, val status: Status)  {



    companion object{
        fun<T> onRegistrating() : StatusDataReg<T> =
            StatusDataReg(
                null,
                null,
                Status.REGISTRATION
            )

        fun<T> onRegistrated(data : T) : StatusDataReg<T> =
            StatusDataReg(
                data,
                null,
                Status.REGISTRED
            )
        fun<T> onError(message : String) : StatusDataReg<T> =
            StatusDataReg(
                null,
                message,
                Status.ERROR
            )
        fun<T> onDuplicate(message : String) : StatusDataReg<T> =
            StatusDataReg(
                null,
                message,
                Status.DUPLICATE
            )
    }

}

enum class Status {
    REGISTRATION,ERROR,DUPLICATE,REGISTRED
}