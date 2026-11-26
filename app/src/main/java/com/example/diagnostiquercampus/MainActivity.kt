package com.example.diagnostiquercampus

import android.R
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diagnostiquercampus.data.Event
import com.example.diagnostiquercampus.ui.theme.DiagnostiquerCampusTheme
import com.example.diagnostiquercampus.ui.theme.EventHeader
import com.example.diagnostiquercampus.ui.theme.event


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val TAG = "TESTEVENT"
        val listEvent: List<Event> = listOf(
            Event(
                id = 1,
                title = "Concert de rock",
                location = "Salle 33",
                capacity = 500,
                category = "Musique"
            ),
            Event(
                id = 2,
                title = "Festival de jazz",
                location = null,
                capacity = 200,
                category = "Musique"
            )
        )
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                listEvent.forEach { event ->
                    EventHeader(event = event, onClick = { Log.d(TAG, "Ouvrir ${event.id}") })
                }
            }
        }
    }
}

