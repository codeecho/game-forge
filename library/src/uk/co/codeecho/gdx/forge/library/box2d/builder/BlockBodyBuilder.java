package uk.co.codeecho.gdx.forge.library.box2d.builder;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import uk.co.codeecho.gdx.forge.box2d.body.builder.AbstractBodyBuilder;
import uk.co.codeecho.gdx.forge.box2d.fixture.builder.FixtureBuilder;
import uk.co.codeecho.gdx.forge.library.box2d.BoxShape;

public class BlockBodyBuilder extends AbstractBodyBuilder<BlockBodyBuilder> {

    private float width;
    private float height;

    public BlockBodyBuilder(World world) {
        super(world, BodyDef.BodyType.StaticBody);
        setType("block");
    }

    public BlockBodyBuilder setSize(float width, float height) {
        this.width = width;
        this.height = height;
        return this;
    }

    public BlockBodyBuilder setWidth(float width) {
        this.width = width;
        return this;
    }

    public BlockBodyBuilder setHeight(float height) {
        this.height = height;
        return this;
    }

    @Override
    public Body build() {
        Body body = super.build();
        new FixtureBuilder()
                .setId("boundary")
                .setShape(new BoxShape(width, height))
                .build(body);
        return body;
    }

}
