package basics.interop;


import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.CharBuffer;

public class Test {

    /**
     * Um teste maluco com anonymous class
     * */
    public interface Run extends Runnable, Comparable, Readable {
        void execute();
    }

    public static void main(String[] args) {
        Run run = new Run () {
            @Override
            public void execute() {

            }

            @Override
            public int compareTo(@NotNull Object o) {
                return 0;
            }

            @Override
            public void run() {

            }

            @Override
            public int read(@NotNull CharBuffer cb) throws IOException {
                return 0;
            }
        };
    }
}
