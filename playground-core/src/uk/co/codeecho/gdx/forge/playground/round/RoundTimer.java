package uk.co.codeecho.gdx.forge.playground.round;

import uk.co.codeecho.gdx.forge.component.Renderable;
import uk.co.codeecho.gdx.forge.library.mvc.Controller;
import uk.co.codeecho.gdx.forge.mutable.MutableFloat;

public class RoundTimer extends Controller<Renderable> {
    
    private final MutableFloat roundTime;

    public RoundTimer(Renderable view, MutableFloat roundTime) {
        super(view);
        this.roundTime = roundTime;
    }

    @Override
    public void update(float delta) {
        roundTime.subtract(delta);
        super.update(delta);
    }

}
