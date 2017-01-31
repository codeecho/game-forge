package uk.co.codeecho.gdx.forge.box2d.collision.event;

import uk.co.codeecho.gdx.forge.box2d.collision.Collision;

public class CollisionStartEvent extends CollisionEvent {

    public CollisionStartEvent(Collision collision) {
        super(collision);
    }

}
