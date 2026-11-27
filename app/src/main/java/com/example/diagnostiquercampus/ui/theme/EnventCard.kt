package com.example.diagnostiquercampus.ui.theme

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diagnostiquercampus.data.Event


val TAG = "TESTEVENT"
val event = Event(
    id = 1,
    title = "Concert de rock",
    location = null,
    capacity = 500,
    category = "Musique"
)

@Composable
fun EventCard(event: Event, onClick: () -> Unit, onBook: () -> Unit, modifier: Modifier = Modifier) {
    Card(onClick = onClick, modifier = modifier) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Row(){
                Text(event.title, modifier = Modifier.weight(1f))
                Text(event.category.uppercase())
            }

            Text(event.location ?: "Lieu à confirmer")

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (event.capacity > 0) {
                    TextButton(onClick = onBook) {
                        Text("Réserver")
                    }
                }

                Spacer(modifier = Modifier.weight(1f))

                TextButton(onClick = onClick) {
                    Text("Voir →")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EnventCardPreview(){
    EventCard(
        event,
        onClick = { Log.d(TAG, "Ouvrir ${event.id}") },
        onBook = {event.capacity -= 1},
        Modifier.fillMaxWidth()
    )
}