
/**
 * Ao instanciar a classe cada linha é executada na ordem que aparece. O exemplo
 * abaixo temos 2 blocos de inicializacao imprimindo uma mensagem com numero 2 e 1. Eles
 * sarao executados na sequencia em que eles aparecem no corpo da classe
 *
 * Os parâmetros passados no construtor primario podem ser usado no blocos de inicializacao
 * de propriedades e nos de inicializacao (init)
 * */

class Point2f(x: Double, y: Double) {

    var x: Double = x;
    var y: Double = y;

    init {
        println("Executando bloco inicializar 2")
        this.y = -3.0
    }

    init {
        println("Executando bloco inicializar 1")
        this.x = -2.0
    }

    override fun toString(): String {
        return "$x, $y"
    }
}

class ImmutablePoint2F( val x: Double, val y: Double) {
    val getX: Double get() = this.x;
    val getY: Double get() = this.y;
    override fun toString(): String {
        return  "$x, $y"
    }
}


fun main(args: Array<String>) {
    val p = Point2f(2.0, 3.0)
    println(p)

    val q = ImmutablePoint2F(12.5, -23.5)
}