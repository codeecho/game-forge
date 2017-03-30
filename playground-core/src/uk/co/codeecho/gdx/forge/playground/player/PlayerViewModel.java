package uk.co.codeecho.gdx.forge.playground.player;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.World;
import uk.co.codeecho.gdx.forge.box2d.Box2DModel;
import uk.co.codeecho.gdx.forge.box2d.body.builder.BodyBuilder;
import uk.co.codeecho.gdx.forge.box2d.fixture.builder.FixtureBuilder;
import uk.co.codeecho.gdx.forge.library.box2d.BoxShape;
import uk.co.codeecho.gdx.forge.library.state.Direction;
import uk.co.codeecho.gdx.forge.library.state.Directional;
import uk.co.codeecho.gdx.forge.library.state.Stateful;

public class PlayerViewModel implements Box2DModel, Stateful, Directional{
    
    private static Body buildBody(World world, float x, float y, float radius) {
        Body body = new BodyBuilder(world, BodyDef.BodyType.DynamicBody)
                .setType("player")
                .setPosition(new Vector2(x, y))
                .build();
        CircleShape circleShape = new CircleShape();
        circleShape.setRadius(radius);
        new FixtureBuilder()
                .setId("wrapper")
                .isSensor(true)
                .setShape(circleShape)
                .build(body);
        float innerRadius = (float) Math.sqrt((radius * radius) / 2);
        new FixtureBuilder()
                .setId("boundary")
                .setShape(new BoxShape(innerRadius*2, innerRadius*2))
                .build(body);
        return body;
    }
    
    private final Body body;
    private final float radius;
    
    public PlayerViewModel(World world, float x, float y, float radius) {
        this.body = buildBody(world, x, y, radius);
        this.radius = radius;
    }

    @Override
    public Body getBody() {
        return body;
    }

    public float getRadius() {
        return radius;
    }

    @Override
    public String getState() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Direction getDirection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
