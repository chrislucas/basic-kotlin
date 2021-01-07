package basic.samples.java;

/**
 * https://www.logicbig.com/tutorials/core-java-tutorial/java-language/covariant-returns.html
 * https://stackoverflow.com/questions/18666710/why-are-arrays-covariant-but-generics-are-invariant
 *
 * Quando utilizamos heranças entre interface ou classes podemos sobreescer os metodos da SuperClass
 * na SubClasse tal que seu retorno seja mais 'Especifico'. Metodos sobreescritos cujo retorno eh mais
 * especifico sao denominados de 'Retorno Covariante'.
 *
 * Resumindo, subclasses podem sobreescrever metodos de suas SuperClasses de forma que tais metodos
 * retornem um tipo mais espefico, esse recurso nao pode ser usado para retornar outros tipos que nao
 * subtipos do Tipo que o metodo na super classe retorna
 *
 * */
public class BasicCovariantReturn {

    static class Transaction { }
    static class Deposit extends Transaction {}

    interface A {
        Transaction get();
    }

    /**
     * Covariant return.
     *
     * A interface 'B' eh uma especializacao da interface A e podemos
     * sobreescrever o metodo get() e retornarmos um subtipo do
     * retorno do metodo get() da interface 'A'
     * */
    interface B extends A {
        Deposit get();
        // Object | String | Integer ... get(); exemplos do que nao pode ser feito
    }

    public static void main(String[] args) {
        B b = new B() {
            @Override
            public Deposit get() { return new Deposit(); }
        };

        A ab = new B() {
            @Override
            public Deposit get() { return new Deposit(); }
        };

        A a = new A() {
            @Override
            public Transaction get() { return new Transaction(); }
        };

        System.out.println(b.get());
        System.out.println(ab.get());
        System.out.println(a.get());
    }
}
