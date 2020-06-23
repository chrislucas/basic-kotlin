package sample;

/**
 * Type erasure a nivel de classe
 *
 * Em tempo de compilacao, os tipos genericos sao transformados no  tipo que se enquadre (caso o tipo
 * generico esteja sendo limitado, sendo ele uma subclasse atraves do uso de extends)
 * ou em Object.
 * No Caso abaixo a classe tornar-se-a em: private static class Composite<Object>
 *
 * Como a classe Composite possui parametrizacao para um tipo generico, mas este nao define
 * uma restricao de quais classes podemos parametrizar, o compilador substituira tudo por Object
 *
 * Se adicionarmos uma restricao tal que a definicao da classe passe a ser:
 *
 * private static class Composite<E extends Comparable>
 *
 * Todos os atributos do tipo 'E' tornar-se-ao Comparables
 *
 *
 */

class Composite<E>  {
    private final E data;
    private Composite<E> next = null;

    /**
     * construtor compilado
     *   <init>(Ljava/lang/Object;)V
     * */
    Composite(E data) {
        this.data = data;
    }

    E getData() {
        return data;
    }

    /**
     * Type erasure em metodos
     *
     * Quando o tipo parametrizado nao for definido com limites de subclasse ou superclasse
     * os parametros e os tipos de variaveis declarados dentro do escopo do metodo
     * serao substituidos por Object pelo compilador, do contrario o compilador substituira
     * pela classe que foi definida como o Limite (superclasse)
     *
     * Exemplo:
     * private Composite<E> doSomething(Composite<E> next)
     * torna-se
     * private Composite<Object> doSomething(Composite<Object> next)
     * e
     * private Composite<E extends Comparable<E>> doSomething(Composite<E extends Comparable<E>> next)
     * torna-se
     * private Composite<Comparable<Comparable>> doSomething(Composite<Comparable<Comparable>> next)
     *
     * */

    void iterate(Apply<E> apply) {
        iterate(this, apply);
    }

    private void iterate(Composite<E> node, Apply<E> apply) {
        Composite<E> cp = node;
        while (cp != null) {
            apply.execute(cp);
            cp = cp.next;
        }
    }

    void setNext(Composite<E> next) {
        this.next = next;
    }


    Composite<E> getNext() {
         return next;
    }
 }
