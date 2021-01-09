package basic.java.com.br.covariance.sample.transaction;

class FastSafeTransfer implements IBaseTransfer {
    // Retorno covariante em um subtipo de IBaseTransfer
    @Override
    public SafeFastTransaction get() {
        return new SafeFastTransaction();
    }
}
