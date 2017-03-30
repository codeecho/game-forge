package uk.co.codeecho.gdx.forge.library.component;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Widget;
import uk.co.codeecho.gdx.forge.component.Renderable;
import uk.co.codeecho.gdx.forge.component.Updatable;
import uk.co.codeecho.gdx.forge.component.Component;

public class Scene2DWidgetComponent<W extends Widget> implements Component, Updatable, Renderable{

    private final SpriteBatch spriteBatch;
    protected W widget;

    public Scene2DWidgetComponent(SpriteBatch spriteBatch, W widget) {
        this.spriteBatch = spriteBatch;
        this.widget = widget;
    }
    
    @Override
    public void update(float delta) {
        widget.act(delta);
    }

    @Override
    public void render() {
        widget.draw(spriteBatch, 1);
    }

}
