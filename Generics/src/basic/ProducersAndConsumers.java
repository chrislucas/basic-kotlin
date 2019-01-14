package basic;

import java.util.*;

public class ProducersAndConsumers {

    /**
     * https://kotlinlang.org/docs/reference/generics.html
     * */
    // Criando objetos somente de leiura (get) nao conseguimos adicionar nenhum
    // elemento novo a lista.

    // Mnemonico PECS  Producer-Extends Consumer-Super
    private static void testProducers() {
        List<? extends CharSequence> values = Arrays.asList("test", "123", "456");
        /**
         * nao eh possivel adicionar nada a essa lista, somente definir
         * o seu valor atraves de uma lista inicial, pois usando
         * o wildcard nao sabemos qual o subtipo que foi inserido na lisat
         * assim nao sabemos qual subtipo eh possivel adicionar
         * */

        for (Object o : values) {
            System.out.println(o);
        }
    }

    // criando uma lista somente de escrita (add) de um tipo especifico
    private static void testConsumers() {
        List<? super String> values = new ArrayList<>(Arrays.asList("test", "123", "456"));
        values.add("Christoffer");
        values.add("Lucas");
        values.add("Fernandes");
        values.add("Santos");
        //values.add(new Object());
        // metodo get retorna o supertipo de String
        for (Object o : values) {
            System.out.println(o);
        }
    }

    /**
     * Uma interface que guarda um valor generico
     * */
    interface WrapperReference<T> {
        // ela nao possui metodos que recebem T como argumento
        // somente um metodo que retorna T
        T getValue();
    }

    private static void test(WrapperReference<String> wrapperReferenceString) {
        /**
         * WrapperReference tem apenas um metodo que retonar T getValue() e nenhum
         * metodo set. Mas o compilador nao permite a atribuicao -
         * WrapperReference<Object> wrapperReferenceObject = wrapperReferenceString;
         * */
        //WrapperReference<Object> wrapperReferenceObject = wrapperReferenceString;

        // ? == ? extends Object
        WrapperReference<?> wrapperReferenceObject = wrapperReferenceString;
        System.out.println(wrapperReferenceObject.getValue());;
    }

    public static void main(String[] args) {
        //testConsumers();
        test(() -> "Uma mensagem qualquer");
    }
}
