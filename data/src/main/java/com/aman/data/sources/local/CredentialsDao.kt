package com.aman.data.sources.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.aman.data.models.DCredential
import kotlinx.coroutines.flow.Flow

@Dao
interface CredentialsDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun createCred(dCred: DCredential)

  @Query(value = "SELECT * FROM cred_table")
  fun readCreds(): Flow<List<DCredential>>

  @Update
  fun updateCred(dCred: DCredential)

  @Query(value = "DELETE from cred_table WHERE :credId = id")
  fun deleteCred(credId: Int)

}
