# Campus Event Explorer

CS 501 assignment. The app shows a list of 8 campus events. You can search them, tap one to see more info, and share it.

## What it does
Shows each event's title, category, location and time in a list 
Search box filters by title or category as you type
Tapping an event opens a detail page with the full description
Share event button opens the Android share menu
If the event ID is wrong, it shows "Event unavailable" and a button to go back

## Implementation notes
I used type-safe navigation with two routes, `EventList` and `EventDetail(eventId)`. Only the ID gets passed to the detail page, and the page finds the event with `findEventById`.
The search text is stored with `rememberSaveable` inside the list destination in `AppNavigation.kt`. That's why it stays after rotating or going back from the detail page. The list itself isn't stored separately. It gets filtered from the full list every time.
The two screens don't get the NavController. They just take data and callbacks, and the actual navigation happens in `AppNavigation.kt`.
Sharing uses an `ACTION_SEND` intent wrapped in `Intent.createChooser()`.

## Running it
Open in Android Studio, sync Gradle, and run. I tested on a Pixel 10 emulator.

## Screenshots
![screenshot 1](screenshots/Screenshot_20261020_162255.png)
![screenshot 2](screenshots/Screenshot_20261020_162305.png)
![screenshot 3](screenshots/Screenshot_20261020_162350.png)
![screenshot 4](screenshots/Screenshot_20261020_163959.png)
## Testing
I tested everything by hand: searching, rotating on the detail page, Up and Back buttons an invalid ID (999), and the share button.

## AI disclosure
I used AI to break down the assignment requirements and help troubleshoot bugs, including an issue with the search text not being retained. I implemented and tested the final app myself.