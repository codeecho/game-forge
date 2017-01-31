package uk.co.codeecho.gdx.forge.library.component.builder;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import uk.co.codeecho.gdx.forge.library.box2d.builder.BlockBodyBuilder;
import uk.co.codeecho.gdx.forge.library.component.Block;
import uk.co.codeecho.gdx.forge.util.CoordinateUtils;

public class PlatformBuilder extends RectangularComponentBuilder<PlatformBuilder, Block> {

    private final World world;

    public PlatformBuilder(World world) {
        this.world = world;
    }

    @Override
    public Block build() {
        CoordinateUtils.recalculateRectangleAroundCentralCoordinates(bounds);
        Body body = new BlockBodyBuilder(world).setType("platform").setPosition(bounds.x, bounds.y).setSize(bounds.width, bounds.height).build();
        Block block = new Block(body);
        return block;
    }

}
