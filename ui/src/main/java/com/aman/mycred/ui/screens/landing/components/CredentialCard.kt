package com.aman.mycred.ui.screens.landing.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aman.domain.models.Credential

@Composable
fun CredentialCard(cred: Credential) {
  Card {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp),
      horizontalArrangement = Arrangement.SpaceEvenly,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Text(text = "#${cred.id}")
      Column {
        Text(text = cred.type)
        Text(text = cred.userId)
      }
    }
  }
}

@Preview
@Composable
fun CredentialCardPreview() {
  CredentialCard(
    Credential(
      id = 1,
      type = "email",
      userId = "abc@abc.com",
      password = "1234"
      )
  )
}
