package com.aman.data.repository

import android.util.Log
import com.aman.data.mappers.toCredential
import com.aman.data.mappers.toDCredential
import com.aman.data.sources.local.CredentialsDao
import com.aman.domain.models.Credential
import com.aman.domain.repository.CredRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CredRepositoryImpl(
  private val credentialsDao: CredentialsDao
) : CredRepository {

  override suspend fun createCred(cred: Credential): Boolean {
    return try {
      credentialsDao.createCred(cred.toDCredential())
      true
    } catch (e: Exception) {
      Log.d(TAG, "createCred: ${e.localizedMessage}")
      false
    }
  }

  override suspend fun readCreds(): Flow<List<Credential>> {
    return credentialsDao.readCreds().map { listOfDCreds ->
      listOfDCreds.map { dCred ->
        dCred.toCredential()
      }
    }
  }

  override suspend fun updateCred(cred: Credential): Boolean {
    return try {
      credentialsDao.updateCred(cred.toDCredential())
      true
    } catch (e: Exception) {
      Log.d(TAG, "updateCred: ${e.localizedMessage}")
      false
    }
  }

  override suspend fun deleteCred(credId: Int): Boolean {
    return try {
      credentialsDao.deleteCred(credId)
      true
    } catch (e: Exception) {
      Log.d(TAG, "deleteCred: ${e.localizedMessage}")
      false
    }
  }

  companion object {
    const val TAG = "DataModule"
  }
}
