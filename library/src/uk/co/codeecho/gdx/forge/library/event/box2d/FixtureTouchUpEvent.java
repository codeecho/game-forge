package uk.co.codeecho.gdx.forge.library.event.box2d;

import com.badlogic.gdx.physics.box2d.Fixture;

public class FixtureTouchUpEvent extends FixtureTouchEvent{

    public FixtureTouchUpEvent(Fixture fixture) {
        super(fixture);
    }

}
