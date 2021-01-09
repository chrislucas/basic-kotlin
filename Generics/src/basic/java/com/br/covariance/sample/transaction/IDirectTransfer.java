package basic.java.com.br.covariance.sample.transaction;

/**
 * Covariant return.
 * <p>
 * A interface 'B' eh uma especializacao da interface A e podemos
 * sobreescrever o metodo get() e retornarmos um subtipo do
 * retorno do metodo get() da interface 'A'
 */
interface IDirectTransfer extends IBaseTransfer {
    FastTransaction get();
    // Object | String | Integer ... get(); exemplos do que nao pode ser feito
}
