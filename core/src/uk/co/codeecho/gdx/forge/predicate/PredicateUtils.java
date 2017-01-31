package uk.co.codeecho.gdx.forge.predicate;

public class PredicateUtils {

    public static PredicateBuilder when(Predicate predicate) {
        return new PredicateBuilder(predicate);
    }

}
