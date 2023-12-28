package com.example.jetpackcomposecatalogo.catalog.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyRadioButtonExample() {
    var selectedOption by rememberSaveable { mutableStateOf("blue") }
    var result by rememberSaveable { mutableStateOf(selectedOption) }
    Column (modifier = Modifier.padding(8.dp)) {
        Text(
            "Radio button example, select one color", style = TextStyle(
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                fontSize = 16.sp,
                textDecoration = TextDecoration.combine(listOf(TextDecoration.Underline))
            )
        )
        MyRadioButton(title = "blue", selected = selectedOption, onItemSelected = { selectedOption = "blue"})
        MyRadioButton(title = "yellow", selected = selectedOption, onItemSelected = { selectedOption = "yellow"})
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            result = "selected option is $selectedOption"
        }) {
            Text("Discover what option is selected ")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = result)
    }
}

@Composable
fun MyRadioButton(title: String, selected: String, onItemSelected: (String) -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        RadioButton(selected = (title == selected), onClick = { onItemSelected(title) })
        Text(modifier = Modifier.padding(start = 8.dp), text = title)
    }
}