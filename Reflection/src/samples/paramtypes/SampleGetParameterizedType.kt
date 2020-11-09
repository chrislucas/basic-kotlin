package samples

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Proxy
import kotlin.experimental.xor

/**
 * classe Data sera usada para exemplificar o recurso de Type Projection.
 * Ela eh uma classe parametrizavel que utiliza variancia (T:Something)
 * */

open class Data<T> {

    private val collection = mutableListOf<T>()

    fun get(): T = collection.removeAt(0)

    fun add(item: T) = collection.add(item)


    fun createProxyInstance() : T {
        val clazz = getParameterizedType()
        return Proxy.newProxyInstance(clazz.classLoader
                , arrayOf(clazz), MyInvokerHandler()) as T
    }

    private fun getParameterizedType(): Class<T> {
        var clazz: Class<*> = javaClass

        while (Any::class.java != clazz) {
            val superClazz = clazz.superclass
            if (superClazz == Data::class.java)
                break
            clazz = superClazz
        }

        return (clazz.genericSuperclass as ParameterizedType)
                .actualTypeArguments[0]::class.java as Class<T>
    }
}


class MyInvokerHandler : InvocationHandler {
    override fun invoke(proxy: Any?, method: Method?, args: Array<out Any>?): Any? {
        return null
    }
}

class SimpleData<T> : Data<T>()

interface Cryptography {
    fun execute(buffer: Array<Byte>) : Array<Byte>
}

class NaiveAlgorithm : Cryptography {
    override fun execute(buffer: Array<Byte>) : Array<Byte> {
        return buffer.copyOf()
                .map {
                    it xor 1
                }
                .toTypedArray()
    }
}

fun <T> join(from: Data<T>, to: Data<T>) =
        to.add(from.get())



fun testProxyInstance() {
    val data = SimpleData<Cryptography>()
    val cryptography = data.createProxyInstance()
    cryptography.execute(arrayOf(0, 1, 2))

}

fun main(args: Array<String>) {
    testProxyInstance()
}