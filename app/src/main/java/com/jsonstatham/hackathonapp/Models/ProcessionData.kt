package com.jsonstatham.hackathonapp.Models

class ProcessionData<T>(val data: T?, val message: String?, val status: Status) {


    companion object {
        fun <T> onEvaluating(): ProcessionData<T> =
            ProcessionData(
                null,
                null,
                Status.EVALUATING
            )

        fun <T> onEvaluated(data: T): ProcessionData<T> =
            ProcessionData(
                data,
                null,
                Status.EVALUATED
            )

        fun <T> onError(message: String): ProcessionData<T> =
            ProcessionData(
                null,
                message,
                Status.ERROR
            )

        fun <T> onNothing(): ProcessionData<T> =
            ProcessionData(
                null, null,
                Status.NOTHING
            )
    }

}

enum class Status {
    EVALUATING, NOTHING, ERROR, EVALUATED
}