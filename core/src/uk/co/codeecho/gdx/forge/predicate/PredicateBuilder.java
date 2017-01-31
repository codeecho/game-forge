package uk.co.codeecho.gdx.forge.predicate;

public class PredicateBuilder {

    private Predicate predicate;

    public PredicateBuilder(Predicate predicate) {
        this.predicate = predicate;
    }
    
    public PredicateBuilder and(Predicate predicate){
        this.predicate = new AndPredicate(this.predicate, predicate);
        return this;
    }
    
    public PredicateBuilder or(Predicate predicate){
        this.predicate = new OrPredicate(this.predicate, predicate);
        return this;
    }
    
    public Predicate build(){
        return predicate;
    }
    
}
