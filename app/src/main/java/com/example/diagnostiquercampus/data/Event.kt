package com.example.diagnostiquercampus.data

data class Event(
    val id: Int,
    val title: String,
    val location: String?,
    val capacity: Int,
    val category: String
) {
    fun displayLocation(): String = location ?: "Lieu à confirmer"
}
