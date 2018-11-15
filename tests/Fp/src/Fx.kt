class Point2D(private var x: Int, private var y: Int) {
    init {
        // bloco de inicializacao
        println("Bloco inicializador")
    }
    constructor(p: Point2D) : this(p.x, p.y) //{}
    override fun toString(): String {
        return "P($x, $y)"
    }
}


fun main(args: Array<String>) {
    println(0b111)
    val pointA = Point2D(1,2);
    val pointB = Point2D(pointA);
    println(pointA);
    println(pointB);
}