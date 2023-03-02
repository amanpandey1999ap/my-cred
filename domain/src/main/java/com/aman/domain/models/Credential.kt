package com.aman.domain.models

data class Credential(
  val id: Int,
  val type: String,
  val userId: String,
  val password: String
)
