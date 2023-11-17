package com.example.jetpackcomposecatalogo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecatalogo.ui.theme.JetpackComposeCatalogoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCatalogoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        CheckBoxSimpleExample()
                        Separator()
                        MyHoistingStateWithCheckBox()
                        Separator()
//                        MyImageAdvanced()
//                        Separator()
//                        MyIcon()
//                        Separator()
//                        MyTextFieldAdvanced()
//                        Separator()
//                        MyComplexLayout()
                    }
                }
            }
        }
    }
}




@Composable
fun MyIcon() {
    Column() {
        Text(text = "Icons")
        Icon(
            imageVector = Icons.Rounded.Star,
            contentDescription = "my icon",
            tint = Color.Red,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MyIconPreview() {
    MyIcon()
}

@Composable
fun MyImageAdvanced() {
    Column() {
        Text(text = "Images")
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "my image description",
            modifier = Modifier
                .clip(CircleShape)
                .border(5.dp, Color.Red, CircleShape)
        )
    }
}

@Preview
@Composable
fun MyImageAdvancedPreview() {
    MyImageAdvanced()
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldAdvanced() {
    Column() {
        Text("TextFields")

        var name by remember { mutableStateOf("") }
        OutlinedTextField(
            value = name,
            onValueChange = {
                name = if (it.contains("a")) {
                    it.replace("a", "")
                } else {
                    it
                }
            },
            label = { Text(text = " Introduce your username") },
            supportingText = { Text(text = "Supporting text") },
            isError = false,
            placeholder = { Text(text = "MyPlaceholder") },
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField() {
    var name by remember { mutableStateOf("hellow") }
    TextField(value = name, onValueChange = {
        name = it
    })
}

@Composable
@Preview(showSystemUi = true)
fun MyStateExamplePreview() {
    MyStateExample()
}

var instanceCounter = 0

@Composable
fun MyStateExample() {
    var myId = remember {
        instanceCounter++
        instanceCounter
    }
    var counter by rememberSaveable {
//        instanceCounter++
        mutableStateOf(0)
    }
    println("avilan MyStateExample instance: " + myId)
    Column(
        Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            counter++

//            println("avilan MyStateExample.click ${counter}")
        }) {
            Text(
                text = "($myId) Pulsar ${counter}",
                onTextLayout = { println("avilan MyStateExample.text.pulsar.onRextLayout") })
        }
        Text(text = "He sido pulsado ${counter} veces",
            onTextLayout = {
//            println("avilan MyStateExample.text.onRextLayout")
            }
        )

    }
}

@Composable
fun MyComplexLayout() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "My Complex layout")
        Spacer(modifier = Modifier.height(30.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Cyan),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Ejemplo 1")
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Spacer(modifier = Modifier.width(30.dp))
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Red),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Ejemplo 2")
            }
            Spacer(modifier = Modifier.width(30.dp))
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Green),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Ejemplo 3")
            }
            Spacer(modifier = Modifier.width(30.dp))
        }
        Spacer(modifier = Modifier.height(30.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Magenta),
            contentAlignment = Alignment.BottomCenter
        ) {
            Text(text = "Ejemplo 4")
        }
        Spacer(modifier = Modifier.height(30.dp))

    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun MyComplexLayoutPreview() {
    MyComplexLayout()
}

@Composable
fun MyRow() {
    var x = 1
    Row(
        modifier = Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState())
//        .verticalScroll(state = rememberScrollState()), verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Ejemplo ejemplo ejemplo " + x++.toString(), modifier = Modifier
                .background(Color.Red)

        )
        Text(
            text = "Ejemplo " + x++.toString(), modifier = Modifier
                .background(Color.Cyan)
        )
        Text(
            text = "Ejemplo " + x++.toString(), modifier = Modifier
                .background(Color.Blue)
        )
        Text(
            text = "Ejemplo " + x++.toString(), modifier = Modifier
                .background(Color.Red)
        )
        Text(
            text = "Ejemplo " + x++.toString(), modifier = Modifier
                .background(Color.Cyan)
        )
        Text(
            text = "Ejemplo " + x++.toString(), modifier = Modifier
                .background(Color.Blue)
        )
        Text(
            text = "Ejemplo " + x++.toString(), modifier = Modifier
                .background(Color.Red)
        )
        Text(
            text = "Ejemplo " + x++.toString(), modifier = Modifier
                .background(Color.Cyan)
        )
    }
}

@Composable
@Preview(
    showSystemUi = true,
    name = "this is my column preview"
)
fun MyPreview() {
    MyRow()
}

@Composable
fun MyColumn() {
    var x = 0
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState()),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Ejemplo " + x++.toString(), modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo " + x++.toString(), modifier = Modifier
                .background(Color.Cyan)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo " + x++.toString(), modifier = Modifier
                .background(Color.Magenta)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo " + x++.toString(), modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo " + x++.toString(), modifier = Modifier
                .background(Color.Cyan)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo " + x++.toString(), modifier = Modifier
                .background(Color.Magenta)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo " + x++.toString(), modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo " + x++.toString(), modifier = Modifier
                .background(Color.Cyan)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo " + x++.toString(), modifier = Modifier
                .background(Color.Magenta)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo " + x++.toString(), modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo " + x++.toString(), modifier = Modifier
                .background(Color.Cyan)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo " + x++.toString(), modifier = Modifier
                .background(Color.Magenta)
                .fillMaxWidth()
                .height(100.dp)
        )
    }
}

@Composable
fun MyBox(name: String, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .background(Color.Cyan)
                .width(200.dp)
                .height(200.dp)
                .verticalScroll(
                    rememberScrollState()
                ), contentAlignment = Alignment.Center
        ) {
            Text(text = "esto es un ejemplo")
        }
    }
}

@Composable
fun Separator() {
    Spacer(modifier = Modifier.height(5.dp))
    Divider(color = Color.DarkGray, thickness = 2.dp, modifier = Modifier.padding(horizontal = 5.dp))
    Spacer(modifier = Modifier.height(5.dp))
}