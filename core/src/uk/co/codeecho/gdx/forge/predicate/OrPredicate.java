package uk.co.codeecho.gdx.forge.predicate;

public class OrPredicate implements Predicate<Object> {

    private Predicate predicate1;
    private Predicate predicate2;

    public OrPredicate(Predicate predicate1, Predicate predicate2) {
        this.predicate1 = predicate1;
        this.predicate2 = predicate2;
    }

    @Override
    public boolean evaluate(Object object) {
        return predicate1.evaluate(object) || predicate2.evaluate(object);
    }

}
