package edu.bu.zhshu.campuseventexplorer

import android.content.Context
import android.content.Intent

fun buildShareText(event: CampusEvent): String {
    return "${event.title}\n${event.date}, ${event.time}\n${event.location}"
}

fun shareEvent(context: Context, event: CampusEvent) {
    val sendIntent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, buildShareText(event))
    }
    context.startActivity(Intent.createChooser(sendIntent, "Share event"))
}