package edu.bu.zhshu.campuseventexplorer

data class CampusEvent(
    val id: Long,
    val title: String,
    val category: String,
    val date: String,
    val time: String,
    val location: String,
    val description: String
)