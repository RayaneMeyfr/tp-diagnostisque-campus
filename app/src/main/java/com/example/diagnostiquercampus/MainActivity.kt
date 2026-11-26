package com.example.diagnostiquercampus

import android.R
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.diagnostiquercampus.ui.theme.DiagnostiquerCampusTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //val capacity: Int = "12";
        //Initializer type mismatch: expected 'Int', actual 'String'.

        val capacity = "douze".toIntOrNull() ?: 0;
        //FATAL EXCEPTION: main
        //java.lang.NumberFormatException: For input string: "douze"
        //com.example.diagnostiquercampus.MainActivity.onCreate(MainActivity.kt:22)

        val TAG = "Campus"
        Log.d(TAG,  "Places :$capacity")

        setContent {
            EventHeader("JetPack", "Foot")
        }
    }
}

@Composable
fun EventHeader(title: String, category: String, location: String? = null){
    Column {
        Text(title)
        Text(text = category)
        Text(location ?: "Lieu a confirmer")
    }
}

@Preview(showBackground = true)
@Composable
fun EventHeaderPreview(){
    EventHeader("Bonjour", "Bateau", "Test")
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DiagnostiquerCampusTheme {
        Greeting("Android")
    }
}