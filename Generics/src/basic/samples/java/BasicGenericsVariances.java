package basic.samples.java;

public class BasicGenericsVariances {

    /**
     * https://www.logicbig.com/tutorials/core-java-tutorial/java-language/java-subtyping-rules.html
     * */

    static class Box<T> {
        private final T value;

        public Box(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }
    }

    private static void sampleGenericsAreInvariant() {
        Box<String> boxText = new Box<>("Afim de evitar um Store Exception, generics sao invariantes");
        Box<CharSequence> boxCharSequence = new Box<>("Um objeto qualquer");
        // a linha abaixo nao compila, pois em java nao eh possivel substituir um tipo parametrizavel A por B
        // mesmo que seus parametros R e S sejam respectivamente supertipo e subtipo
        //boxObject = boxText;
    }

    interface Behavior {
        void execute();
    }

    /**
     * Generics com wildcard ? extends sao contravariantes
     * */
    private static void sampleGenericsWithWildCard() {
        Box<String> boxText = new Box<>("It is me");
        Box<? extends CharSequence> boxCharSequence = boxText;
        System.out.println(boxCharSequence.value);
    }

    public static void main(String[] args) {
        sampleGenericsAreInvariant();
        sampleGenericsWithWildCard();
    }
}
