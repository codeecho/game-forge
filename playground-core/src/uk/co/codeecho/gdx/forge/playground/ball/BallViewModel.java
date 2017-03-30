package uk.co.codeecho.gdx.forge.playground.ball;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.World;
import uk.co.codeecho.gdx.forge.box2d.body.builder.BodyBuilder;
import uk.co.codeecho.gdx.forge.box2d.fixture.builder.FixtureBuilder;

public class BallViewModel {

    private static Body buildBody(World world, float radius) {
        Body ball = new BodyBuilder(world, BodyDef.BodyType.DynamicBody)
                .setId("ball")
                .setType("ball")
                .setLinearDamping(1f)
                .setPosition(2, 2)
                .build();
        CircleShape ballShape = new CircleShape();
        ballShape.setRadius(0.1f);
        new FixtureBuilder()
                .setId("boundary")
                .setShape(ballShape)
                .setFriction(50f)
                .build(ball);
        return ball;
    }

    private final Body body;
    private final float radius;

    public BallViewModel(World world, float radius) {
        this.body = buildBody(world, radius);
        this.radius = radius;
    }

    public Body getBody() {
        return body;
    }

    public float getRadius() {
        return radius;
    }

}
