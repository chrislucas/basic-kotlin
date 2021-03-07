package sample;

class GenCompositeBuilder<E, C extends Composite<E>>  {
    private C node;
    GenCompositeBuilder<E, C> add(C compose) {
        if (node == null) {
            node = compose;
        } else {
            addNext(node, compose);
        }
        return this;
    }

    /**
     * Como C foi limitado a ser uma subclasse de Composite a assinatura
     * do metodo compilado fica:
     *
     *   private addNext(Lsample/Composite;Lsample/Composite;)V
     * */
    private  void addNext(C prev, C next) {
        C pn = (C) prev.getNext();
        if (pn == null) {
            prev.setNext(next);
        } else {
            addNext(pn, next);
        }
    }

    C build() {
        return node;
    }
}