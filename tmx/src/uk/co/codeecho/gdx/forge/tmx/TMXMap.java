package uk.co.codeecho.gdx.forge.tmx;

import java.util.List;
import uk.co.codeecho.gdx.forge.screen.ScreenLayer;

public class TMXMap {

    private final List<ScreenLayer> layers;
    private final float width;
    private final float height;

    public TMXMap(List<ScreenLayer> layers, float width, float height) {
        this.layers = layers;
        this.width = width;
        this.height = height;
    }

    public List<ScreenLayer> getLayers() {
        return layers;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
    
}
