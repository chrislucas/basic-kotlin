package basic.samples.java;


public class Array<T> {
    private T array[];
    private int capacity = 0;

    Array() {
        this(1);
    }

    Array(int capacity) {
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    public void add(T value) {
        if (capacity == array.length) {
            resize();
        }
        array[capacity++] = value;

    }

    private void resize() {

    }
}
