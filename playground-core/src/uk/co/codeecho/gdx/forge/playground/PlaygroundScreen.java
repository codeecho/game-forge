package uk.co.codeecho.gdx.forge.playground;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import uk.co.codeecho.gdx.forge.camera.StandardCamera;
import uk.co.codeecho.gdx.forge.component.builder.ComponentBuilderFactory;
import uk.co.codeecho.gdx.forge.component.builder.ComponentBuilderFactoryImpl;
import uk.co.codeecho.gdx.forge.library.event.listener.SpriteBatchEventListener;
import uk.co.codeecho.gdx.forge.screen.Screen;
import uk.co.codeecho.gdx.forge.tmx.TMXMap;
import uk.co.codeecho.gdx.forge.tmx.TMXMapBuilder;
import uk.co.codeecho.gdx.forge.tmx.TMXMapBuilderImpl;

public class PlaygroundScreen extends Screen{

    private final SpriteBatch spriteBatch;
    
    public PlaygroundScreen() {
        spriteBatch = new SpriteBatch();
        OrthographicCamera camera = new StandardCamera();
        ComponentBuilderFactory componentBuilderFactory = new ComponentBuilderFactoryImpl();
        TMXMapBuilder mapBuilder = new TMXMapBuilderImpl("simple-scene.tmx", componentBuilderFactory, camera, spriteBatch);
        TMXMap map = mapBuilder.build();
        addLayers(map.getLayers());
        addEventListener(new SpriteBatchEventListener(spriteBatch, camera));
    }

}
