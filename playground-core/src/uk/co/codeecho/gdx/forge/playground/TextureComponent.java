package uk.co.codeecho.gdx.forge.playground;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import uk.co.codeecho.gdx.forge.Renderable;
import uk.co.codeecho.gdx.forge.component.Component;

public class TextureComponent implements Component, Renderable {

    private final SpriteBatch spriteBatch;
    private final Texture texture;

    public TextureComponent(SpriteBatch spriteBatch, Texture texture) {
        this.spriteBatch = spriteBatch;
        this.texture = texture;
    }

    @Override
    public void render() {
        spriteBatch.draw(texture, 0, 0);
    }

}
