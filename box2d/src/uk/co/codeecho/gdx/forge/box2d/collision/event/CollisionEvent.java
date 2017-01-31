package uk.co.codeecho.gdx.forge.box2d.collision.event;

import uk.co.codeecho.gdx.forge.box2d.collision.Collision;
import uk.co.codeecho.gdx.forge.event.Event;

public abstract class CollisionEvent implements Event{

    private final Collision collision;

    public CollisionEvent(Collision collision) {
        this.collision = collision;
    }

    public Collision getCollision() {
        return collision;
    }
}
