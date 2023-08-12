package com.ed_app.androix

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ed_app.androix.ui.theme.AndroixTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroixTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                        QuizText()
                }
            }
        }
    }

@Composable
fun QuizText()
{
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(color = androidx.compose.ui.graphics.Color.White)
            .fillMaxSize())
    {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(color = androidx.compose.ui.graphics.Color.Black)
                .padding(top = 10.dp)

        )
        {
            Text(
                text = "Quiz app",
                color = androidx.compose.ui.graphics.Color.White,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
            )
        }
        Row (
            modifier = Modifier
                .wrapContentSize()
                //.height(300.dp)
            ,
            verticalAlignment = Alignment.CenterVertically,

        )
        {

            var text by remember {
                mutableStateOf("Who is the 44th President of the United States?")
            }

            val question = "Who is the 44th President of the United States?"
            val answer = "Barak Obama"
            var backgroundColor by remember {
                mutableStateOf(androidx.compose.ui.graphics.Color.Black)
            }
            var color by remember {
                mutableStateOf(androidx.compose.ui.graphics.Color.White)
            }

            ClickableText(
                text = AnnotatedString(text),
                style = TextStyle(
                    fontSize = 40.sp,
                    color = color,
                    textAlign = TextAlign.Center,

                ),
                modifier = Modifier
                    .padding(10.dp)
                    .padding(vertical = 50.dp)
                    .align(Alignment.CenterVertically)
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(color = backgroundColor)
                    .border(BorderStroke(width = 5.dp, color = androidx.compose.ui.graphics.Color.Cyan)),


                onClick =
                {
                    if (text == question) {
                        text = answer
                        backgroundColor = androidx.compose.ui.graphics.Color.Yellow
                        color = androidx.compose.ui.graphics.Color.Black
                    }
                    else {
                        text = question
                        backgroundColor = androidx.compose.ui.graphics.Color.Black
                        color = androidx.compose.ui.graphics.Color.White
                    }
                })
        }

    }


}
@Preview(showBackground = true)
@Composable
fun AppPreview() {
    AndroixTheme {
        QuizText()
    }
}

}
