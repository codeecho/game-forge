package uk.co.codeecho.gdx.forge.box2d.world;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.World;
import uk.co.codeecho.gdx.forge.box2d.collision.WorldCollisionListener;

public class WorldBuilder {

    private Vector2 gravity = new Vector2(0, 0);
    private ContactListener contactListener = new WorldCollisionListener();
    private boolean doSleep = true;
    
    public WorldBuilder setGravity(Vector2 gravity){
        this.gravity = gravity;
        return this;
    }
    
    public WorldBuilder setContactListener(ContactListener contactListener){
        this.contactListener = contactListener;
        return this;
    }
    
    public World build(){
        World world = new World(gravity, doSleep);
        world.setContactListener(contactListener);
        return world;
    }
    
}
