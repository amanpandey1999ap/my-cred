package com.aman.mycred.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aman.domain.models.CredUseCases
import com.aman.domain.models.Credential
import com.aman.mycred.models.ResponseState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LandingScreenVM(
  private val credUseCases: CredUseCases
) : ViewModel() {

  var credsState: ResponseState<List<Credential>> by mutableStateOf(ResponseState.Empty)
    private set

  init {
    fetchCredsFromDb()
  }

  private fun fetchCredsFromDb() {
    viewModelScope.launch(Dispatchers.IO) {
      credsState = ResponseState.Loading
      credUseCases.readCredsUseCase().collect { listOfCreds ->
        credsState = if (listOfCreds.isNotEmpty()) {
          ResponseState.Success(data = listOfCreds)
        } else {
          ResponseState.Failure(reason = "The database is empty!")
        }
      }
    }
  }

  // fun insertCredIntoDb(cred: Credential) {
  //   viewModelScope.launch() {
  //   }
  // }

}
