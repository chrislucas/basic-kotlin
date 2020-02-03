package samples

class Box<T>  where T : Comparable<T>, T : Comparator<T>

class Int32(val value: Int):  Comparable<Int32>, Comparator<Int32> {
    override fun compareTo(other: Int32): Int = this.compareTo(other)
    override fun compare(p: Int32?, q: Int32?): Int {
        return if(p != null && q != null) {
            p.compareTo(q)
        } else {
            0
        }
    }
}

class Wrapper<T> (var value: T? = null){
    fun add(value: T) {
        this.value = value
    }
}

interface Vehicle
data class Car(var name: String = "default") : Vehicle

data class Motocycle(var name: String = "default") : Vehicle

fun testVariance() {
    val box: Wrapper<Car> = Wrapper()
    //box.add(box, Motocycle())         // nao compila
    box.add(Car("hb20"))
    val car = box.value
    println(car)
    val box1 = Wrapper<Motocycle>()
    //box1.add(car)         // idem
    //box1.add(Car())       // idem
    box1.add(Motocycle("cb500"))
}

fun testKeywordWhereInGenerics() {
    //val wrapper = Box<Outer1.Inner1>
    val wrapper = Box<Int32>()
}

fun main() {

}
