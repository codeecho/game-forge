package uk.co.codeecho.gdx.forge.library.predicate;

import uk.co.codeecho.gdx.forge.library.state.Direction;
import uk.co.codeecho.gdx.forge.library.state.Directional;
import uk.co.codeecho.gdx.forge.predicate.Predicate;

public class DirectionEqualsPredicate implements Predicate<Directional>{

    private Direction direction;

    public DirectionEqualsPredicate(Direction direction) {
        this.direction = direction;
    }
    
    @Override
    public boolean evaluate(Directional object) {
        return direction.equals(object.getDirection());
    }

}
