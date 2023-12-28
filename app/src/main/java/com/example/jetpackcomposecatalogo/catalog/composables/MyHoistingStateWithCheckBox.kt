package com.example.jetpackcomposecatalogo.catalog.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// ****************************** simple checkbox ****************************************
@Composable
fun CheckBoxSimpleExample() {
    var state by rememberSaveable { mutableStateOf(false) }
    Column() {
        Text("Checkbox simple example")
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = state,
                onCheckedChange = { state = !state },
                colors = CheckboxDefaults.colors(
                    checkmarkColor = Color.Red,
                )
            )
            Text(modifier = Modifier.clickable { state = !state }, text = "Blue")

        }
    }
}

// ****************************** tristate checkbox ****************************************
@Composable
fun TristateCheckBoxSimpleExample() {
    var state by rememberSaveable { mutableStateOf(ToggleableState.Off) }
    Column() {
        Text(
            "Tri state check boxes", style = TextStyle(

                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                fontSize = 16.sp,
                textDecoration = TextDecoration.combine(listOf(TextDecoration.Underline))
            )
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            TriStateCheckbox(state = state, onClick = {
                state = when (state) {
                    ToggleableState.On -> ToggleableState.Off
                    ToggleableState.Off -> ToggleableState.Indeterminate
                    ToggleableState.Indeterminate -> ToggleableState.On
                }
            })
            Text(text = "Tristate checkbox")
        }
    }
}

// ****************************** list of checkboxes ****************************************

data class CheckInfo(
    val title: String,
    var selected: Boolean = false,
    var onCheckedChange: (Boolean) -> Unit,
)

@Composable
fun CheckBoxWithText(checkInfo: CheckInfo) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = checkInfo.selected,
            onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) })
        Text(checkInfo.title)
    }
}

@Composable
fun MyHoistingStateWithCheckBox() {
    var result by remember {
        mutableStateOf("There is no result yet")
    }

    Column() {
        Text(
            "Hoisting state with check boxes", style = TextStyle(
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                fontSize = 16.sp,
                textDecoration = TextDecoration.combine(listOf(TextDecoration.Underline))
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text("What colors do you like?")

        val colorList = getOptions(colors = listOf("Black", "white", "green", "purple"))

        colorList.forEach {
            CheckBoxWithText(checkInfo = it)
        }

        Button(onClick = {
            result = ""
            colorList.forEach {
                if (it.selected)
                    result += " ${it.title}"
            }
        }) {
            Text("check options")
        }
        Text(text = result)
    }
}

@Composable
fun getOptions(colors: List<String>): List<CheckInfo> {
    return colors.map {
        var status by rememberSaveable { mutableStateOf(false) }
        CheckInfo(
            it,
            selected = status,
            onCheckedChange = { status = it }
        )
    }
}
