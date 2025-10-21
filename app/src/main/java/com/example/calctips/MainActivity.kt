package com.example.calctips

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import com.example.calctips.ui.theme.CalcTipsTheme
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.VisualTransformation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalcTipsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainFunc(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MainFunc(modifier: Modifier = Modifier) {
    var message1 by remember { mutableStateOf("57кКС77") }
    var message2 by remember { mutableStateOf("3") }
    var tipPercentage by remember { mutableStateOf(10f) }
    val textSize = 14.sp

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(13.dp)
    ) {
        // Первый ряд - Сумма заказа
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Сумма заказа:",
                fontSize = textSize,
                modifier = Modifier
            )
            BasicTextField(
                value = message1,
                onValueChange = { message1 = it },
                textStyle = TextStyle(
                    fontSize = textSize,
                    color = Color.Black
                ),
                modifier = Modifier.padding(start = 10.dp)
                    .width(130.dp)
                    .height(28.dp)
                    .background(Color(0xFFFFE4EC), RoundedCornerShape(0))
                    .wrapContentHeight(Alignment.CenterVertically)
                    .padding(horizontal = 8.dp)

            )
        }

        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Количество блюд:",
                fontSize = textSize,
                modifier = Modifier.padding(start = 10.dp)

            )
            BasicTextField(
                value = message2,
                onValueChange = { message2 = it },
                textStyle = TextStyle(
                    fontSize = textSize,
                    color = Color.Black
                ),
                modifier = Modifier
                    .padding(start = 10.dp)
                    .width(60.dp)
                    .height(28.dp)
                    .background(Color(0xFFFFE4EC), RoundedCornerShape(0))
                    .wrapContentHeight(Alignment.CenterVertically)
                    .padding(horizontal = 8.dp)

            )
        }

        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Чаевые:",
                fontSize = textSize,
                modifier = Modifier.padding(end=10.dp)
            )

            Text(
                text = "${tipPercentage.toInt()}%",
                fontSize = textSize,
                modifier = Modifier.width(40.dp)
            )
        }

        Slider(
            value = tipPercentage,
            onValueChange = { tipPercentage = it },
            valueRange = 0f..25f,
            steps = 26,
            modifier = Modifier.fillMaxWidth()
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "0",
                fontSize = 18.sp,
                modifier = Modifier.padding(end=10.dp)
            )

            Text(
                text = "25",
                fontSize = 18.sp,
                modifier = Modifier
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalcTipsTheme {
        MainFunc()
    }
}