package sample;


/**
 * https://www.baeldung.com/java-type-erasure#edge-cases
 */
public class TypeErasureProcessEdgeCases {

    private static void testSegmentCompositeBuilder() {
        Composite<Segment> c = new CompositeBuilder<Segment>()
                .add(Segment.create(1, 1, 2, 3))
                .add(Segment.create(10, 1, 152, 3))
                .add(Segment.create(-10, 1, -152, 3))
                .build();
        if (c != null) {
            c.iterate(target -> {
                System.out.println(target.getData());
            });
        }
    }

    private static void testGenComposeBuilder() {
        CompositeSegment cs =
                new GenCompositeBuilder<Segment, CompositeSegment>()
                        .add(new CompositeSegment(Segment.create(1, 1, 2, 3)))
                        .add(new CompositeSegment(Segment.create(1, -1, 2, -3)))
                        .add(new CompositeSegment(Segment.create(-1, -1, -2, -3)))
                        .build();

        String format2Strings = "%s, %s\n";

        if (cs != null) {
            cs.iterate(target -> {
                System.out.printf(format2Strings, target, target.getData());
            });
        }

        /**
         * Edge cases
         * Abaixo segue um exemplo onde de um problema que pode ser percebido somente em tempo de execucao.
         *
         * A variável 'c' eh um super tipo de 'cs' porem 'c' nao foi parametrizado.  Todos os metodos
         * e atributos da instancia de 'c' que usam um tipo generico serao transformados em Object, tornando
         * o uso deles 'perigoso' numa situacao de tentativa de 'casting' por exemplo, podendo em tempo de execucao
         * causar um ClassCastingException.
         * Esse codigo ambiguo pode causar confusao para outros programadores
         *
         * Bridge Methods
         *
         * Para resolver o caso onde O processo de Type Erasure converte tipos genericos em Object
         * o compilador cria metodos sinteticos denomiados de 'bridge methods' que realizam conversoes explicitas
         *
         *      synthetic method or brigde methods
         *      public void push(Object value) {
         *         push((Integer)value);
         *     }
     *         public void push(Integer value) {
         *         super.push(value);
         *     }
         * */
        Composite c = cs;
        if (c != null) {
            CompositeBuilder builder
                    = new CompositeBuilder<Segment>(c);
            builder.add(Segment.create(12, 13, 14, 15));
            // nao paremetrizar o tipo de variavel nos permite fazer umas bizarrices
            // dessa como adicionar um objeto qualquer, pq no processo de Type Erasuer
            // o argumento Generico passado para o metodo torna-se um Object
            builder.add("10123");
            // ou isso
            builder.add(new Point2D(10, 23));

            c.iterate(target -> {
                // fazer o casting aqui eh perigoso, pois ja nao temos certeza do que adicionamos
                // no atributo data
                try {
                    Segment o = (Segment)  target.getData();
                    System.out.printf(format2Strings, target, o);
                } catch (ClassCastException classCastException) {
                    System.out.printf("\n%s\n", classCastException.getMessage());
                }
            });
            System.out.println("");

            // parametrizando na forma <Segment> nao sera mais possivel
            // inserir nada diferente de uma instancia de Segment
            CompositeBuilder<Segment> sdBuilder = new CompositeBuilder<>(c);

            sdBuilder.add(Segment.create(10,20,30,456));
            // A linha abaixo nao compila, como explicado acima
            //sdBuilder.add("00000")

            // mas como 'c' nao foi parametrizado, o argumento 'target' ainda eh um Object
            c.iterate( target ->  {
                Object o = target.getData();
                System.out.printf(format2Strings, target, o);
            });
        }
    }

    public static void main(String[] args) {
        testGenComposeBuilder();
    }

    static class Segment {
        private final Point2D a, b;

        private Segment(Point2D a, Point2D b) {
            this.a = a;
            this.b = b;
        }

        static Segment create(int x1, int y1, int x2, int y2) {
            return new Segment(new Point2D(x1, y1), new Point2D(x2, y2));
        }

        @Override
        public String toString() {
            return String.format("From %s to %s", a, b);
        }
    }

    static class Point2D {
        private final int x, y;

        Point2D(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return String.format("P(%d, %d)", x, y);
        }
    }
}
