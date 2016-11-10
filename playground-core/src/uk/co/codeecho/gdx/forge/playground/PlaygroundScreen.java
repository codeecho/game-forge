package uk.co.codeecho.gdx.forge.playground;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import uk.co.codeecho.gdx.forge.library.event.listener.SpriteBatchEventListener;
import uk.co.codeecho.gdx.forge.screen.Screen;
import uk.co.codeecho.gdx.forge.screen.ScreenLayer;

public class PlaygroundScreen extends Screen{

    private SpriteBatch spriteBatch;
    
    public PlaygroundScreen() {
        spriteBatch = new SpriteBatch();
        addEventListener(new SpriteBatchEventListener(spriteBatch));
        ScreenLayer layer1 = new ScreenLayer();
        layer1.addComponent(new TextureComponent(spriteBatch, new Texture("badlogic.jpg")));
        addLayer(layer1);
    }

}
