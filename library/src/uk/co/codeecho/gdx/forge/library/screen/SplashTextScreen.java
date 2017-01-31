package uk.co.codeecho.gdx.forge.library.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import uk.co.codeecho.gdx.forge.GameManager;
import uk.co.codeecho.gdx.forge.action.SequentialAction;
import uk.co.codeecho.gdx.forge.camera.StandardCamera;
import uk.co.codeecho.gdx.forge.library.action.ChangeScreenAction;
import uk.co.codeecho.gdx.forge.library.action.WaitAction;
import uk.co.codeecho.gdx.forge.library.component.Scene2DWidgetComponent;
import uk.co.codeecho.gdx.forge.library.event.listener.SpriteBatchEventListener;
import uk.co.codeecho.gdx.forge.screen.Screen;
import uk.co.codeecho.gdx.forge.screen.event.LoadScreenEvent;

public class SplashTextScreen extends Screen{
    
    private final SequentialAction action;
    
    public SplashTextScreen(String text, float fontScale, float duration, String nextScreen) {
        SpriteBatch spriteBatch = new SpriteBatch();
        OrthographicCamera camera = new StandardCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight()/2, 0);
        camera.update();
        Label label = new Label(text, new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        label.setFontScale(fontScale);
        label.setAlignment(Align.center);
        label.setY(camera.position.y);
        label.setWidth(camera.viewportWidth);
        addComponent(new Scene2DWidgetComponent(spriteBatch, label));
        addComponent(new SpriteBatchEventListener(spriteBatch, camera));
        this.action = new SequentialAction(new WaitAction(duration), new ChangeScreenAction(nextScreen));
        addEventListener(LoadScreenEvent.class, action);
    }

    @Override
    public Color getClearColor() {
        return Color.BLACK;
    }

}
