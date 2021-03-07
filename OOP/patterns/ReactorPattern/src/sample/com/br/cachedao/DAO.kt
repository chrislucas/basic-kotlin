package sample.com.br.cachedao

interface DAO<T> {
    fun getById(id: Long): T?
    fun delete(data: T): Boolean
    fun save(data: T): T
}