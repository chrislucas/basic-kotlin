package com.br.chp.covariance


open class Base {
    fun execute(): Base {
        return this
    }
}

class A : Base() {
    fun transform(): A {
        return this
    }
}

class B : Base()


data class Wrapper<T>(val value: T)

/**
 * "out" - the keyword out is a direction"
 * A keyword out indica que queremos obter e usar o tipo generico que foi parametrizado (T)
 * e seus subtipos.
 *
 * Parafraseando o paragrafo do livro no capitulo sobre covariancia
 * "Em kotlin e nas demais linguagens OO que definem tipos fortemente tipados uma variavel
 * ou propriedade com seu tipo definido precisa somente ser compativel com o que eh chamado de
 * tipo atual da variavel"
 *
 * Tipo atual da variavel:
 * val p: Base = SubclasseOfBase() - o Tipo atual da variavel eh SubclassOfBase. p guarda uma
 * referencia de SubclassOfBase()
 *
 *
 * */
data class Box<out T>(val value: T)

fun main() {
    // diferencas de implementacao do List e MutableList
    // do ponto de vista da parametrizacao do tipo generico

    val p: Base = A()
    println(p)

    // interface List<out E> : Collection<E>
    val fList: List<Base> = listOf<A>(A(), A())
    println(fList)
    fList[0].execute()
    val instance: A = fList[0] as A
    instance.execute()


    val sList: List<Base> = listOf(A(), B())
    sList[0].execute()

    // interface MutableList<E> : List<E>, MutableCollection<E>
    val mutableListA: MutableList<Base> = mutableListOf<Base>(A(), A())
    println(mutableListA)
    /**
     * Type mismatch.
    Required:
    MutableList<Base>
    Found:
    MutableList<A>
    Erro de compilacao quando tentamos definir uma Colecao Mutavel (MutableList)
    de um super tipo com uma instancia de colecao do subtipo
    MutableList<A> ou MutableList<B> nao eh um subtipo de MutableList<Base>

    Por que mutablelists sao invariantes ?
    // https://stackoverflow.com/questions/18666710/why-are-arrays-covariant-but-generics-are-invariant
    O link acima explica bem pq em Java List<E> eh invariante
    O caso de MutableList<E> eh similar. Como em kotlin uma MutableList<E> aceita
    mudancas nos elementos que foram adicionados e aceita a insercao de novos elementos
    apos sua criacao, caso uma MutableList nao fosse invariante e aceita algo como

    val list: MutableList<Base> = mutableListOf<AnySubClassBase>(AnySubClassBase())

    poderiamos fazer isso em seguida
    class AnotherSubClassBase :  Base()
    list.add(AnotherSubClassBase())
    ou alterar o valor do indice zero que era do tipo AnySubClassBase
    list[0] = AnotherSubClassBase()

    Lembrando que a list eh uma instancia de MutableList<AnySubclassBase>
    nao MutableList<AnotherSubclassBase>. Isso poderia causar problemas em tempo
    de execucao e comportamentos totalmente inexperados como

    val instance : AnySubClassBase = list[0] // Mas aqui na verdade se fosse possivel, teriamos
    uma instancia de AnotherSubClassBase o que poderia causar problema de Casting ou uma
     grande confusao no comportamento do software

     MutableList<E> eh invariante no seu tipo generico

     Como a classe List eh imutavel ela pode implementar seu tipo generico como covariante
     pois os metodos que ela possui nao alteram o conteudo da lista, eles permitem construir
     uma lista imutavel e comparar os valores contidos nela com uma instancia de um objeto
     do tipo parametrizado ou subtipo do mesmo

     * */
    //val mutableList: MutableList<Base> = mutableListOf<A>(A(), A())

    // outro exemplo
    // Wrapper<A> nao eh um subtipo de Wrapper<Base>, dessa formas o codigo abaixo
    // nao vai funcionar por seguranca
    val wrapper: Wrapper<Base> = Wrapper<Base>(A())
    println(wrapper)
    val box: Box<Base> = Box<A>(A())
    println(box)

}