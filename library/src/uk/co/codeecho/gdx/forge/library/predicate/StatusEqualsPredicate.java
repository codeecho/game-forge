package uk.co.codeecho.gdx.forge.library.predicate;

import uk.co.codeecho.gdx.forge.library.state.Stateful;
import uk.co.codeecho.gdx.forge.predicate.Predicate;

public class StatusEqualsPredicate implements Predicate<Stateful>{

    private String state;

    public StatusEqualsPredicate(String state) {
        this.state = state;
    }
    
    @Override
    public boolean evaluate(Stateful object) {
        return state.equals(object.getState());
    }

}
