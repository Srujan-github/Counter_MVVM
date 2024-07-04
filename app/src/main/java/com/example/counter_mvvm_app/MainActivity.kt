package com.example.counter_mvvm_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.counter_mvvm_app.ui.theme.Counter_MVVM_AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Counter_MVVM_AppTheme {
        CounterScreen()
            }
        }
    }
}


@Composable
fun CounterScreen(modifier: Modifier = Modifier) {
    val counter = remember { mutableIntStateOf(0) }
    val increment = {
        counter.intValue++
    }
    val decrement = {
        counter.intValue--
    }
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly,verticalAlignment = Alignment.CenterVertically) {
            Button(onClick = { increment.invoke() }) {
                Text(text = "Increment")
            }
            Text(text = counter.intValue.toString())
            Button(onClick = { decrement.invoke() }) {
                Text(text = "Decrement")
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun CounterScreenPreview(modifier: Modifier = Modifier) {
    CounterScreen()
}


