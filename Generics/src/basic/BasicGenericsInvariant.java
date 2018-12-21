package basic;

import java.util.ArrayList;
import java.util.List;

public class BasicGenericsInvariant {

    /**
     * Linguagens de programacao possuem regras para casting/conversao subtipos de classe,
     * uma delas e a invariancia que é a proibicao de trocar um subtipo por um supertipo
     * ou vice-versa.
     *
     * Generics em Java sao invariantes, para evitar conversoes de tipos que nao sao compativeis
     * */

    private static void testInvariace() {
        // exemplo da invariancia de Generics
        List<Integer> ints = new ArrayList<>();
        ints.add(0xff);
        ints.add(0xff00ff);
        ints.add(0xffffff);
        ints.add(0xffffffff);
        // a linha abaixo nao compila, pois nao podemos
        // definir uma lista de um supertipo atraves de uma lista de subtipo
        //List<Number> numbers = ints;

        /**
         * Para fazer com que um tipo generico torne-se covariante e assim seja possivel
         * substituir um subtipo por um supertipo usamos o wildcard '? extends'
         * */
        List<? extends Number> numbers = ints;
        // o problema de realizar isso eh que nao conseguimos adicionar
        // nenhum subtipo de Number a lista, gerando um erro de compilacao
        // Isso ocorre porque o compilador não consegue saber para qual tipo
        // essa lista foi originalmente construida
    }


    static void testCovariance() {
        /**
         * Contravariante: Criar uma lista onde podemos adicionar
         * elementos cuja sua super classe seja a denominada em '? super T'
         *
         * Podemos adicionar quaisquer tipos que sejam especializacoes de Number
         * o do tipo de Number, mas ao recuperar os valores da lista, num loop
         * ou numa declaracao, obtemos uma instancia de Object
         * */
        List<? super Number> ns = new ArrayList<>();
        Number a = 15.0f;
        ns.add(10);
        ns.add(12);
        ns.add(15);
        ns.add(15.0);
        ns.add(12.45);
        ns.add(12.3F);
        ns.add(a);

        // Object o = ns.get(0);

        // como em tempo de execucao a VM nao sabe qual o subtipo que foi
        // inserido na lista, ao iterarmos sobre ela temos que usar o tipo
        // mais generico possivel, Object

        for (Object n : ns) {
            System.out.printf("%s %s\n", n instanceof Float, n);
        }

        // A declaracao abaixo cria uma lista de objetos
        // que sao especializacoes da classe Number, porem
        // como ela pemitiria em tempo de execucao que pudessemos
        // adicionar varios tipos diferentes de instancia que sao
        // especializacoes de Number e nao ha como prever no programa
        // quantas e quais sao. Assim essa declaracao nao permite
        // que usemos o metodo add(? extends Number)
        List<? extends Number> ns2 = new ArrayList<>();
        //ns2.add(10);
        //ns2.add(10.0);
        // Recuperamos um objeto do tipo Number, Object ou podemos fazer um cast
        // correr o risco do programa lançar uma excecao
        // Number n = ns2.get(0);


        //ns.forEach(o -> System.out.println(o instanceof Float));
    }

    static void testCovariance2() {
        List<? super CharSequence> list = new ArrayList<>();
        CharSequence charSequence = "Teste 123";
        list.add("Christoffer Lucas");
        list.add(charSequence);
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        testCovariance2();
    }
}
