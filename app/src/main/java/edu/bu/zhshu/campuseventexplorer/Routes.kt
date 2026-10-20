package edu.bu.zhshu.campuseventexplorer

import kotlinx.serialization.Serializable

@Serializable
object EventList

@Serializable
data class EventDetail(val eventId: Long)