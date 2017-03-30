package uk.co.codeecho.gdx.forge.playground;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import uk.co.codeecho.gdx.forge.component.builder.ComponentBuilder;
import uk.co.codeecho.gdx.forge.component.builder.ComponentBuilderFactoryImpl;
import uk.co.codeecho.gdx.forge.component.builder.ComponentBuilderProvider;
import uk.co.codeecho.gdx.forge.library.component.builder.provider.BlockBuilderProvider;
import uk.co.codeecho.gdx.forge.library.scene2d.Scene2DRenderer;
import uk.co.codeecho.gdx.forge.playground.round.RoundTimerBuilder;

public class PlaygroundComponentBuilderFactory extends ComponentBuilderFactoryImpl{

    public PlaygroundComponentBuilderFactory(final SpriteBatch spriteBatch, final World world, final Scene2DRenderer renderer) {
        addProvider("button", new BlockBuilderProvider(world, "button"));
        addProvider("block", new BlockBuilderProvider(world));
        addProvider("instructions", new BlockBuilderProvider(world));
        addProvider("time", new ComponentBuilderProvider() {

            @Override
            public ComponentBuilder getBuilder() {
                return new RoundTimerBuilder(renderer);
            }
        });
    }

}
