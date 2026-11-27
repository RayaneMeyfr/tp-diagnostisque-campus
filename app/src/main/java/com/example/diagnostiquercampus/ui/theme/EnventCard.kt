package com.example.diagnostiquercampus.ui.theme

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diagnostiquercampus.R
import com.example.diagnostiquercampus.data.Event


val TAG = "TESTEVENT"
val event = Event(
    id = 1,
    title = "Concert de rock",
    location = null,
    capacity = 500,
    category = "Musique",
    description = "Une soirée exceptionnelle avec des groupes de rock pour profiter de musique live et d'une ambiance électrique."
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


@Composable
fun EventCardDetail(
    event: Event,
    onBook: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.event_banner),
                contentDescription = stringResource(R.string.event_image_description),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                contentScale = ContentScale.Crop
            )

            Text(event.title)

            Text(event.location ?: stringResource(R.string.location_unknown))
            Text(event.description)

            if (event.capacity > 0) {
                TextButton(onClick = onBook) {
                    Text(stringResource(R.string.book))
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun EnventCardDetailPreview(){
    EventCardDetail(
        event,
        onBook = {event.capacity -= 1},
        Modifier.fillMaxWidth()
    )
}

@Preview(showBackground = true)
@Composable
private fun EnventCardPreview(){
    EventCard(
        event,
        onClick = { Log.d(TAG, "Ouvrir ${event.id}") },
        onBook = {event.capacity -= 1},
        Modifier.fillMaxWidth()
    )
}