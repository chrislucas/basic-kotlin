package basic.java.com.br.covariance.sample.transaction;

class SafeFastTransaction extends FastTransaction {
    @Override
    public String toString() {
        return "I'm a safe fast transaction";
    }
}
