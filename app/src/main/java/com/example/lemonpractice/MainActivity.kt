package com.example.lemonpractice

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.unit.sp
import com.example.lemonpractice.ui.theme.LemonPracticeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonPracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonApp()
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LemonadePreview() {
    LemonApp(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center))
}


@Composable
fun LemonApp(
    modifier: Modifier = Modifier
){
    var result by remember { mutableStateOf(1) }
    var squeeze by remember { mutableStateOf(0) }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
            .background(MaterialTheme.colorScheme.tertiaryContainer),
        color = MaterialTheme.colorScheme.background
    ) {
        when(result){
            1 -> {
                Lemonade(
                    textResource = R.string.lemon_tree,
                    drawableId = R.drawable.lemon_tree,
                    imageClick = {
                        result = 2
                        squeeze = (2..4).random()
                    }
                )
            }
            2 -> {
                Lemonade(
                    textResource = R.string.lemon,
                    drawableId = R.drawable.lemon_squeeze,
                    imageClick = {
                        squeeze--
                        if(squeeze == 0){
                            result = 3
                        }
                    }
                )
            }
            3 -> {
                Lemonade(
                    textResource = R.string.glass_of_lemonade,
                    drawableId = R.drawable.lemon_drink,
                    imageClick = {
                        result = 4
                    }
                )
            }
            4 -> {
                Lemonade(
                    textResource = R.string.empty_class,
                    drawableId = R.drawable.lemon_restart,
                    imageClick = {
                        result = 1
                    }
                )
            }
        }
    }
}



@Composable
fun Lemonade(
    textResource: Int,
    drawableId: Int,
    imageClick: () -> Unit,
    modifier: Modifier = Modifier
) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = imageClick,
            )
            {
                Image(
                    painter = painterResource(drawableId),
                    contentDescription = null,
                    modifier = Modifier
                        .background(colorResource(R.color.image_background))
                        .padding(12.dp)
                )
            }
            Spacer(modifier = Modifier.height(35.dp))
            Text(
                text = stringResource(textResource),
                fontSize = 18.sp
            )
        }
}
