package basics.regex;

/**
 * https://www.hackerrank.com/contests/find-google/challenges/find-google
 * */

public class FindGoogle {

    public static void main(String[] args) {
        System.out.println("Google".matches("/(g|G)((o|O|0)|(\\(\\))|(<>)){2}(g|G)(l|L|I)(e|E|3)/"));
        System.out.println("G<><>gle".matches("/(g|G)((o|O|0)|(\\(\\))|(<>)){2}(g|G)(l|L|I)(e|E|3)/"));

        System.out.println("Google".matches("(g|G).*"));
    }
}
