package uk.co.codeecho.gdx.forge.playground;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import uk.co.codeecho.gdx.forge.screen.Screen;
import uk.co.codeecho.gdx.forge.screen.ScreenLayer;

public class BadLogicScreen extends Screen{

    private final SpriteBatch spriteBatch;
    
    public BadLogicScreen() {
        spriteBatch = new SpriteBatch();
        ScreenLayer layer1 = new ScreenLayer();
        layer1.addComponent(new TextureComponent(spriteBatch, new Texture("badlogic.jpg")));
        addLayer(layer1);
    }

}
