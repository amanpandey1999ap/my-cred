package com.aman.domain.repository

import com.aman.domain.models.Credential
import kotlinx.coroutines.flow.Flow

interface CredRepository {
  suspend fun createCred(cred: Credential): Boolean
  suspend fun readCreds(): Flow<List<Credential>>
  suspend fun updateCred(cred: Credential): Boolean
  suspend fun deleteCred(credId: Int): Boolean
}
