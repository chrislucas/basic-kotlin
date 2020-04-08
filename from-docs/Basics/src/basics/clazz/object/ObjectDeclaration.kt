package basics.clazz.`object`

import java.io.Serializable
import java.util.*
import kotlin.collections.LinkedHashSet



class DataProvider(private val id: String) {

    override fun toString(): String {
        return "Identification: $id"
    }

    override fun equals(other: Any?): Boolean {
        return (other as DataProvider).id == id
    }

    override fun hashCode(): Int = id.hashCode()

    fun getId() : String = id
}

/**
 * https://kotlinlang.org/docs/reference/object-declarations.html#object-declarations
 *
 * Object Declaration sao Thread-safe
 *
 *  -> Objetos construidos atraves desse tipo de sintaxe tambem pode ser especiliza
 *
 * */
object DataProviderManager : Serializable {

    private val providers = LinkedHashSet<DataProvider>(5)

    fun registerDataProvider(provider: DataProvider) {
        providers.add(provider)
    }

    val allDataProvider: SortedSet<DataProvider>
        get() = providers.toSortedSet(compareById)

    private val compareById = Comparator<DataProvider>  { p, q -> p.getId().compareTo(q.getId()) }

    fun getOrderedById() : SortedSet<DataProvider> =  providers.toSortedSet(compareById)
}

fun main(args: Array<String>) {
    DataProviderManager.registerDataProvider(DataProvider("1015"))
    DataProviderManager.registerDataProvider(DataProvider("1015"))
    DataProviderManager.registerDataProvider(DataProvider("1017"))
    DataProviderManager.registerDataProvider(DataProvider("1018"))
    DataProviderManager.registerDataProvider(DataProvider("1019"))
    DataProviderManager.registerDataProvider(DataProvider("1020"))
    DataProviderManager.registerDataProvider(DataProvider("1021"))
    DataProviderManager.registerDataProvider(DataProvider("1022"))

    DataProviderManager.getOrderedById().forEach { println(it) }
}
