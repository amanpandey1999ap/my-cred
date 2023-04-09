package com.aman.mycred.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.aman.mycred.ui.screens.landing.AddCredentialScreen
import com.aman.mycred.ui.screens.landing.EmptyScreen
import com.aman.mycred.ui.screens.landing.HomeScreen
import com.aman.mycred.ui.screens.landing.LoadingScreen
import com.aman.mycred.ui.theme.MyCredTheme
import com.aman.mycred.utils.showToastMessage
import com.aman.mycred.viewmodels.HomeViewModel
import com.aman.mycred.viewmodels.HomeViewModel.ViewCommand
import com.aman.mycred.viewmodels.HomeViewModel.ViewCommand.ShowToastMessage
import com.aman.mycred.viewmodels.HomeViewModel.ViewState.Loading
import com.aman.mycred.viewmodels.HomeViewModel.ViewState.ShowAddCredentialScreen
import com.aman.mycred.viewmodels.HomeViewModel.ViewState.ShowHomeScreen
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : ComponentActivity() {
  private val homeVM: HomeViewModel by viewModel()
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    initObservers()
    homeVM.initiate()
    setContent {
      MyCredTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
          homeVM.viewState.observeAsState().value?.BuildUI()
        }
      }
    }
  }

  private fun initObservers() {
    homeVM.viewCommand.observe(this, ::handleCommand)
  }

  private fun handleCommand(command: ViewCommand) {
    when (command) {
      is ShowToastMessage -> this.showToastMessage(getString(command.resId))
    }
  }

  @Composable fun HomeViewModel.ViewState.BuildUI() {
    when (this) {
      is ShowHomeScreen -> HomeScreen(
        listOfCreds = homeVM.fetchCreds(),
        onAddClicked = homeVM::showAddCredentialScreen
      )
      is ShowAddCredentialScreen -> AddCredentialScreen(
        onBackPressed = homeVM::showCredsScreen,
        onSaveClicked = homeVM::onSave
      )
      is Loading -> LoadingScreen()
      else -> EmptyScreen()
    }
  }
}
