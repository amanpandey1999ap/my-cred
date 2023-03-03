package com.aman.domain.models

data class Credential(
  val id: Int = 0,
  val type: String,
  val userId: String,
  val password: String
)
