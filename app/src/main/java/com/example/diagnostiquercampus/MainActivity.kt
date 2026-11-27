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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diagnostiquercampus.data.Event
import com.example.diagnostiquercampus.ui.theme.DiagnostiquerCampusTheme
import com.example.diagnostiquercampus.ui.theme.EventCard
import com.example.diagnostiquercampus.ui.theme.TAG
import com.example.diagnostiquercampus.ui.theme.event


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val listEvent: List<Event> = listOf(
            Event(
                id = 1,
                title = "Concert de rock",
                location = "Paris",
                capacity = 500,
                category = "Musique"
            ),
            Event(
                id = 2,
                title = "Festival de jazz",
                location = "Lyon",
                capacity = 1,
                category = "Musique"
            ),
            Event(
                id = 3,
                title = "Exposition d'art",
                location = "Marseille",
                capacity = 0,
                category = "Culture"
            ),
            Event(
                id = 4,
                title = "Tournoi de football",
                location = "Bordeaux",
                capacity = 1000,
                category = "Sport"
            ),
            Event(
                id = 5,
                title = "Conférence informatique",
                location = "Lille",
                capacity = 300,
                category = "Technologie"
            )
        )
        setContent {
            EventListScreen(listEvent)
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventListScreen(events: List<Event>) {
    Scaffold(
        topBar = {
                TopAppBar(title = { Text("Campus") })
        }
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier.padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(events) { event ->
                EventCard(
                    event = event,
                    onClick = {
                        Log.d("TESTEVENT", "Ouvrir ${event.id}")
                    },
                    onBook = { event.capacity -= 1},
                )
            }
        }
    }
}



