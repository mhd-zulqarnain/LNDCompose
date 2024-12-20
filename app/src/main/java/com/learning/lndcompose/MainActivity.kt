package com.learning.lndcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HomeScreen()
        }
    }
}

@Composable
fun HomeScreen() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .background(Color.Cyan)
    ) {
        val (backgroundGradient, profileImg, timeImg, welcomeText, loginButton, urgent, card) = createRefs()

        val horizontalGuideline = createGuidelineFromTop(.40f)
        val topGuideline = createGuidelineFromTop(16.dp)
        val startGuideline = createGuidelineFromStart(16.dp)
        val endGuideline = createGuidelineFromEnd(16.dp)

        createHorizontalChain(
            profileImg, timeImg,
            chainStyle = ChainStyle.SpreadInside
        )

        BackgroundGradient(modifier = Modifier.constrainAs(backgroundGradient) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(horizontalGuideline)
            height = Dimension.fillToConstraints
            width = Dimension.wrapContent
        })

        ProfileImg(modifier = Modifier.constrainAs(profileImg) {
            top.linkTo(topGuideline)
            start.linkTo(startGuideline)
        })

        TimeImg(modifier = Modifier.constrainAs(timeImg) {
            top.linkTo(topGuideline)
            end.linkTo(endGuideline)
        })

        WelcomeText(modifier = Modifier.constrainAs(welcomeText) {
            top.linkTo(profileImg.bottom)
            start.linkTo(startGuideline)
        })

        LoginButton(modifier = Modifier.constrainAs(loginButton) {
            top.linkTo(welcomeText.bottom)
            start.linkTo(startGuideline)
        })

        UrgentImage(modifier = Modifier.constrainAs(urgent) {
            end.linkTo(endGuideline)
            bottom.linkTo(horizontalGuideline)

            start.linkTo(loginButton.end, margin = 16.dp)
            top.linkTo(loginButton.bottom, margin = 16.dp)

            height = Dimension.fillToConstraints
            width = Dimension.fillToConstraints
        })

        MyCard(modifier = Modifier.constrainAs(card) {
            top.linkTo(horizontalGuideline, -4.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)

            height = Dimension.fillToConstraints
            width = Dimension.fillToConstraints

        })
    }
}

@Composable
fun MyCard(modifier: Modifier) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(8.dp),
        shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
        colors = CardColors(
            containerColor = Color.White,
            contentColor = Color.Black,
            disabledContentColor = Color.Gray,
            disabledContainerColor = Color.Gray
        )
    ) {}
}

@Composable
fun UrgentImage(modifier: Modifier) {
    Image(
        painterResource(R.drawable.urgent_care),
        contentDescription = null,
        modifier = modifier
            .clip(CircleShape)
            .size(48.dp)
    )
}

@Composable
fun ProfileImg(modifier: Modifier) {
    Image(
        painterResource(R.drawable.profile),
        contentDescription = null,
        modifier = modifier
            .clip(CircleShape)
            .size(48.dp)
    )
}

@Composable
fun WelcomeText(modifier: Modifier) {
    Text(
        text = "Welcome to home",
        modifier = modifier.padding(16.dp),
        fontSize = 21.sp,
        color = Color.White,
        style = TextStyle(fontWeight = FontWeight.Bold)
    )
}

@Composable
fun LoginButton(modifier: Modifier = Modifier) {
    Button(modifier = modifier, onClick = {}) {
        Text(
            text = "Login now",
            fontSize = 13.sp,
            style = TextStyle(fontWeight = FontWeight.Bold)
        )
    }
}

@Composable
fun TimeImg(modifier: Modifier) {
    Image(
        painterResource(R.drawable.time),
        contentDescription = null,
        modifier = modifier
            .clip(CircleShape)
            .size(48.dp)
    )
}

@Composable
fun BackgroundGradient(modifier: Modifier) {
    Image(
        painterResource(R.drawable.gradient_background),
        contentDescription = null,
        modifier = modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )

}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HomeScreen()
}