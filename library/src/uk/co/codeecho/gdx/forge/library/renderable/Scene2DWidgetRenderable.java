package uk.co.codeecho.gdx.forge.library.renderable;

import com.badlogic.gdx.scenes.scene2d.ui.Widget;
import uk.co.codeecho.gdx.forge.component.Renderable;
import uk.co.codeecho.gdx.forge.library.scene2d.Scene2DRenderer;

public class Scene2DWidgetRenderable<W extends Widget> implements Renderable{

    private final Scene2DRenderer renderer;
    protected W widget;

    public Scene2DWidgetRenderable(Scene2DRenderer renderer, W widget) {
        this.renderer = renderer;
        this.widget = widget;
    }

    @Override
    public void render() {
        renderer.draw(widget, 1);
    }
    
}
