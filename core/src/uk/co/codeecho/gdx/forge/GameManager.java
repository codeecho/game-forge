package uk.co.codeecho.gdx.forge;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import uk.co.codeecho.gdx.forge.event.Event;
import uk.co.codeecho.gdx.forge.event.EventHandler;
import uk.co.codeecho.gdx.forge.screen.Screen;
import uk.co.codeecho.gdx.forge.screen.ScreenFactory;

public class GameManager implements EventHandler<Event> {

    private static GameManager instance;

    private float pixelsPerUnit = 1;
    private ScreenFactory screenFactory;

    private Screen activeScreen;

    private GameManager() {

    }

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public float getPixelsPerUnit() {
        return pixelsPerUnit;
    }

    public void setPixelsPerUnit(float pixelsPerUnit) {
        this.pixelsPerUnit = pixelsPerUnit;
    }

    public void setScreenFactory(ScreenFactory screenFactory) {
        this.screenFactory = screenFactory;
    }

    public float pixelsToUnits(float pixels) {
        return pixels / pixelsPerUnit;
    }

    public float unitsToPixels(float meters) {
        return meters * pixelsPerUnit;
    }

    public float getDisplayWidthInPixels() {
        return Gdx.graphics.getWidth();
    }

    public float getDisplayWidthInUnits() {
        return pixelsToUnits(getDisplayWidthInPixels());
    }

    public float getDisplayHeightInPixels() {
        return Gdx.graphics.getHeight();
    }

    public float getDisplayHeightInUnits() {
        return pixelsToUnits(getDisplayHeightInPixels());
    }

    public void loadScreen(String screenName) {
        activeScreen = screenFactory.buildScreen(screenName);
    }

    public void update() {
        float deltaTime = Gdx.graphics.getDeltaTime();
        clearScreen();
        if (activeScreen != null) {
            activeScreen.update(deltaTime);
            activeScreen.render();
        }
    }

    @Override
    public void handle(Event event) {
        if (activeScreen != null) {
            activeScreen.handle(event);
        }
    }

    private void clearScreen() {
        Color clearColor;
        if (activeScreen != null) {
            clearColor = activeScreen.getClearColor();
        } else {
            clearColor = Color.BLACK;
        }
        Gdx.gl.glClearColor(clearColor.r, clearColor.g, clearColor.b, clearColor.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

}
