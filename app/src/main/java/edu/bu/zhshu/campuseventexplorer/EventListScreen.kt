package edu.bu.zhshu.campuseventexplorer

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventListScreen(
    events: List<CampusEvent>,
    query: String,
    onQueryChange: (String) -> Unit,
    onEventClick: (Long) -> Unit
) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Campus Events") }) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            OutlinedTextField(
                value = query,
                onValueChange = onQueryChange,
                label = { Text("Search events") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(12.dp))
            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                // id as key keeps each row stable when the list is filtered
                items(events, key = { it.id }) { event ->
                    EventRow(event = event, onClick = { onEventClick(event.id) })
                }
            }
        }
    }
}

@Composable
fun EventRow(event: CampusEvent, onClick: () -> Unit) {
    Card(onClick = onClick, modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(event.title, style = MaterialTheme.typography.titleMedium)
            Text(event.category)
            Text(event.location)
            Text("${event.date}, ${event.time}")
        }
    }
}