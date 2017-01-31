package uk.co.codeecho.gdx.forge.playground;

import uk.co.codeecho.gdx.forge.library.component.TextureComponent;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import uk.co.codeecho.gdx.forge.screen.Screen;
import uk.co.codeecho.gdx.forge.screen.ScreenLayer;

public class BadLogicScreen extends Screen{

    private final SpriteBatch spriteBatch;
    
    public BadLogicScreen() {
        spriteBatch = new SpriteBatch();
        ScreenLayer layer1 = new ScreenLayer();
        layer1.addComponent(new TextureComponent(new Rectangle(0, 0, 100, 100), new Texture("badlogic.jpg"), spriteBatch));
        addLayer(layer1);
    }

}
