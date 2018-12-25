package basic;

public class BasicTestInvariance {

    /**
     * https://kotlinlang.org/docs/reference/generics.html
     * */

    interface Source<T> { T get(); void  receive(T t); }

    private static void test1(Source<String> source) {
        // isso nao eh permitido porque Generics sao Invariantes
        // nao podemos atribuit a um supertipo um subtipo
        //Source<Object> s = source;
        // ? == ? extends Object

        // usando o wildcar ? extends T nao podemos
        // usar um metodo que insere/escreve uma variavel 'T'
        Source<? extends CharSequence> s = source;
        Object str = s.get();
        System.out.println(str);
        // o objeto 's' eh so de leitura nao de escriva
        //s.receive();

        //source.receive("Test1 Source: 12132131");

        // para podermos usar um metodo na interface que
        // recebe 'T' como parametro precisamos do wildcard ? super T
        // porem um metodo na interface cuja assinatura retorne 'T'
        // so conseguiremos recuperar seu valor atraves do tipo Object
        Source<? super String> newSource = source;
        // o jeito mais seguro de recuperar o valor de um metodo que retonar
        // o Tipo generico 'T'
        Object str2 = newSource.get();
        System.out.println(str2);
        newSource.receive("Teste1 new Source");
    }

    private static void test2(Source<String> source) {
        Source<? super String> newSource = source;
        System.out.println(newSource.get());
        newSource.receive("Test2 New Source: teste");
    }

    public static void main(String[] args) {
        test1(new Source<String>() {
            @Override
            public String get() {
                return "Chris teste 1";
            }

            @Override
            public void receive(String s) {
                System.out.println(s);
            }
        });
        test2(new Source<String>() {
            @Override
            public String get() {
                return "Chris teste 2";
            }

            @Override
            public void receive(String s) {
                System.out.println(s);
            }
        });

    }
}
