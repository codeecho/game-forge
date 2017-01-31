package uk.co.codeecho.gdx.forge.library.component.builder.provider;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import uk.co.codeecho.gdx.forge.component.builder.ComponentBuilder;
import uk.co.codeecho.gdx.forge.component.builder.ComponentBuilderProvider;
import uk.co.codeecho.gdx.forge.library.component.builder.TextureComponentBuilder;

public class TextureComponentBuilderProvider implements ComponentBuilderProvider {

    private final Texture texture;
    private final SpriteBatch spriteBatch;

    public TextureComponentBuilderProvider(Texture texture, SpriteBatch spriteBatch) {
        this.texture = texture;
        this.spriteBatch = spriteBatch;
    }

    @Override
    public ComponentBuilder getBuilder() {
        return new TextureComponentBuilder(texture, spriteBatch);
    }

}
