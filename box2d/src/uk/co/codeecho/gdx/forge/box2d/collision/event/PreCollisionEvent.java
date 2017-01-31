package uk.co.codeecho.gdx.forge.box2d.collision.event;

import uk.co.codeecho.gdx.forge.box2d.collision.Collision;

public class PreCollisionEvent extends CollisionEvent{

    public PreCollisionEvent(Collision collision) {
        super(collision);
    }

}
