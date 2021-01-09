package basic.java.com.br.covariance.sample.transaction;

import static java.lang.System.*;

/**
 * https://www.logicbig.com/tutorials/core-java-tutorial/java-language/covariant-returns.html
 * https://stackoverflow.com/questions/18666710/why-are-arrays-covariant-but-generics-are-invariant
 * <p>
 * Quando utilizamos heranças entre interface ou classes podemos sobreescer os metodos da SuperClass
 * na SubClasse tal que seu retorno seja mais 'Especifico'. Metodos sobreescritos cujo retorno eh mais
 * especifico sao denominados de 'Retorno Covariante'.
 * <p>
 * Resumindo, subclasses podem sobreescrever metodos de suas SuperClasses de forma que tais metodos
 * retornem um tipo mais espefico, esse recurso nao pode ser usado para retornar outros tipos que nao
 * subtipos do Tipo que o metodo na super classe retorna
 */
public class BasicCovariantReturn {

    public static void main(String[] args) {
        IDirectTransfer directFastTransfer = FastTransaction::new;

        IBaseTransfer fastTransaction = FastTransaction::new;

        IBaseTransfer anotherDirectTransfer = new IDirectTransfer() {
            @Override
            public FastTransaction get() {
                return new FastTransaction();
            }
        };
        IBaseTransfer baseTransaction = BaseTransaction::new;

        IBaseTransfer safeTransfer = new FastSafeTransfer();

        out.println(directFastTransfer.get());
        out.println(anotherDirectTransfer.get());
        out.println(fastTransaction.get());
        out.println(baseTransaction.get());

        out.println(safeTransfer.get());
    }
}
