package com.aman.mycred.ui.screens.landing

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun EmptyScreen() {
  Column(Modifier.fillMaxSize()) {
    Text(text = "Empty Screen")
  }
}
