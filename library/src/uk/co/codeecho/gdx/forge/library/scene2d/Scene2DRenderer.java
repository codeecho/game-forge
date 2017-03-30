package uk.co.codeecho.gdx.forge.library.scene2d;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Widget;
import uk.co.codeecho.gdx.forge.component.Updatable;
import uk.co.codeecho.gdx.forge.component.Component;

public class Scene2DRenderer implements Component, Updatable{

    private final SpriteBatch spriteBatch;
    private final SpriteBatch scene2DSpriteBatch;
    private final OrthographicCamera camera;

    public Scene2DRenderer(SpriteBatch spriteBatch) {
        this.spriteBatch = spriteBatch;
        scene2DSpriteBatch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight()/2, 0);
        camera.update();
    }
    
    
    
    @Override
    public void update(float delta) {
        camera.update();
    }
    
    public void draw(Widget widget, float parentAlpha){
        spriteBatch.end();
        scene2DSpriteBatch.setProjectionMatrix(camera.combined);
        scene2DSpriteBatch.begin();
        widget.draw(scene2DSpriteBatch, parentAlpha);
        scene2DSpriteBatch.end();
        spriteBatch.begin();
    }

}
