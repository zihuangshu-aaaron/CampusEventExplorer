package edu.bu.zhshu.campuseventexplorer

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventDetailScreen(
    event: CampusEvent?,
    onUpClick: () -> Unit,
    onShareClick: (CampusEvent) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Event Details") },
                navigationIcon = {
                    IconButton(onClick = onUpClick) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            if (event == null) {
                EventUnavailable(onReturnClick = onUpClick)
            } else {
                EventInfo(event = event, onShareClick = { onShareClick(event) })
            }
        }
    }
}

@Composable
fun EventInfo(event: CampusEvent, onShareClick: () -> Unit) {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Text(event.title, style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(8.dp))
        Text("Category: ${event.category}")
        Text("When: ${event.date}, ${event.time}")
        Text("Where: ${event.location}")
        Spacer(Modifier.height(16.dp))
        Text(event.description)
        Spacer(Modifier.height(24.dp))
        Button(onClick = onShareClick) {
            Text("Share event")
        }
    }
}

@Composable
fun EventUnavailable(onReturnClick: () -> Unit) {
    Column {
        Text("Event unavailable", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(16.dp))
        Button(onClick = onReturnClick) {
            Text("Return to events")
        }
    }
}