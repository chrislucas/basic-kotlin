package sample;


/**
 * https://www.baeldung.com/java-type-erasure#edge-cases
 */
public class TypeErasureProcessEdgeCases {

    private static void testSegmentCompositeBuilder() {
        TypeErasureProcess.Composite<Segment> c = new TypeErasureProcess.CompositeBuilder<Segment>()
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
                new TypeErasureProcess.GenCompositeBuilder<Segment, CompositeSegment>()
                        .add(new CompositeSegment(Segment.create(1, 1, 2, 3)))
                        .add(new CompositeSegment(Segment.create(1, -1, 2, -3)))
                        .add(new CompositeSegment(Segment.create(-1, -1, -2, -3)))
                    .build();

        if (cs != null) {
            cs.iterate(target -> {
                //System.out.printf("%s, %s\n", target, target.getData());
            });
        }

        /**
         * Edge cases
         * */
        TypeErasureProcess.Composite c = cs;
        if (c != null) {
            TypeErasureProcess.CompositeBuilder builder
                    = new TypeErasureProcess.CompositeBuilder<Segment>(c);
            builder.add(Segment.create(12,13,14,15));
            // nao paremetrizar o tipo de variavel nos permite fazer umas bizarrices
            // dessa como adicionar um objeto qualquer, pq no processo de Type Erasuer
            // o argumento Generico passado para o metodo torna-se um Object
            builder.add("10123");
            // ou isso
            builder.add(new Point2D(10,23));

            c.iterate(target -> {
                // fazer o casting aqui eh perigoso, pois ja nao temos certeza do que adicionamos
                // no atributo data
                Object o = target.getData();
                System.out.printf("%s, %s\n", target, o);
            });

        }
    }

    public static void main(String[] args) {
        testGenComposeBuilder();
    }

    static class CompositeSegment extends TypeErasureProcess.Composite<Segment> {
        CompositeSegment(Segment data) {
            super(data);
        }
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
