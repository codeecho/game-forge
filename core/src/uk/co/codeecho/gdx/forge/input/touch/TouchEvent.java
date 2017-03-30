package uk.co.codeecho.gdx.forge.input.touch;

import com.badlogic.gdx.math.Vector2;
import uk.co.codeecho.gdx.forge.event.Event;

public class TouchEvent implements Event{

    private final Vector2 coordinates;
    private final int pointer;
    private final int button;

    public TouchEvent(Vector2 coordinates, int pointer, int button) {
        this.coordinates = coordinates;
        this.pointer = pointer;
        this.button = button;
    }

    public Vector2 getCoordinates() {
        return coordinates;
    }

    public int getPointer() {
        return pointer;
    }

    public int getButton() {
        return button;
    }
    
}
