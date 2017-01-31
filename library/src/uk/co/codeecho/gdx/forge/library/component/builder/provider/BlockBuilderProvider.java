package uk.co.codeecho.gdx.forge.library.component.builder.provider;

import com.badlogic.gdx.physics.box2d.World;
import uk.co.codeecho.gdx.forge.component.builder.ComponentBuilder;
import uk.co.codeecho.gdx.forge.component.builder.ComponentBuilderProvider;
import uk.co.codeecho.gdx.forge.library.component.builder.BlockBuilder;

public class BlockBuilderProvider implements ComponentBuilderProvider{

    private final World world;
    private String type;

    public BlockBuilderProvider(World world) {
        this.world = world;
    }
    
    public BlockBuilderProvider(World world, String type) {
        this.world = world;
        this.type = type;
    }

    @Override
    public ComponentBuilder getBuilder() {
        return new BlockBuilder(world, type);
    }
    
}
