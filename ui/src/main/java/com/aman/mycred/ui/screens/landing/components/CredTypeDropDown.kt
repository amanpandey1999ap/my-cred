package com.aman.mycred.ui.screens.landing.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.aman.mycred.R.string

@OptIn(ExperimentalMaterialApi::class, ExperimentalComposeUiApi::class)
@Composable
fun CredTypeDropDown(
  selectedType: CredType,
  setSelected: (selected: CredType) -> Unit
) {
  val dropDownOptions = CredType.values().toList()
  var selectedText by remember { mutableStateOf(selectedType.label) }
  var expanded by remember { mutableStateOf(false) }
  ExposedDropdownMenuBox(
    expanded = expanded,
    onExpandedChange = { expanded = !expanded }
  ) {
    EditableField(
      label = stringResource(id = string.label_select_cred_type),
      text = selectedText,
      readOnly = true,
      modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
      onValueChange = {},
      trailingIcon = {
        ExposedDropdownMenuDefaults.TrailingIcon(
          expanded = expanded
        )
      },
    )
    ExposedDropdownMenu(
      expanded = expanded,
      onDismissRequest = {
        expanded = false
      }
    ) {
      dropDownOptions.forEach { selectionOption ->
        DropdownMenuItem(
          onClick = {
            selectedText = selectionOption.label
            expanded = false
            setSelected(selectionOption)
          }
        ){
          Text(text = selectionOption.label)
        }
      }
    }
  }
}

enum class CredType(val label: String = "User ID") {
  EMAIL("Email"),
  USERID("User ID"),
  PHONE("Phone"),
  OTHER("Other")
}
