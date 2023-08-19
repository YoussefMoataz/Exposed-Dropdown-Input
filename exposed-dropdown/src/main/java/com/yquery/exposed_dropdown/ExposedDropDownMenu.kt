package com.yquery.exposed_dropdown

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExposedDropdownMenu(
    label: String,
    text: String,
    onValueChange: (String) -> Unit,
    items: ArrayList<String>,
    isError: Boolean? = null,
    supportingText: (@Composable () -> Unit)? = null
) {

    var expanded by remember { mutableStateOf(false) }

    Box {
        ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = { expanded = !expanded }) {

            OutlinedTextField(
                modifier = Modifier.menuAnchor(),
                readOnly = true,
                value = text,
                onValueChange = {
                    onValueChange(it)
                },
                label = { Text(text = label) },
                singleLine = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                isError = isError ?: false,
                supportingText = supportingText
            )

            ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {

                items.forEach {
                    DropdownMenuItem(
                        text = { Text(text = it) },
                        onClick = {
                            onValueChange(it)
                            expanded = false
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                    )
                }

            }

        }
    }

}

@Composable
fun rememberExposedDropdownValue(): MutableState<String> {
    return rememberSaveable {
        mutableStateOf("")
    }
}