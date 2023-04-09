package com.aman.mycred.viewmodels

import androidx.annotation.StringRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aman.domain.models.CredUseCases
import com.aman.domain.models.Credential
import com.aman.mycred.R
import com.aman.mycred.models.ResponseState
import com.aman.mycred.viewmodels.HomeViewModel.ViewState.Init
import com.aman.mycred.viewmodels.HomeViewModel.ViewState.StateHolder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class HomeViewModel(
  private val credUseCases: CredUseCases
) : ViewModel() {

  private val _viewState: MutableLiveData<ViewState> =
    MutableLiveData<ViewState>(Init(StateHolder()))
  val viewState: LiveData<ViewState> = _viewState

  private val currStateHolder: StateHolder
    get() = _viewState.value?.stateHolder ?: StateHolder()

  private val _viewCommand = MutableLiveData<ViewCommand>()
  val viewCommand: LiveData<ViewCommand> = _viewCommand

  private fun executeInScope(coroutineScope: suspend CoroutineScope.() -> Unit) =
    viewModelScope.launch {
      coroutineScope(this)
    }

  fun initiate() {
    _viewState.value = ViewState.Loading(currStateHolder)
    fetchCredsFromDb()
  }

  fun showCredsScreen() {
    _viewState.postValue(ViewState.ShowHomeScreen(currStateHolder))
  }
  fun showAddCredentialScreen() {
    _viewState.postValue(ViewState.ShowAddCredentialScreen(currStateHolder))
  }

  fun fetchCreds(): List<Credential> {
    return currStateHolder.listOfCreds
  }

  private fun fetchCredsFromDb() {
    executeInScope {
      credUseCases.readCredsUseCase().collect { listOfCreds ->
        if (listOfCreds.isNotEmpty()) {
          _viewState.value = ViewState.ShowHomeScreen(
            currStateHolder.copy(
              credState = ResponseState.Success(data = listOfCreds),
              listOfCreds = listOfCreds
            )
          )
        } else {
          _viewState.value = ViewState.ShowAddCredentialScreen(
            currStateHolder.copy(
              credState = ResponseState.Failure(reason = "The database is empty!")
            )
          )
          _viewCommand.value = ViewCommand.ShowToastMessage(R.string.message_empty_data_set)
        }
      }
    }
  }

  fun onSave(cred: Credential) {
    executeInScope {
      _viewState.value = ViewState.Loading(currStateHolder)
      credUseCases.createCredUseCase(cred)
      fetchCredsFromDb()
    }
  }

  sealed class ViewState {
    abstract val stateHolder: StateHolder

    data class Init(override val stateHolder: StateHolder) : ViewState()
    data class Loading(override val stateHolder: StateHolder) : ViewState()
    data class ShowHomeScreen(override val stateHolder: StateHolder) : ViewState()
    data class ShowAddCredentialScreen(override val stateHolder: StateHolder) : ViewState()

    data class StateHolder(
      val credState: ResponseState<List<Credential>> = ResponseState.Empty,
      val listOfCreds: List<Credential> = emptyList()
    )
  }

  sealed class ViewCommand {
    class ShowToastMessage(@StringRes val resId: Int) : ViewCommand()
  }
}
