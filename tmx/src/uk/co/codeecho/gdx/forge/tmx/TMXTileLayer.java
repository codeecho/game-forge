package uk.co.codeecho.gdx.forge.tmx;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import uk.co.codeecho.gdx.forge.screen.ScreenLayer;

public class TMXTileLayer extends ScreenLayer{

    private final OrthographicCamera camera;
    private final OrthogonalTiledMapRenderer tiledMapRenderer;
    private final TiledMapTileLayer tileLayer;

    public TMXTileLayer(OrthographicCamera camera, OrthogonalTiledMapRenderer tiledMapRenderer, TiledMapTileLayer tileLayer) {
        this(null, camera, tiledMapRenderer, tileLayer);
    }

    public TMXTileLayer(String id, OrthographicCamera camera, OrthogonalTiledMapRenderer tiledMapRenderer, TiledMapTileLayer tileLayer) {
        super(id);
        this.camera = camera;
        this.tiledMapRenderer = tiledMapRenderer;
        this.tileLayer = tileLayer;
    }

    @Override
    public void render() {
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.renderTileLayer(tileLayer);
        super.render();
    }
    
}

