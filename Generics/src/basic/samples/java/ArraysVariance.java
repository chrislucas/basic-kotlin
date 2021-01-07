package basic.samples.java;

/**
 *
 * Arrays em Java sao covariantes - subtipos podem ser substituidos por supertipos
 * https://www.logicbig.com/tutorials/core-java-tutorial/java-language/java-subtyping-rules.html
 * */

public class ArraysVariance {

    static class Box<T> {
        private final T value;
        Box(T value) {
            this.value = value;
        }
    }

    public static void sampleArrayVariance() {
        String [] strings = new String [] {"a", "b", "c"};
        // subtipo sendo substituido pelo supertipo
        Object [] objects = strings;
        // o qye pode ser perigoso
        objects[0] = new Box<String> ("Como causar um ArrayStoreException");
        System.out.println(objects[0]);

    }

    public static void main(String[] args) {
        sampleArrayVariance();
    }

}
