package com.aman.data.sources.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aman.data.models.DCredential

@Database(
  entities = [DCredential::class],
  version = 1
)
abstract class CredDatabase: RoomDatabase() {
  abstract fun getCredentialsDao(): CredentialsDao
}
