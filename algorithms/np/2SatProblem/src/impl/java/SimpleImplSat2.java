package impl.java;

import java.util.ArrayList;
import java.util.Stack;

public class SimpleImplSat2 {

    private static ArrayList<ArrayList<Integer>> direct;
    private static ArrayList<ArrayList<Integer>> reverse;
    private static Stack<Integer> vertices = new Stack<>();
    private static boolean [] visited;
    private static int [] components;
    private static int component = 1;

    private static void initGraph(int qVars) {
        direct = new ArrayList<>();
        reverse = new ArrayList<>();
        for (int i = 0; i<qVars*2+1; i++) {
            direct.add(new ArrayList<>());
            reverse.add(new ArrayList<>());
        }
    }

    private static void dfs(int source, boolean first, ArrayList<ArrayList<Integer>> graph) {
        if (visited[source])
            return;
        visited[source] = true;
        for (int destiny : graph.get(source))
            dfs(destiny, first, graph);
        if (first)
            vertices.add(source);
        else
            components[source] = component;
    }

    /**
     * int p, q sao as variaveis na clausala logica (a ou b)
     * int qVars e a quantidade de variaveis que existem na expressao
     * logica na forma normal conjuntiva (a ou b) e (¬a ou b)
     *
     * a e b podem ser positivos ou negativos. se positivo correspondem
     * ao valor TRUE na expressao logica, do contrario FALSE
     *
     * Assim iremos representar o complemento de a (~a)
     * da seguinte forma:
     *
     * se a > 0 (TRUE) entao a + qVars (FALSE)
     * se a < 0 (FALSE) entao -a (TRUE)
     *
     * apos adicionar os vertices, aqueles que tiverem valor
     * > que qVars sao os valores de complementos
     * */
    private static void addEdge(int a, int b, int qVars) {
        // transformar  (a ou b) em ~a -> b & ~b -> a
        if (a > 0 && b > 0) {
            // ~a -> b
            direct.get(a + qVars).add(b);
            // b -> ~a
            reverse.get(b).add(a + qVars);
            // ~b -> a
            direct.get(b + qVars).add(a);
            // a -> ~b
            reverse.get(a).add(b + qVars);
        }
        // transforma (a ou ~b) em  ~a -> b & ~b -> a que nesse caso = ~a -> ~b e ~(~b) -> a
        else if (a > 0 && b < 0) {
            // ~a -> b
            direct.get(a+qVars).add(qVars-b);
            // b -> ~a
            reverse.get(qVars-b).add(a+qVars);
            // ~b -> a
            direct.get(-b).add(a);
            // a -> ~b
            reverse.get(a).add(-b);
        }
        // transforma (~a ou b) em ~a -> b & ~b -> a que nesse caso ~(~a) -> b e ~b -> ~a := a -> b e ~b -> ~a
        else if (a < 0 && b > 0) {
            direct.get(-a).add(b);
            reverse.get(b).add(-a);
            direct.get(b+qVars).add(qVars - a);
            reverse.get(qVars - a).add(b+qVars);
        }
        // transforma (~a ou ~b) em ~a -> b & ~b -> a que nesse caso ~(~a) -> ~b e ~(~b) -> ~a := a -> ~b e b -> ~a
        else {
            direct.get(-a).add(qVars-b);
            reverse.get(qVars-b).add(-a);
            direct.get(-b).add(qVars-a);
            reverse.get(qVars-a).add(-b);
        }
    }

    private static boolean is2Satisfiable(int a [], int b [], int qVars) {
        initGraph(qVars);
        for (int i = 0; i < a.length ; i++) {
            addEdge(a[i], b[i], qVars);
        }
        /**
         * Como transformamos a ou b em  (¬a -> b) e (¬b -> a)
         * demos o dobro de variaveis. Como cada variavel sera um
         * vertice do nosso grafo precisamos de um vetor qVars * 2
         **/
        int allVars= qVars * 2 + 1;
        visited = new boolean[allVars];
        for (int i = 1; i < allVars; i++) {
            if (!visited[i])
                dfs(i, true, direct);
        }
        visited = new boolean[allVars];
        components = new int[allVars];
        while (!vertices.isEmpty()) {
            int s = vertices.pop();
            if (!visited[s]) {
                dfs(s, false, reverse);
                component++;
            }
        }
        for (int i = 1; i < qVars ; i++) {
            // se a e ~a estiverem no mesmo componente
            // nao existe uma combinacao que faça a expressão boolean ser verdadeira
            if (components[i] == components[i+qVars])
                return false;
        }
        return true;
    }

    private static void run() {
        // [0] => (x1+x2)*(x2’+x3)*(x1’+x2’)*(x3+x4)*(x3’+x5)*(x4’+x5’)*(x3’+x4)
        // [1] => (1+2) * (2+1') * (1'+2')
        // [2] => (1+2) * (1'+2) * (1+2') * (1'+2')
        int [][] a = {
              {1, -2, -1, 3, -3, -4, -3}
            , {1, 2, -1}
            , {1, -1, 1, -1}
        };
        int [][] b = {
             {2, 3, -2, 4, 5, -5, 4}
            ,{2, -1, -2}
            ,{2, 2, -2, -2}
        };
        System.out.println(is2Satisfiable(a[0], b[0], 5));
        System.out.println(is2Satisfiable(a[1], b[1], 2));
        System.out.println(is2Satisfiable(a[2], b[2], 2));
    }

    public static void main(String[] args) {
        run();
    }
}
