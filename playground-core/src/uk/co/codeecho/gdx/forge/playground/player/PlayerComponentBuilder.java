package uk.co.codeecho.gdx.forge.playground.player;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import uk.co.codeecho.gdx.forge.box2d.util.Box2DUtils;
import uk.co.codeecho.gdx.forge.component.builder.ComponentBuilder;

public class PlayerComponentBuilder implements ComponentBuilder<Player> {

    private final World world;
    private final SpriteBatch spriteBatch;
    private Vector2 position = new Vector2(0,0);
    private final float radius = 0.2f;

    public PlayerComponentBuilder(World world, SpriteBatch spriteBatch) {
        this.world = world;
        this.spriteBatch = spriteBatch;
    }
    
    public PlayerComponentBuilder setPosition(Vector2 position){
        this.position = position;
        return this;
    }
    
    public PlayerComponentBuilder setPosition(float x, float y){
        this.position = new Vector2(x, y);
        return this;
    }

    @Override
    public Player build() {
        PlayerViewModel viewModel = new PlayerViewModel(world, position.x, position.y, radius);
        PlayerView view = new PlayerView(viewModel, spriteBatch);
        Player component = new Player(viewModel, view);
        Box2DUtils.setComponent(viewModel.getBody(), component);
        return component;
    }

}
