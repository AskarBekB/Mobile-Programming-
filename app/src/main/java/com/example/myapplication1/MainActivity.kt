package com.example.myapplication1

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication1.ui.theme.MyApplication1Theme
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplication1Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
//                    GreetingImage(stringResource(R.string.happy_birthday_text), stringResource(R.string.signature_text))
//                    ComposeArticle(theme = "Jetpack Composes Tutroital", littlew = stringResource(id = R.string.little_w), highw = stringResource(id = R.string.high_w))
//                    TaskManager(first = "All Tasks completed", second = "Nice Work!")
                    val textingArray = stringArrayResource(R.array.text_array).toList()
                    val descArray = stringArrayResource(R.array.desc_array).toList()
                    val backgroundColors = listOf(
                        colorResource(id = R.color.color1),
                        colorResource(id = R.color.color2),
                        colorResource(id = R.color.color3),
                        colorResource(id = R.color.color4),
                    )

                    Task4(
                        TextingArray = textingArray,
                        DescArray = descArray,
                        BackgroundColors = backgroundColors
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    // Create a column so that texts don't overlap
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(top = 18.dp)
                .padding(end = 16.dp)
                .align(alignment = Alignment.Start)
        )
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    Box(modifier) {
        Image(
            painter = painterResource(id = R.drawable.androidparty),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

@Composable
fun ComposeArticle(theme: String, littlew: String, highw: String, modifier: Modifier = Modifier){
    Box(modifier){
        Image(
            painter = painterResource(id = R.drawable.bg_compose_background),
            contentDescription = null,
        )
        Content(
            theme = theme,
            littlew = littlew,
            highw = highw,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

@Composable
private  fun Content(theme: String, littlew: String, highw: String, modifier: Modifier = Modifier){
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ){
        Text(
            text = theme,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text =littlew,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(start = 16.dp)
                .padding(end = 16.dp)
        )
        Text(
            text =highw,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(16.dp)
        )
    }
}

@Composable
fun TaskManager(first: String, second: String, modifier: Modifier = Modifier){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ){
        Image(
            painter = painterResource(id = R.drawable.ic_task_completed),
            contentDescription = null
        )
        Text(
            text = first,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 24.dp)
                .padding(bottom = 8.dp)
        )
        Text(
            text=second,
            fontSize = 16.sp
        )

    }
}


@Composable
fun Task4(
    TextingArray: List<String>,
    DescArray: List<String>,
    BackgroundColors: List<Color>,
    modifier: Modifier = Modifier
) {
    Column(modifier = Modifier.fillMaxSize()) {
        val rowColumnCount = 2

        TextingArray.forEachIndexed { index, Texting ->
            Row(
                modifier = Modifier
                    .weight(1f)
                    .padding(4.dp)
            ) {
                ColumnTexting(
                    Texting = Texting,
                    Desc = DescArray.getOrNull(index) ?: "",
                    Background = BackgroundColors.getOrElse(index % BackgroundColors.size) { Color.White },
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
fun ColumnTexting(
    Texting: String,
    Desc: String,
    Background: Color,
    modifier: Modifier = Modifier
){
  Column(
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = modifier
          .fillMaxSize()
          .background(Background)
          .padding(16.dp)
  ) {
      Text(
          text = Texting,
          fontWeight = FontWeight.Bold,
          modifier = Modifier.padding(bottom = 16.dp),
      )
      Text(
          text = Desc,
          textAlign = TextAlign.Justify,
          color = Color.Black
      )
  }
}


@Preview(showBackground = true, showSystemUi = false)
@Composable
fun GreetingPreview() {
    MyApplication1Theme {
//        GreetingImage(stringResource(R.string.happy_birthday_text), stringResource(id = R.string.signature_text))
//      ComposeArticle(theme = "Jetpack Compose Tutorial", littlew = stringResource(R.string.little_w), highw = stringResource(R.string.high_w))
//        TaskManager(first = "All Tasks Completed", second = "Nice Work!"),firstDesc
        val textingArray = stringArrayResource(R.array.text_array).toList()
        val descArray = stringArrayResource(R.array.desc_array).toList()
        val backgroundColors = listOf(
            colorResource(id = R.color.color1),
            colorResource(id = R.color.color2),
            colorResource(id = R.color.color3),
            colorResource(id = R.color.color4),
        )

        Task4(
            TextingArray = textingArray,
            DescArray = descArray,
            BackgroundColors = backgroundColors
        )
    }
}
