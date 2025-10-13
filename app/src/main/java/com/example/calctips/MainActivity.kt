package com.example.calctips

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp // для размеров
// Для фона
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.background
import androidx.compose.foundation.border

// Для отступов и размеров
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width

// Для формы
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.RectangleShape
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
    var message1 by remember { mutableStateOf("5") }
    var message2 by remember { mutableStateOf("3") }
    var textSize=14.sp
    Column(modifier = modifier.fillMaxSize()) {
        Row(horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(all = 20.dp).height(32.dp)) {
            Text(
                text = "Сумма заказа:",
                fontSize = textSize,
                modifier = Modifier
            )
            TextField(
                value = message1,
                textStyle = TextStyle(fontSize = textSize),
                onValueChange = { newText -> message1 = newText },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(155, 192, 203),    // фон в фокусе
                    unfocusedContainerColor = Color(255, 192, 203) // фон без фокуса
                    // focusedTextColor = Color,         // цвет текста в фокусе
                    // unfocusedTextColor = Color,       // цвет текста без фокуса
                    //cursorColor = Color,              // цвет курсора
                    // focusedIndicatorColor = Color,    // цвет индикатора в фокусе
                    // unfocusedIndicatorColor = Color   // цвет индикатора без фокуса
                ),
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        Row(horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically,modifier = Modifier.padding(all = 20.dp).fillMaxWidth(0.75f)) {
            Text(
                text = "Количество блюд:",
                fontSize = textSize,
                softWrap = false,
                modifier = Modifier
            )
            TextField(
                value = message2,
                textStyle = TextStyle(fontSize = textSize),
                onValueChange = { newText -> message2 = newText },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFAEDBFF),    // фон в фокусе
                    unfocusedContainerColor = Color(255, 192, 203) // фон без фокуса
                   // focusedTextColor = Color,         // цвет текста в фокусе
                   // unfocusedTextColor = Color,       // цвет текста без фокуса
                    //cursorColor = Color,              // цвет курсора
                   // focusedIndicatorColor = Color,    // цвет индикатора в фокусе
                   // unfocusedIndicatorColor = Color   // цвет индикатора без фокуса
                ),
                modifier = Modifier.padding(start = 16.dp)
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