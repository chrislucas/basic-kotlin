package basics.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.hackerrank.com/contests/find-google/challenges/find-google
 * */

public class FindGoogle {
    //private static final String regexV1 = "(g|G)((o|0|O)|(<>)|(\\(\\))|(\\[\\])){2}(g|G)(l|L|I)(e|E|3)";
    private static final String regexV2 = "(g|G)((0|O|o)|(\\[\\])|(<>)|(\\(\\))){2}(g|G)(l|L|I)(e|E|3)";
    private static  void test() {
        String [][] strs = {
                {
                        "Google"
                        , "Go0gle"
                        , "google"
                        , "GOOGLE"
                        , "GOOGL3"
                        , "GOOGI3"
                        , "GOOgl3"
                        , "GOOGl3"
                        , "G00Gl3"
                        , "G()()Gl3"
                        , "G()()Gle"
                        , "G()()gle"
                        , "g()()gle"
                        , "g<>()gle"
                        , "g<><>gle"
                        , "g<>()()gle"
                        , "g<>()()Gle"
                        , "g()()()Gle"
                        , "g0()()Gle"
                        , "gG0()()Gle"
                        , "gG0()()Gl3"
                        , "gG0()()GlE3"
                        , "gG0()0GlE3"
                        , "G()0Gl3"
                        , "G00gle"
                        , "GOOgle"
                        , "G<><>gle"
                        , "G<><>gle"
                        , "G0()gle"
                        , "G()<>gle"
                        , "G()0gle"
                        , "Go<>gle"
                        , "go<>Gle"
                        , "G<>Ogle"
                        , "Go<><>gle"
                        , "GoO<>gle"
                        , "GoOgle"
                        , "G0Ogle"
                        , "g0OGl3"
                        , "g0OGI3"
                        , "G0OGI3"
                        , "G0OGIE"
                        , "G0<>gIE"
                        , "GO<>gIE"
                        , "google"
                        , "g()()GI3"
                }
                ,{"g0oGle", "g00gle", "g<>0gl3", "GooGIe", "googl3", "g[]0gle"}
        };


        printTest(strs[1], regexV2);
    }

    private static void printTest(String [] strs, String regex) {
        for (String str : strs) {
            System.out.printf("%s %s\n", str, str.matches(regex));
        }
    }

    private static void test2() {
        String [][] strings = {
            {
                "G[][]gle"
                    ,"G[]0gl3"
                    ,"G[]0Gl3"
                    ,"GO[]GLE"
                    ,"Go[]GI3"
                    ,"G0[]Gle"
                    ,"G<>[]Gle"
                    ,"G<><>Gle"
                    ,"G[]0Gle"
                    ,"G[]<>Gle"
                    ,"G[]<>Gl3"
                    ,"G[]<>GL3"
                    ,"G[]<>gL3"
                    ,"g[]<>gL3"
            }
        };

        printTest(strings[0], regexV2);
    }

    private static void run() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println( bufferedReader.readLine().matches(regexV2));
        } catch (IOException ignore) { }
    }

    public static void main(String[] args) {
        test();
        test2();
    }
}
