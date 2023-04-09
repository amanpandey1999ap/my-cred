package com.aman.mycred.ui.reusableWidgets

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.aman.mycred.R

@Composable
fun CommonAppBar(
  titleText: String,
  canNavigateUp: Boolean,
  needSearch: Boolean = false,
  onSearchButtonClick: () -> Unit = {},
  onNavigationClick: () -> Unit = {}
) {
  TopAppBar(
    title = { Text(text = titleText) },
    backgroundColor = MaterialTheme.colors.primary,
    navigationIcon = getNavigationIcon(canNavigateUp, onNavigationClick),
    actions = {
      AddSearchAction(needSearch, onSearchButtonClick)
    }
  )
}

@Composable
private fun AddSearchAction(
  needSearch: Boolean,
  onSearchButtonClick: () -> Unit
) {
  if (needSearch) {
    IconButton(
      onClick = { onSearchButtonClick() }
    ) {
      Icon(
        imageVector = Icons.Default.Search,
        contentDescription = stringResource(id = R.string.desc_search_icon),
        tint = Color.White
      )
    }
  }
}

private fun getNavigationIcon(
  canNavigateUp: Boolean,
  onBackButtonClick: () -> Unit
): @Composable (() -> Unit)? {
  return if (canNavigateUp) {
    @Composable {
      IconButton(onClick = { onBackButtonClick() }) {
        Icon(
          imageVector = Icons.Default.ArrowBack,
          contentDescription = stringResource(id = R.string.back)
        )
      }
    }
  } else null
}
