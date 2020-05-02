package sample;

import java.util.Arrays;
import java.util.List;

public class TypeErasureProcess {

    /**
     * Type erasure eh um processo que força "A RESTRICAO DE TIPOS" somente em tempo de compilacao e descarta
     * a tipagem em tempo de execucao.
     * <p>
     * No exemplo abaixo utilizo um tipo generico que em tempo de execucao sera descartado, sendo transformado em
     * <p>
     * public static Object  findEquals(List<Object> elements, Object target)
     * <p>
     * Entrentanto o compilador garante a seguranca de tipagem e previne erros em tempo de execucao
     * <p>
     * Type erasure ocorre
     * - A nivel de classe atraves das variaveis
     * - A nivel de metodo
     */
    private static <E extends Comparable<E>> E findEquals(List<E> elements, E target) {
        for (E e : elements) {
            if (e.compareTo(target) == 0)
                return e;
        }
        return null;
    }

    private static void testFindEquals() {
        List<String> words = Arrays.asList("str", "[abcde]");
        System.out.println(findEquals(words, "[abcde]"));
    }

    public static void main(String[] args) {
        testCompositeStruct();
    }

    private static void testCompositeStruct() {
        Composite<String> first = new CompositeBuilder<String>()
                .add("chris")
                .add("lucas")
                .add("fer")
                .add("santos")
                .build();

        first.iterate(target -> {
            System.out.printf("%s, %s\n", target, target.data);
        });
    }

    static class GenCompositeBuilder<E, C extends Composite<E>>  {
        private C node;
        GenCompositeBuilder<E, C> add(C compose) {
            if (node == null) {
                node = compose;
            } else {
                addNext(node, compose);
            }
            return this;
        }

        private  void addNext(C prev, C next) {
            C pn = (C) prev.getNext();
            if (pn == null) {
                prev.setNext(next);
            } else {
                addNext(pn, next);
            }
        }

        C build() {
            return node;
        }
    }

     static class CompositeBuilder<E> {
        private Composite<E> node;

        CompositeBuilder() {}

        // ajuda a inserir dados num Compose ja existente
        CompositeBuilder(Composite<E> node) {
            this.node = node;
        }

        CompositeBuilder<E> add(E data) {
            if (node == null) {
                node = new Composite<>(data);
            } else {
                addNext(node, new Composite<>(data));
            }
            return this;
        }

        private void addNext(Composite<E> prev, Composite<E> next) {
            Composite<E> pn = prev.getNext();
            if (pn == null) {
                prev.setNext(next);;
            } else {
                addNext(prev.next, next);
            }
        }

        Composite<E> build() {
            return node;
        }
    }

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

     static class Composite<E>  {
        private final E data;
        private Composite<E> next = null;

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

    interface Apply<E> {
        void execute(Composite<E> target);
    }


}
