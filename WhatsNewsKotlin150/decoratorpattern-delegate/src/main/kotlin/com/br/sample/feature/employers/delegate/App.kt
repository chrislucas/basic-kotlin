package com.br.sample


// https://medium.com/@HugoMatilla/kotlin-patterns-decorator-pattern-with-class-delegates-982d43305681

data class Employee(val name: String)

class Employer(val employees: MutableList<Employee> = mutableListOf()) : MutableList<Employee> by employees {
    override fun add(element: Employee): Boolean {
        beforeAdd(element)
        return employees.add(element)
    }

    override fun remove(element: Employee): Boolean {
        beforeRemove(element)
        return employees.remove(element)
    }

    private fun beforeAdd(employee: Employee) {}
    private fun beforeRemove(employee: Employee) {}
}

fun main() {

}