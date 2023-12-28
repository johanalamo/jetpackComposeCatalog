package com.example.jetpackcomposecatalogo.catalog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.jetpackcomposecatalogo.MyComplexLayout
import com.example.jetpackcomposecatalogo.MyIcon
import com.example.jetpackcomposecatalogo.MyImageAdvanced
import com.example.jetpackcomposecatalogo.MyTextFieldAdvanced
import com.example.jetpackcomposecatalogo.Separator
import com.example.jetpackcomposecatalogo.catalog.composables.CheckBoxSimpleExample
import com.example.jetpackcomposecatalogo.catalog.composables.MyAlertDialogExample
import com.example.jetpackcomposecatalogo.catalog.composables.MyDropDownMenuExample
import com.example.jetpackcomposecatalogo.catalog.composables.MyHoistingStateWithCheckBox
import com.example.jetpackcomposecatalogo.catalog.composables.MyRadioButtonExample
import com.example.jetpackcomposecatalogo.catalog.composables.MyRangeSliderExample
import com.example.jetpackcomposecatalogo.catalog.composables.MySliderExample
import com.example.jetpackcomposecatalogo.catalog.composables.TristateCheckBoxSimpleExample

@Composable
fun CatalogScreen() {


// A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        LazyColumn(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                MyAlertDialogExample()
                Separator()
                MyRangeSliderExample()
                Separator()
                MySliderExample()
                Separator()
                MyDropDownMenuExample()
                Separator()
                MyRadioButtonExample()
                Separator()
                TristateCheckBoxSimpleExample()
                Separator()
                CheckBoxSimpleExample()
                Separator()
                MyHoistingStateWithCheckBox()
                Separator()
                MyImageAdvanced()
                Separator()
                MyIcon()
                Separator()
                MyTextFieldAdvanced()
                Separator()
                MyComplexLayout()
            }
        }
    }
}