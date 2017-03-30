package uk.co.codeecho.gdx.forge.library.event.box2d;

import com.badlogic.gdx.physics.box2d.Fixture;
import uk.co.codeecho.gdx.forge.event.Event;

public class FixtureTouchEvent implements Event{

    private final Fixture fixture;

    public FixtureTouchEvent(Fixture fixture) {
        this.fixture = fixture;
    }

    public Fixture getFixture() {
        return fixture;
    }
    
}
