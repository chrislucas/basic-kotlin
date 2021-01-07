package basic.samples.kotlin

/**
 * https://medium.com/dev-genius/kotlin-sealed-class-with-generic-covariance-7e33875e7002
 *
 *
 * */

import basic.ext.mutablelist.set


interface Processor<in Input, out Output> {
    fun processing(input: Input): Output
}

abstract class TemplateBackgroundTask<in Input, out Data
        , out Output>(private val processor: Processor<Input, Output>) {

    // talvez transformar isso numa suspend function
    abstract fun preprocessor(input: Input)

    fun processing(input: Input): Output {
        preprocessor(input)
        return processor.processing(input)
    }
}

data class Box<out T>(val value: T)


fun sampleProcessSuperType() {
    val processor = object : Processor<Box<Number>, CharSequence> {
        override fun processing(input: Box<Number>): String {
            val p: Box<Number> = input
            return ""
        }
    }

    val rs = processor.processing(Box(1))

}


fun sampleTestInAndOutOnCollections() {
    val sampleReadOnlyList: MutableList<out Int> = (1..100).toMutableList()
    val sampleWriteOnlyList: MutableList<in Int> = (1..100).toMutableList()
    // a linha abaixo nao eh
    //sampleReadOnlyList[1] = 10
    // A titulo de curiosidade
    sampleWriteOnlyList[IntRange(0, 3)] = mutableListOf(-1, -2, -3)
    sampleWriteOnlyList[10] = -100
    println("$sampleReadOnlyList\n\n$sampleWriteOnlyList")
}


fun main(args: Array<String>) {
    sampleTestInAndOutOnCollections()
}