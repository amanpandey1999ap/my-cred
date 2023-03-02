package com.aman.domain.repository

import com.aman.domain.models.Credential

interface CredRepository {
  suspend fun createCred(cred: Credential): Boolean
  suspend fun readCreds(): List<Credential>
  suspend fun updateCred(cred: Credential): Boolean
  suspend fun deleteCred(credId: Int): Boolean
}
