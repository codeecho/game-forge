package uk.co.codeecho.gdx.forge.box2d.fixture.builder;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Shape;
import uk.co.codeecho.gdx.forge.box2d.body.builder.Box2DMetaData;

public abstract class AbstractFixtureBuilder<B extends AbstractFixtureBuilder> {

    private FixtureDef fixtureDef = new FixtureDef();
    private String id;

    public B setShape(Shape shape) {
        fixtureDef.shape = shape;
        return (B) this;
    }

    public B isSensor(boolean isSensor) {
        fixtureDef.isSensor = isSensor;
        return (B) this;
    }

    public B setFriction(float friction) {
        fixtureDef.friction = friction;
        return (B) this;
    }

    public B setRestitution(float restitution) {
        fixtureDef.restitution = restitution;
        return (B) this;
    }
    
    public B setDensity(float density) {
        fixtureDef.density = density;
        return (B) this;
    }
    
    public B setId(String id){
        this.id = id;
        return (B) this;
    }

    public Fixture build(Body body) {
        Fixture fixture = body.createFixture(fixtureDef);
        fixture.setUserData(new Box2DMetaData(id));
        return fixture;
    }
}
