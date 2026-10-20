package edu.bu.zhshu.campuseventexplorer

import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val context = LocalContext.current

    NavHost(navController = navController, startDestination = EventList) {
        composable<EventList> {
            // Saved with this destination, so it survives rotation and returning from detail
            var query by rememberSaveable { mutableStateOf("") }
            EventListScreen(
                events = filterEvents(campusEvents, query),
                query = query,
                onQueryChange = { query = it },
                onEventClick = { eventId -> navController.navigate(EventDetail(eventId)) }
            )
        }
        composable<EventDetail> { backStackEntry ->
            val route = backStackEntry.toRoute<EventDetail>()
            EventDetailScreen(
                event = findEventById(route.eventId),
                onUpClick = { navController.navigateUp() },
                onShareClick = { event -> shareEvent(context, event) }
            )
        }
    }
}