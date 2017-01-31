package uk.co.codeecho.gdx.forge.box2d.collision.event;

import uk.co.codeecho.gdx.forge.box2d.collision.Collision;

public class CollisionEndEvent extends CollisionEvent{

    public CollisionEndEvent(Collision collision) {
        super(collision);
    }
    
}
