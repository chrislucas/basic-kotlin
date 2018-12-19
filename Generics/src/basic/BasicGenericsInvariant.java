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

    public static void main(String[] args) {
        // exemplo da invariancia de Generics

        List<Integer> ints = new ArrayList<>();
        ints.add(0xff);
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
}
