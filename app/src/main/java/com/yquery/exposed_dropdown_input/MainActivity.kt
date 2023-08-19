package com.yquery.exposed_dropdown_input

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.yquery.exposed_dropdown.ExposedDropdownMenu
import com.yquery.exposed_dropdown.rememberExposedDropdownValue
import com.yquery.exposed_dropdown_input.ui.theme.ExposedDropdownInputTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExposedDropdownInputTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val inputValue = rememberExposedDropdownValue()

                    ExposedDropdownMenu(
                        label = "Name",
                        text = inputValue.value,
                        onValueChange = {
                            inputValue.value = it
                        },
                        items = arrayListOf("Kotlin", "Java"),
                        isError = null
                    )
                }
            }
        }
    }
}
