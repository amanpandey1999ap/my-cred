package com.aman.mycred.ui.screens.landing

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen() {
  Box(modifier = Modifier.fillMaxSize()) {
    Text(text = "Home Screen", modifier = Modifier.align(Alignment.TopCenter))
    FloatingActionButton(onClick = { /*TODO*/ }) { Text(text = "+")}
  }
}
