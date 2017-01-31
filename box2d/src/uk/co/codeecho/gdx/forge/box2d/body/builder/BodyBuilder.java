package uk.co.codeecho.gdx.forge.box2d.body.builder;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

public class BodyBuilder extends AbstractBodyBuilder<BodyBuilder>{

    public BodyBuilder(World world, BodyDef.BodyType bodyType) {
        super(world, bodyType);
    }

}
