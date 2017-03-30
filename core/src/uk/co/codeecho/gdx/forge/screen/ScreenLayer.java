package uk.co.codeecho.gdx.forge.screen;

import uk.co.codeecho.gdx.forge.component.CompositeUpdatableRenderableEventListener;

public class ScreenLayer extends CompositeUpdatableRenderableEventListener{

    private final String id;
    

    public ScreenLayer() {
        this(null);
    }

    public ScreenLayer(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

}
