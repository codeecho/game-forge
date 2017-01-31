package uk.co.codeecho.gdx.forge.library.component.builder;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import uk.co.codeecho.gdx.forge.library.component.TextureComponent;

public class TextureComponentBuilder extends RectangularComponentBuilder<TextureComponentBuilder, TextureComponent>{

    private final Texture texture;
    private final SpriteBatch spriteBatch;

    public TextureComponentBuilder(Texture texture, SpriteBatch spriteBatch) {
        this.texture = texture;
        this.spriteBatch = spriteBatch;
    }
    
    @Override
    public TextureComponent build() {
        return new TextureComponent(bounds, texture, spriteBatch);
    }

}
