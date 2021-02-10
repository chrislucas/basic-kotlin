package com.br.sample

import java.lang.StringBuilder

/*
* https://www.geeksforgeeks.org/classloader-in-java
* "The Java ClassLoader is part of the JRE that dynamically loads Java classes
* into JVM"
*   - O sistema de runtime Java nao precisa conhecer sobre arquivos e sistemas de
* arquivos por conta dos ClassLoaders
*
* - As classes Java nao sao carregadas todas de uma vez na memoria, mas sao carregadas
* quando requisitadas pela aplicacao
*
* - Quando a classe eh requisitada o ClassLoader eh chamado pela JRE que carrega a classe na memoria
*
*
* Tipos de classloader em Java: (https://www.javatpoint.com/classloader-in-java)
*
* Java ClassLoader
*   - Eh uma classe abstrata, pertencente ao package java.lang
*   - Carrega classes de diferentes lugares
*   - Usado para carregar uma classe na JVM dinamicamente, quando a tal eh requisitada
*   - O processo de carregamento na JVM eh denominado de Linking process em tempo de execucao
*   - Quando uma classe possui dependencias, suas dependencias sao carregadas primeiro
*
* (https://docs.oracle.com/javase/7/docs/api/java/lang/ClassLoader.html)
*
* - Dado o nome em binario de uma classe a ClassLoader tenta encontrar ou gerar
* dados que constituem na definicao da classe
*
* - Uma estrategia eh transformar o nome binario num nome de arquivo e tentar encontrar
* e ler um arquivo .class com esse nome a partir do sistema de arquivos
*
*
* Java ClassLoader eh baseada em 3 principios
*   - Delegation, Visibility and Uniqueness
*
*
*
*
*
*
*
*
* */

data class Point3D(val x: Double, val y: Double, val z: Double)

class MyClassLoader : ClassLoader() {
    override fun findClass(name: String?): Class<*> {
        return super.findClass(name)
    }

    override fun loadClass(name: String?): Class<*> {
        return super.loadClass(name)
    }

    public override fun loadClass(name: String?, resolve: Boolean): Class<*> {
        return super.loadClass(name, resolve)
    }
}


fun <T> Array<T>.log() : String  {
    val buffer = StringBuilder()
    this.forEachIndexed {
        i, v -> buffer.append(if (i==0) "$i:$v" else ", $i:$v")
    }
    return buffer.toString()
}

fun main() {
    val loader: MyClassLoader = MyClassLoader()
    try {
        val constructors = loader.loadClass("com.br.sample.Point3D", true)
                .declaredConstructors
        if (constructors.isNotEmpty()) {
            for (constructor in constructors) {
                if (constructor.parameterCount == 3) {
                    val p = constructor.newInstance(1.0, 2.0, 3.0)
                    println(constructor.parameterTypes.log())
                    println(p)
                    break
                }
            }
        }
    } catch (e: ClassNotFoundException) {
        println(e.message)
    }

}