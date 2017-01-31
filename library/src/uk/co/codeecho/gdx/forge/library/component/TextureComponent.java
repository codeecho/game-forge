package uk.co.codeecho.gdx.forge.library.component;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import uk.co.codeecho.gdx.forge.Renderable;
import uk.co.codeecho.gdx.forge.component.Component;

public class TextureComponent implements Component, Renderable {

    private Rectangle bounds;
    private final Texture texture;
    private final SpriteBatch spriteBatch;

    public TextureComponent(Rectangle bounds, Texture texture, SpriteBatch spriteBatch) {
        this.bounds = bounds;
        this.texture = texture;
        this.spriteBatch = spriteBatch;
    }

    @Override
    public void render() {
        spriteBatch.draw(texture, bounds.x, bounds.y, bounds.width, bounds.height);
    }

}
