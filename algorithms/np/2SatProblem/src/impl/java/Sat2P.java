package impl.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Stack;

public class Sat2P {

    static class Node {
        int id;
        boolean state;
        Node(int id, boolean state) {
            this.id = id;
            this.state = state;
        }
        @Override
        public boolean equals(Object obj) {
            return id == ((Node) obj).id && ((Node) obj).state == state;
        }

        @Override
        public int hashCode() {
            return id;
        }

        @Override
        public String toString() {
            return String.format("%s%d", state ? "" : "¬", id);
        }
    }


    private static LinkedHashMap<Node, ArrayList<Node>> direct;
    private static LinkedHashMap<Node, ArrayList<Node>> inverse;
    private static Stack<Node> stack = new Stack<>();
    private static boolean [] visited;
    private static int [] components;
    private static int component = 1;


    static void dfs(Node s, int vars, boolean first, LinkedHashMap<Node, ArrayList<Node>> graph) {
        int id = s.state ? s.id : s.id + vars;
        if (visited[id])
            return;
        // ! s.state ? complemento : normal (~A, A)
        visited[id] = true;
        if (graph.keySet().contains(s))
            for (Node q : graph.get(s))
                dfs(q, vars,  first, graph);
        else
            return;
        if (first)
            stack.push(s);
        else
            components[id] = component;
    }

    static void add(Node p, Node q, LinkedHashMap<Node, ArrayList<Node>> graph) {
        if (graph.keySet().contains(p)) {
            graph.get(p).add(q);
        }
        else {
            graph.put(p, new ArrayList<>(Collections.singletonList(q)));
        }
    }

    static boolean isSatisfiable(Node a[], Node b [], int vars) {
        direct = new LinkedHashMap<>();
        inverse = new LinkedHashMap<>();
        for (int i = 0; i < a.length ; i++) {
            Node p = a[i];
            Node np = new Node(p.id, !p.state);
            Node q = b[i];
            Node nq = new Node(q.id, !q.state);
            add(np, q, direct);
            add(nq, p, direct);
            add(q, np, inverse);
            add(p, nq, inverse);
        }
        visited = new boolean[2*vars+1];
        for (Node p : direct.keySet()) {
            int id = p.state ? p.id : p.id + vars;
            if (!visited[id]) {
                dfs(p, vars,true, direct);
            }
        }
        visited = new boolean[2*vars+1];
        components = new int[2*vars+1];
        while (!stack.isEmpty()) {
            Node s = stack.pop();
            int id = s.state ? s.id : s.id + vars;
            if (!visited[id]) {
                dfs(s, vars, false, inverse);
                component++;
            }
        }

        for (int i = 1; i <= vars ; i++) {
            // se a variavel e o seu complemento estiverem no mesmo componente
            // nao existe combinacao que satisfaca
            if (components[i] == components[i+vars])
                return false;
        }

        return true;
    }

    static void run() {
        // The CNF being handled is:
        // '+' implies 'OR' and '*' implies 'AND'
        // a[0], b[0] = (x1+x2)*(x2’+x3)*(x1’+x2’)*(x3+x4)*(x3’+x5)*(x4’+x5’)*(x3’+x4)
        // a[1], b[1] (a∨¬b)∧(¬a∨b)∧(¬a∨¬b)∧(a∨¬c)

        Node a [][] = {
            {new Node(1, true), new Node(2, false), new Node(1, false), new Node(3, true), new Node(3, false), new Node(4, false), new Node(3, false)}
            ,{new Node(1, true), new Node(1, false), new Node(1, false), new Node(1, true)}
            ,{new Node(1, true), new Node(2, true), new Node(1, false)}
            ,{new Node(1, true), new Node(1, false), new Node(1, true), new Node(1, false)}
        };
        Node b [][] = {
            {new Node(2, true), new Node(3, true), new Node(2, false), new Node(4, true), new Node(5, true), new Node(5, false), new Node(4, true)}
            , {new Node(2, false), new Node(2, true), new Node(2, false), new Node(3, false)}
            , {new Node(2, true), new Node(1, false), new Node(2, false)}
            , {new Node(2, true), new Node(2, true), new Node(2, false), new Node(2, false)}
        };

        System.out.println(isSatisfiable(a[0], b[0], 5));
        System.out.println(isSatisfiable(a[1], b[1], 3));
        System.out.println(isSatisfiable(a[2], b[2], 2));
        System.out.println(isSatisfiable(a[3], b[3], 2));
    }

    public static void main(String[] args) {
        run();
    }

}
