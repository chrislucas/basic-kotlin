package sample;

/**
 * Algoritmo besta para resolver um problema besta de um meme besta :)
 * */

public class Meme {
    public static void main(String[] args) {
        int lines = 100;
        int inLine = 4;
        int acc = 3;
        System.out.println(1);
        int i = 1;
        while ( i < lines ) {
            int copy = inLine;
            int j = 0;
            while (j <= i) {
                System.out.printf("%d ", copy);
                j++;
                if (j <= i)
                    copy+=2;
            }
            System.out.println("");
            inLine = copy + acc;
            acc++;
            i++;
        }
    }
}
