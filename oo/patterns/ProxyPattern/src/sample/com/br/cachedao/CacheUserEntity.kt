package sample.com.br.cachedao

import sample.com.br.cachedao.models.UserEntity

/***
 * Proxy responsavel por realizar cache dos dados de um usuario Res
 * */

class CacheUserEntity(private val localRepository: DAO<UserEntity>) : DAO<UserEntity> {

    val cache: MutableMap<Long, UserEntity> = mutableMapOf()

    override fun getById(id: Long): UserEntity? {
        // simularia uma consulta ou um request aqui

        return if (cache[id] != null) {
            cache[id]
        } else {
            val user = localRepository.getById(id)
            user?.also {
                cache[id] = it
            }
        }
    }

    override fun delete(data: UserEntity): Boolean {
        if (localRepository.delete(data)) {
            cache.remove(data.id)
            return true
        }
        return false
    }

    override fun save(data: UserEntity): UserEntity {
        // simula uma persistencia num arquivo ou base de dadois
        data.apply { this.id = 1 }
        val _data =localRepository.save(data)
        cache[_data.id] = _data
        return _data
    }
}