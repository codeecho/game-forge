package uk.co.codeecho.gdx.forge.library.component.builder;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import uk.co.codeecho.gdx.forge.library.box2d.builder.BlockBodyBuilder;
import uk.co.codeecho.gdx.forge.library.component.Block;
import uk.co.codeecho.gdx.forge.util.CoordinateUtils;

public class BlockBuilder extends RectangularComponentBuilder<BlockBuilder, Block> {

    private final World world;
    private String type = "block";

    public BlockBuilder(World world) {
        this.world = world;
    }
    
    public BlockBuilder(World world, String type) {
        this.world = world;
        this.type = type;
    }

    @Override
    public Block build() {
        CoordinateUtils.recalculateRectangleAroundCentralCoordinates(bounds);
        Body body = new BlockBodyBuilder(world).setType(type).setPosition(bounds.x, bounds.y).setSize(bounds.width, bounds.height).build();
        Block block = new Block(body);
        return block;
    }

}
