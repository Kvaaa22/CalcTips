package com.example.calctips

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import com.example.calctips.ui.theme.CalcTipsTheme

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

    Column(modifier = modifier) {
        Row(modifier = Modifier.padding(bottom = 16.dp)) {
            Text(
                text = message1,
                fontSize = 28.sp,
                modifier = Modifier.weight(1f)
            )
            TextField(
                value = message1,
                textStyle = TextStyle(fontSize = 25.sp),
                onValueChange = { newText -> message1 = newText },
                modifier = Modifier.weight(1f)
            )
        }

        Row(modifier = Modifier.padding(bottom = 16.dp)) {
            Text(
                text = message2,
                fontSize = 28.sp,
                modifier = Modifier.weight(1f)
            )
            TextField(
                value = message2,
                textStyle = TextStyle(fontSize = 25.sp),
                onValueChange = { newText -> message2 = newText },
                modifier = Modifier.weight(1f)
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