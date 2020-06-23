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
     *
     * Assinatura do metodo abaixo compilado
     *   private static findEquals(Ljava/util/List;Ljava/lang/Comparable;)Ljava/lang/Comparable;
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
            System.out.printf("%s, %s\n", target, target.getData());
        });
    }

}
