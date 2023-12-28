package com.example.jetpackcomposecatalogo.catalog.composables

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.jetpackcomposecatalogo.R

@Composable
fun MyAlertDialogExample() {
    var showAlertDialog by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }
    var showDialogAdvanced by remember { mutableStateOf(false) }
    Column(modifier = Modifier.padding(20.dp)) {
        Text(
            "Alert dialogs", style = TextStyle(
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                fontSize = 24.sp,
                textDecoration = TextDecoration.combine(listOf(TextDecoration.Underline))
            )
        )

        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { showAlertDialog = true }) { Text(text = "Show AlertDialog") }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { showDialog = true }) { Text(text = "Show Dialog") }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { showDialogAdvanced = true }) { Text(text = "Show Advanced Dialog") }


        AlertDialogExample(
            show = showAlertDialog,
            dismissAction = { showAlertDialog = false },
            confirmAction = { Log.d("Alamo", "confirm clicked") }
        )
        DialogExample(
            show = showDialog,
            dismissAction = { showDialog = false },
            confirmAction = { Log.d("Alamo", "confirm clicked") }
        )
        DialogAdvancedExample(
            show = showDialogAdvanced,
            dismissAction = { showDialogAdvanced = false },
            confirmAction = { Log.d("Alamo", "confirm clicked") }
        )

    }
}

@Composable
fun AlertDialogExample(show: Boolean, confirmAction: () -> Unit, dismissAction: () -> Unit) {
    if (show) {
        AlertDialog(
            onDismissRequest = { dismissAction() },
            title = { Text(text = "AlertDialog") },
            text = { Text(text = "Showing an AlertDialog component") },
            confirmButton = {
                TextButton(onClick = { confirmAction() }) {
                    Text(text = "Confirm")
                }
            },
            dismissButton = {
                TextButton(onClick = { dismissAction() }) {
                    Text(text = "Dismiss")
                }
            }
        )
    }
}
@Composable
fun DialogExample(show: Boolean, confirmAction: () -> Unit, dismissAction: () -> Unit) {
    if (show) {
        Dialog(
            onDismissRequest = { dismissAction() },
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false,
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(24.dp)
            ) {

                DialogTitle(text = "Content of a Dialog")
                Text("click Outside and dismissOnBackPressed are not enabled")
                Button(onClick = { dismissAction() }) {
                    Text(text = "Dismiss")
                }
            }
        }
    }
}

@Composable
fun DialogAdvancedExample(show: Boolean, confirmAction: () -> Unit, dismissAction: () -> Unit) {
    if (show) {
        Dialog(
            onDismissRequest = { dismissAction() },
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = true,
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(24.dp)
            ) {
                DialogTitle(text = "Set backup account")
                AccountItem(email = "johan.alamo@gmail.com",
                    image = R.drawable.ic_launcher_foreground)
                AccountItem(email = "johan.alamo@hotmail.com", image = R.drawable.ic_launcher_foreground)

            }
        }
    }
}

@Composable
fun AccountItem(email: String, @DrawableRes image: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = image),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
               .padding(8.dp)
               .size(40.dp)
               .clip(CircleShape)
       )
        Text(
            modifier = Modifier.padding(8.dp),
            fontSize = 14.sp,
            color = Color.Gray,
            text = email,
        )
    }
}
@Composable
fun DialogTitle(text: String) {
    Text(
        modifier = Modifier.padding(12.dp),
        text = text,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
    )
}