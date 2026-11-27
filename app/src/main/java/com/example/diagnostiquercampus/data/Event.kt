package com.example.diagnostiquercampus.data

data class Event(
    val id: Int,
    val title: String,
    val location: String?,
    var capacity: Int,
    val category: String,
    val description: String = ""
) {
    fun displayLocation(): String = location ?: "Lieu à confirmer"
}
