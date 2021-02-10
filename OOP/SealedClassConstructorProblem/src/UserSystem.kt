/**
 * Um exemplo para explorar a sintaxe e p qie a linguagem tem a oferecer
 * */

sealed class Level constructor(@IntLevel val levelId: Int) {
    class FullLevel() : Level(Full)
    class AdminLevel() : Level(Admin)
    class DeveloperLevel() : Level(Dev)
    class GuestLevel() : Level(Guest)

    companion object {
        @Retention(AnnotationRetention.SOURCE)
        annotation class IntLevel
        const val Full : Int = 0
        const val Admin = 1
        const val Dev = 2
        const val Guest = 3
    }
}

// construtores numa sealed class sao privados
sealed class UserSystem {
    abstract val id: Int
    abstract val name: String
    abstract val level: Level

    open class Full(
        override val id: Int,
        override val name: String, override val level: Level = Level.FullLevel()
    ) : UserSystem()

    data class Admin(
        override val id: Int,
        override val name: String, override val level: Level = Level.AdminLevel()
    ) : UserSystem()


    data class Developer(
        override val id: Int,
        override val name: String, override val level: Level = Level.DeveloperLevel()
    ) : UserSystem()

    data class Guest(
        override val id: Int,
        override val name: String, override val level: Level = Level.GuestLevel()
    ) : UserSystem()
}


