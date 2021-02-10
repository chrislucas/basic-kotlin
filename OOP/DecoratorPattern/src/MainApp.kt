
/**
 * O padrao de projetos Decorator resolve o problema de adicioanr responsabilidades (comportamentos | funcionalidades | metodos) a uma instancia
 * em tempo de execucao sem ter que depender de extensao de classes.
 */

/**
 * Exemplo: Criar uma interface que representa Acoes de um Robo
 * */


interface Action {
    fun run()
}

/**
 * Classe Decorator implementa a interface assim o decorator
 * tambem tem o comportamento necessario.
 *
 * Alem de implementar um comportamento, o decorador base e composto
 * por um objeto que possui uma implementacao propria desse comportamento
 *
 * Como nao precisamos de uma instancia de DecoratorBase, ela pode ser abstrata
 * */
abstract class RobotDecoratorBase(private val action: Action) : Action {
    override fun run() {
        this.action.run()
    }
}

/**
 * Essa classe representa uma implementacao base de um comportamento
 * que se espera de um Robo (por exemplo). Todas outras classes sao
 * especializacoes de Decorator que sao compostas por outros decoretors formando
 * uma composicao recursiva. O prosito dessa classe eh ser o fim da recursao
 * */

class RobotBase : Action {
    override fun run() {
        println("Esse eh o robo base")
    }
}

/**
 * Uma implementacao que me parece mais facil de trocar as acoes de uma classe
 * */
class RobotBase2(var action: Action) {
    fun runAction() {
        action.run()
    }
}

class RobotDiver(action: Action) : RobotDecoratorBase(action) {
    override fun run() {
        // executa
        super.run()
        println("Esse robo tem a capacidade de mergulho")
    }
}


class RobotFlying(action: Action) : RobotDecoratorBase(action) {
    override fun run() {
        super.run()
        println("Esse robo tem a capacidade de voo")
    }
}

class RobotFlameThrower(val action: Action) : RobotDecoratorBase(action) {

    override fun run() {
        super.run()
        println("Esse robo tem a capacidade de lancar chamadas")
    }
}

fun main(args: Array<String>) {
    println("Complete Robot")
    val robot : Action = RobotFlameThrower(RobotFlying(RobotDiver(RobotBase())))
    robot.run()

    println("\nSimple Robot")
    val simpleRobot = RobotDiver(RobotBase())
    simpleRobot.run()

    println("\nRobotBase2")
    val robot2 = RobotBase2(RobotBase())
    robot2.action = RobotFlameThrower(RobotBase())
    robot2.runAction()

    println("\nRobotBase2")
    robot2.action = RobotDiver(RobotFlameThrower(RobotBase()))
    robot2.runAction()
}