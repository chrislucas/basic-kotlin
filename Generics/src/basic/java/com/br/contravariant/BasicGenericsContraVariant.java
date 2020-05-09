package basic.java;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.logicbig.com/tutorials/core-java-tutorial/java-language/java-subtyping-rules.html
 * */

public class BasicGenericsContraVariant {

    /**
     * A regra de contravariance permite a substituicao do supertipo pelo subtipo
     * */

    // transacao bancaria
    static class Transaction {}

    // saque de dinheiro
    static class SavingAccountWithDrawal extends Transaction { }

    static class Deposit extends Transaction { }

    static class WithDrawalCurrentAccount extends SavingAccountWithDrawal { }

    private static void testContravariance() {
        List<? super String> objs = new ArrayList<>();
        //Object object = new Object();
        //objs.add(object);
        // so podemos adicionar string
        objs.add("Teste");
        objs.add("123");
        // e recuperar objects
        String str = (String) objs.get(0);
        System.out.println(str);
    }

    private static void testInvarianceInGenericType() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction() {});
        transactions.add(new Deposit() {});

        /**
         * Com o wildcar ? super T podemos tornar um tipo generico em contravariante
         * permitindo definir um subtipo usando o seu supertipo.
         * Entretando ao usar o wildcard ? super o compilador nao
         * sabera de qual supertipo estamos falando (Podendo ser por exemplo Object), assim nao podemos adicionar
         * a uma lista<? super T> um elemento T ou qualquer subtipo de T
         * */
        List<? super SavingAccountWithDrawal> withDrawals = transactions;
        withDrawals.add(new SavingAccountWithDrawal());
        withDrawals.add(new SavingAccountWithDrawal());
        withDrawals.add(new SavingAccountWithDrawal());

        // Funciona
        //Transaction t = (Transaction) withDrawals.get(0);


        // Nao podemos adicionar a lista a lista um outro tipo que nao SavingAccountWithDrawal
        // withDrawals.add(new Deposit())
        // Nem uma instancia de Transaction
        // withDrawals.add(new Transaction());
        for (Object w : withDrawals) {
            System.out.println(w);
        }
    }

    /**
     * Explicacao de porque Arrays em Java sao Covariantes
     * https://en.wikipedia.org/wiki/Covariance_and_contravariance_%28computer_science%29#Covariant_arrays_in_Java_and_C.23
     *
     * Em suma, permitir que arrays sejam covariantes permite escrever funcoes uteis genericas para arrays de qualquer tipo.
     *  Por exemplo: uma funcao que embaralha a ordem dos elementos de um array pode ter essa assinatura
     *  embaralhar(Object[] values)
     *
     *  Note que embaralhar de forma pseudoaleatoria os elementos do array independe do valor armazenado no array
     *  e com essa assinatura acima podemos passar qualquer array. Se fosse diferente disso teriamos que rescrever
     *  essa funcao toda vez que tivermos um array de um tipo novo
     *
     * */

    private static void testConvarianceInArrays() {
        // Arrays sao covariantes, ou seja
        // Um Array de um supertipo aceita ser definido por um Array de um subtipo

        Integer [] values = new Integer[10];
        values[0] = 10;
        values[1] = 15;
        // Isso eh possivel
        Number [] numbers = values;
        // porem gera problemas ... java.lang.ArrayStoreException:
        // antes era um array de inteiros, mas ao atribui-lo a
        // um array de Numbers, pudemos atribuir a um dos indices um numero com ponto flutuante
        //numbers[2] = 2.0;
        //numbers[2] = 10/5;
        //
        System.out.println(numbers);


        String [] strs = new String[10];
        strs[0] = "Christoffer";
        Object [] objects = strs;
        // ArrayStoreException
        //objects[1] = 10;

        System.out.println(objects);
    }

    public static void main(String[] args) {
        testContravariance();
    }
}
