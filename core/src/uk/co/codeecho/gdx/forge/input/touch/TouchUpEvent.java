package uk.co.codeecho.gdx.forge.input.touch;

import com.badlogic.gdx.math.Vector2;

public class TouchUpEvent extends TouchEvent{

    public TouchUpEvent(Vector2 coordinates, int pointer, int button) {
        super(coordinates, pointer, button);
    }

}
