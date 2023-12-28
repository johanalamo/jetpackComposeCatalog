package com.example.jetpackcomposecatalogo.catalog.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.util.toRange

@Composable
fun MySliderExample(){
    var sliderPosition by remember { mutableStateOf(0f) }
    Column(modifier = Modifier.padding(20.dp)) {
        Text(
            "Slider", style = TextStyle(
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                fontSize = 24.sp,
                textDecoration = TextDecoration.combine(listOf(TextDecoration.Underline))
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            steps = 4,
            valueRange = 0f..5f
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Position: " + sliderPosition)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyRangeSliderExample(){
    var currentRange by remember { mutableStateOf(25f..35f) }
    Column(modifier = Modifier.padding(20.dp)) {
        Text(
            "Range Slider", style = TextStyle(
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                fontSize = 24.sp,
                textDecoration = TextDecoration.combine(listOf(TextDecoration.Underline))
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        RangeSlider(
            value = currentRange,
            valueRange = 0f..60f,
            steps = 59,
            onValueChange = { currentRange = it },

        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Current rage: " + currentRange.start.toInt() + ".." + currentRange.endInclusive.toInt())
    }
}