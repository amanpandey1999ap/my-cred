package com.aman.mycred.ui.screens.landing

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.aman.domain.models.Credential
import com.aman.mycred.R
import com.aman.mycred.ui.reusableWidgets.CommonAppBar
import com.aman.mycred.ui.screens.landing.components.CredItemView

@Composable
fun HomeScreen(
  listOfCreds: List<Credential>,
  onAddClicked: () -> Unit
) {
  Box(modifier = Modifier.fillMaxSize()) {
    Column(modifier = Modifier
      .fillMaxSize()
      .background(MaterialTheme.colors.secondary)) {
      CommonAppBar(titleText = "Creds", canNavigateUp = false)

      // Body
      if (listOfCreds.isNotEmpty()) {
        LazyColumn {
          items(listOfCreds) { cred ->
            CredItemView(cred = cred)
          }
        }
      }
    }

    FloatingActionButton(
      modifier = Modifier
        .align(Alignment.BottomEnd)
        .padding(12.dp),
      onClick = { onAddClicked() },
      backgroundColor = MaterialTheme.colors.primary,
      contentColor = MaterialTheme.colors.onPrimary
    ) {
      Icon(
        imageVector = Icons.Default.Add,
        contentDescription = stringResource(id = R.string.cd_add_cred)
      )
    }
  }
}
