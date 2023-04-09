package com.aman.mycred.ui.screens.landing.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aman.domain.models.Credential

@Composable
fun CredItemView(cred: Credential) {
  Card(
    modifier = Modifier
      .padding(10.dp)
      .fillMaxWidth()
      .wrapContentHeight(),
    shape = MaterialTheme.shapes.medium,
    elevation = 5.dp,
    backgroundColor = MaterialTheme.colors.surface
  ) {
    Column {
      Text(text = "User ID = ${cred.userId}", modifier = Modifier.padding(4.dp))
      Text(text = "Password = ${cred.password}", modifier = Modifier.padding(4.dp))
    }
  }
}
