package com.aman.mycred.models

sealed class ResponseState <out T> {
  object Empty: ResponseState<Nothing>()
  object Loading: ResponseState<Nothing>()
  class Success<out T>(val data: T): ResponseState<T>()
  class Failure(val reason: String): ResponseState<Nothing>()
}
