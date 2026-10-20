package edu.bu.zhshu.campuseventexplorer

val campusEvents = listOf(
    CampusEvent(1, "Fall Career Fair", "Career", "Oct 28", "11:00 AM", "GSU Ballroom", "Meet recruiters from over 50 companies. Bring copies of your resume."),
    CampusEvent(2, "Intro to Android Workshop", "Tech", "Oct 30", "6:00 PM", "CDS 1646", "Build your first Compose app in 90 minutes. Laptops required."),
    CampusEvent(3, "Halloween Movie Night", "Social", "Oct 31", "8:00 PM", "Marsh Plaza", "Free popcorn and a scary movie on the big outdoor screen."),
    CampusEvent(4, "Hackathon Kickoff", "Tech", "Nov 2", "9:00 AM", "CDS Atrium", "24-hour hackathon. Form teams of up to four people."),
    CampusEvent(5, "Basketball Home Opener", "Sports", "Nov 5", "7:00 PM", "Case Gym", "Cheer on the Terriers in the first home game of the season."),
    CampusEvent(6, "Resume Review Drop-in", "Career", "Nov 6", "2:00 PM", "Career Center", "Get quick feedback on your resume from career advisors."),
    CampusEvent(7, "Jazz Ensemble Concert", "Music", "Nov 8", "7:30 PM", "Tsai Center", "The BU Jazz Ensemble performs classic and modern pieces."),
    CampusEvent(8, "Study Break Yoga", "Wellness", "Nov 10", "5:00 PM", "FitRec Studio", "A relaxing beginner yoga session. Mats are provided.")
)

fun findEventById(id: Long): CampusEvent? {
    return campusEvents.find { it.id == id }
}

fun filterEvents(events: List<CampusEvent>, query: String): List<CampusEvent> {
    val text = query.trim()
    if (text.isEmpty()) return events
    return events.filter {
        it.title.contains(text, ignoreCase = true) ||
                it.category.contains(text, ignoreCase = true)
    }
}