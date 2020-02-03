object BuilderUser {

    @JvmStatic
    fun builder(id: Int, name: String, @Level.Companion.IntLevel level: Int) : UserSystem {
        return when(level) {
            Level.Full -> UserSystem.Full(id, name)
            Level.Admin -> UserSystem.Admin(id, name)
            Level.Dev -> UserSystem.Developer(id, name)
            Level.Guest -> UserSystem.Guest(id, name)
            else -> { throw IllegalArgumentException("Argument not Allowed") }
        }
    }


}