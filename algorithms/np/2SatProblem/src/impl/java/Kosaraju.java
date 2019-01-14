package impl.java;

import java.util.ArrayList;
import java.util.Stack;

public class Kosaraju {

    private static ArrayList<ArrayList<Integer>> direct = new ArrayList<>();
    private static ArrayList<ArrayList<Integer>> reverse = new ArrayList<>();

    private static Stack<Integer> stack = new Stack<>();

    private static boolean [] visited;

    static void init(int vertices) {
        for (int i = 0; i < vertices; i++) {
            direct.add(new ArrayList<>());
            reverse.add(new ArrayList<>());
        }
    }

    static void dfs(int source, boolean first, ArrayList<ArrayList<Integer>> graph) {
        if (visited[source])
            return;
        visited[source] = true;
        for (int destiny : graph.get(source))
            dfs(destiny, first,  graph);
        if (first)
            stack.add(source);
    }

    static void addEdge(int p, int q) {
        direct.get(p).add(q);
        reverse.get(q).add(p);
    }

    static int components(int vertices) {
        visited = new boolean[vertices];
        init(vertices);
        addEdge(1, 0);
        addEdge(0, 2);
        addEdge(2, 1);
        addEdge(0, 3);
        addEdge(3, 4);
        dfs(0, true, direct);
        int acc = 0;
        visited = new boolean[vertices];
        while (!stack.isEmpty()) {
            int source = stack.pop();
            if (!visited[source]) {
                dfs(source, false, reverse);
                acc++;
            }
        }
        return acc;
    }

    public static void main(String[] args) {
        System.out.println(components(5));
    }
}
