package uk.co.codeecho.gdx.forge.box2d.body.builder;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

public abstract class AbstractBodyBuilder<B extends AbstractBodyBuilder> {

    private final World world;
    private final BodyDef bodyDef = new BodyDef();
    private String id;
    private String type;

    public AbstractBodyBuilder(World world, BodyDef.BodyType bodyType) {
        this.world = world;
        bodyDef.type = bodyType;
    }

    public B setPosition(Vector2 position) {
        bodyDef.position.set(position);
        return (B) this;
    }
    
    public B setPosition(float x, float y) {
        bodyDef.position.set(new Vector2(x, y));
        return (B) this;
    }
    
    public B setLinearDamping(float damping){
        bodyDef.linearDamping = damping;
        return (B) this;
    }
    
    
    public B setId(String id) {
        this.id = id;
        return (B) this;
    }

    public B setType(String type) {
        this.type = type;
        return (B) this;
    }

    public Body build() {
        Body body = world.createBody(bodyDef);
        body.setUserData(new Box2DMetaData(id, type));
        return body;
    }
    
}
