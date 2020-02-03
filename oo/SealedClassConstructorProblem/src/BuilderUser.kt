object BuilderUser {

    @JvmStatic
    fun builder(id: Int, name: String, level: Level) : UserSystem {
        return when(level) {
            is Level.FullLevel -> UserSystem.Full(id, name)
            is Level.AdminLevel -> UserSystem.Admin(id, name)
            is Level.DeveloperLevel -> UserSystem.Developer(id, name)
            else -> UserSystem.Guest(id, name)
        }
    }


}