package com.jectpack.basiclifecyclenav

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.jectpack.basiclifecyclenav.ui.theme.BasicLifeCycleNavTheme

class SecondActivity : ComponentActivity() {
    val TAG = "SecondActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        println("$TAG Inside OnCreate() ")
        setContent {
            BasicLifeCycleNavTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting1("Second Screen")
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        println("$TAG Inside onStart() ")
    }

    override fun onResume() {
        super.onResume()
        println("$TAG Inside onResume() ")
    }

    override fun onPause() {
        super.onPause()
        println("$TAG Inside onPause() ")
    }

    override fun onStop() {
        super.onStop()
        println("$TAG Inside onStop() ")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("$TAG Inside onDestroy() ")
    }

}

@Composable
fun Greeting1(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Text(
        text = "Hello $name!",
        modifier = modifier.clickable {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
        ,
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview1() {
    BasicLifeCycleNavTheme {
        Greeting1("SecondScreen")
    }
}