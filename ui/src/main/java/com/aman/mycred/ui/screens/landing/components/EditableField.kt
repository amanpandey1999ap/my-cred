package com.aman.mycred.ui.screens.landing.components

import android.view.KeyEvent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onPreviewKeyEvent
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@ExperimentalComposeUiApi
@Composable
@Suppress("LongParameterList")
fun EditableField(
  label: String,
  text: String,
  indicatorText: String = "",
  readOnly: Boolean = false,
  singleLine: Boolean = false,
  maxChar: Int = 50,
  imeAction: ImeAction = ImeAction.Next,
  keyboardType: KeyboardType = KeyboardType.Text,
  textStyle: TextStyle = LocalTextStyle.current,
  modifier: Modifier,
  onValueChange: (newValue: String) -> Unit,
  trailingIcon: @Composable (() -> Unit)? = null
) {
  val focusManager = LocalFocusManager.current

  Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
    OutlinedTextField(
      value = text,
      onValueChange = { newValue ->
        if (newValue.length < maxChar) {
          onValueChange(newValue)
        }
      },
      readOnly = readOnly,
      keyboardOptions = KeyboardOptions(
        keyboardType = keyboardType,
        imeAction = imeAction
      ),
      keyboardActions = KeyboardActions(
        onNext = { focusManager.moveFocus(FocusDirection.Down) },
        onDone = { focusManager.clearFocus() }
      ),
      label = { Text(text = label) },
      modifier = modifier
        .fillMaxWidth()
        .onPreviewKeyEvent {
          if (it.key == Key.Tab && it.nativeKeyEvent.action == KeyEvent.ACTION_DOWN) {
            focusManager.moveFocus(FocusDirection.Down)
            true
          } else {
            false
          }
        },
      singleLine = singleLine,
      textStyle = textStyle,
      trailingIcon = trailingIcon
    )
    if (indicatorText.isNotEmpty()) {
      Text(
        text = indicatorText,
        style = MaterialTheme.typography.caption,
        modifier = Modifier.padding(start = 16.dp)
      )
    }
  }
}
