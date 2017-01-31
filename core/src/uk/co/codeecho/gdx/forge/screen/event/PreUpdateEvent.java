package uk.co.codeecho.gdx.forge.screen.event;

import uk.co.codeecho.gdx.forge.event.Event;

public class PreUpdateEvent implements Event {

    private float delta;

    public PreUpdateEvent(float delta) {
        this.delta = delta;
    }

    public float getDelta() {
        return delta;
    }

}
