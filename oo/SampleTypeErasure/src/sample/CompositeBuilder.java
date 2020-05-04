package sample;

class CompositeBuilder<E> {
    private Composite<E> node;

    CompositeBuilder() {}

    // ajuda a inserir dados num Compose ja existente
    CompositeBuilder(Composite<E> node) {
        this.node = node;
    }

    CompositeBuilder<E> add(E data) {
        if (node == null) {
            node = new Composite<>(data);
        } else {
            addNext(node, new Composite<>(data));
        }
        return this;
    }

    private void addNext(Composite<E> prev, Composite<E> next) {
        Composite<E> pn = prev.getNext();
        if (pn == null) {
            prev.setNext(next);;
        } else {
            addNext(pn, next);
        }
    }

    Composite<E> build() {
        return node;
    }
}
