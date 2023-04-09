package com.aman.mycred.ui.screens.landing

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.aman.domain.models.Credential
import com.aman.mycred.R.string
import com.aman.mycred.ui.reusableWidgets.CommonAppBar
import com.aman.mycred.ui.screens.landing.components.CredType
import com.aman.mycred.ui.screens.landing.components.CredTypeDropDown
import com.aman.mycred.ui.screens.landing.components.EditableField

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun AddCredentialScreen(
  onBackPressed: () -> Unit,
  onSaveClicked: (cred: Credential) -> Unit
) {
  var credType by remember { mutableStateOf(CredType.USERID) }
  var userId by remember { mutableStateOf("") }
  var userIdLabel by remember { mutableStateOf("Enter User ID") }
  var password by remember { mutableStateOf("") }

  BackHandler { onBackPressed() }
  Column(
    verticalArrangement = Arrangement.SpaceBetween,
    modifier = Modifier
      .fillMaxSize()
      .background(MaterialTheme.colors.secondary)
  ) {
    // Top Bar
    CommonAppBar(
      titleText = "Add Cred",
      canNavigateUp = true,
      onNavigationClick = onBackPressed
    )

    // Body
    Column(Modifier.padding(horizontal = 8.dp)) {
      CredTypeDropDown(
        selectedType = credType
      ) { selected ->
        credType = selected
      }
      EditableField(
        label = userIdLabel,
        text = userId,
        modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
        onValueChange = { newValue ->
          userId = newValue
        }
      )
      EditableField(
        label = stringResource(id = string.label_password),
        text = password,
        imeAction = ImeAction.Done,
        modifier = Modifier.fillMaxWidth(),
        onValueChange = { newValue ->
          password = newValue
        }
      )
    }

    // CTA Section
    Button(
      modifier = Modifier
        .fillMaxWidth()
        .padding(12.dp),
      shape = RoundedCornerShape(8.dp),
      onClick = {
        onSaveClicked(
          Credential(
            type = credType.label,
            userId = userId,
            password = password
          )
        )
      }
    ) {
      Text(text = stringResource(id = string.label_save))
    }
  }
}
