package com.br.sample.references.properties

// https://antonioleiva.com/function-references-kotlin/

class MediaItem(val title: String, val url: String)

fun main() {
    val items = listOf(
        MediaItem("A", "http://localhost:8080"),
        MediaItem("B", "http://localhost:8081"),
        MediaItem("C", "http://localhost:8082"),
        MediaItem("D", "http://localhost:8083"),
        MediaItem("AA", "http://192.168.45.123:8078")
    )
    items.sortedBy(MediaItem::url)
        .map(MediaItem::url)
        .forEach(::println)
    println("************************************************************")
    items.sortedByDescending(MediaItem::title)
        .map { Pair(it.title, it.url) }
        .forEach(::println)
}