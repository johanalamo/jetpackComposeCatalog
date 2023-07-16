package com.example.jetpackcomposecatalogo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun ConstraintExample() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (boxRed, boxBlue, boxYellow, boxMagenta, boxGreen) = createRefs()

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end)
                start.linkTo(parent.start)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow) {
                bottom.linkTo(boxRed.top)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Magenta)
            .constrainAs(boxMagenta) {
                bottom.linkTo(boxRed.top)
                start.linkTo(boxRed.end)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Blue)
            .constrainAs(boxBlue) {
                start.linkTo(boxRed.end)
                top.linkTo(boxRed.bottom)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Green)
            .constrainAs(boxGreen) {
                end.linkTo(boxRed.start)
                top.linkTo(boxRed.bottom)
            })
    }
}


@Composable
fun ConstraintExampleGuide() {
    ConstraintLayout(Modifier.fillMaxSize()) {
        val topGuide = createGuidelineFromTop(0.1f)
        val startGuide = createGuidelineFromStart(0.25f)
        val redBox = createRef()
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Green)
            .constrainAs(redBox) {
                top.linkTo(topGuide)
                start.linkTo(startGuide)
            })
    }
}

@Composable
fun ConstraintBarrier() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (redBox, greenBox, yellowBox) = createRefs()

        val barrier = createEndBarrier(redBox, greenBox)

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Green)
            .constrainAs(greenBox) {
                start.linkTo(parent.start, margin = 16.dp)
            })

        Box(modifier = Modifier
            .size(225.dp)
            .background(Color.Red)
            .constrainAs(redBox) {
                top.linkTo(greenBox.bottom)
                start.linkTo(parent.start, margin = 32.dp)
            })
        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Yellow)
            .constrainAs(yellowBox) {
                start.linkTo(barrier)
            })

    }
}

@Preview(
    showSystemUi = true
)
@Composable
fun ConstraintChainExample() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (redBox, blueBox, yellowBox) = createRefs()


        Box(modifier = Modifier
            .size(75.dp)
            .background(Color.Yellow)
            .constrainAs(yellowBox) {
//                start.linkTo(parent.start)
//                end.linkTo(blueBox.start)
            })
        Box(modifier = Modifier
            .size(75.dp)
            .background(Color.Blue)
            .constrainAs(blueBox) {
//                start.linkTo(yellowBox.end)
//                end.linkTo(redBox.start)
            })

        Box(modifier = Modifier
            .size(75.dp)
            .background(Color.Red)
            .constrainAs(redBox) {
//                start.linkTo(blueBox.end)
//                end.linkTo(parent.end)
            })

        createVerticalChain(redBox, blueBox, yellowBox, chainStyle = ChainStyle.SpreadInside)
    }
}