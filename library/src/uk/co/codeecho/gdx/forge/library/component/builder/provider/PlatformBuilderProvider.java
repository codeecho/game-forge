package uk.co.codeecho.gdx.forge.library.component.builder.provider;

import com.badlogic.gdx.physics.box2d.World;
import uk.co.codeecho.gdx.forge.component.builder.ComponentBuilder;
import uk.co.codeecho.gdx.forge.component.builder.ComponentBuilderProvider;
import uk.co.codeecho.gdx.forge.library.component.builder.PlatformBuilder;

public class PlatformBuilderProvider implements ComponentBuilderProvider{

    private final World world;

    public PlatformBuilderProvider(World world) {
        this.world = world;
    }

    @Override
    public ComponentBuilder getBuilder() {
        return new PlatformBuilder(world);
    }
    
}
