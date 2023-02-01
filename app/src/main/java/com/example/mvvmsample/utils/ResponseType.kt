package com.example.mvvmsample.utils

sealed class ResponseType {
    data class Response(val response: Any): ResponseType()
    data class Error(val message: String, val code: String?=""): ResponseType()
    data class ErrorCode(val code: Int): ResponseType()
}