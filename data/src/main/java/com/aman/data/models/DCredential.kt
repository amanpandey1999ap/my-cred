package com.aman.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cred_table")
data class DCredential(
  @PrimaryKey(autoGenerate = true)
  val id: Int = 0,
  val type: String,
  val userId: String,
  val password: String
)

/*
 DCredential data_class in Data module
 & Credential data_class in Domain module
 can have different parameters.
*/
