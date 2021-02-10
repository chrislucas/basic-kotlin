class Location(
    private val altitude: Double, private val latitude: Double, private val longitude: Double
) {
    operator fun component1(): Double = altitude
    operator fun component2(): Double = latitude
    operator fun component3(): Double = longitude
}

fun sampleWithMap() {
    val freq = mutableMapOf<Char, Int>()
    "christoffer".forEach {
        freq[it] = freq[it]?.let { v -> v + 1 } ?: 1
    }

    /**
     *  destructuring usado com um map so eh possivel por conta
     *  da extension function adicionada na interface Map.Entry
     *  inline operator fun <K, V> Map.Entry<K, V>.component1()
     *  inline operator fun <K, V> Map.Entry<K, V>.component2()
     * */
    for ((k, v) in freq) {
        println("$k, $v")
    }
}

fun main() {
    val (alt, lat, lon) = Location(
        123.0, 23.23232, 12.342423432
    )

    println("$alt, $lat, $lon")

    sampleWithMap()
}