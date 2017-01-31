package uk.co.codeecho.gdx.forge;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Rectangle;
import uk.co.codeecho.gdx.forge.event.Event;
import uk.co.codeecho.gdx.forge.event.EventHandler;
import uk.co.codeecho.gdx.forge.input.InputProcessor;
import uk.co.codeecho.gdx.forge.screen.Screen;
import uk.co.codeecho.gdx.forge.screen.ScreenFactory;
import uk.co.codeecho.gdx.forge.screen.event.LoadScreenEvent;
import uk.co.codeecho.gdx.forge.screen.event.UnloadScreenEvent;

public class GameManager implements EventHandler<Event> {

    private static GameManager instance;
    
    private final InputProcessor inputProcessor;

    private float pixelsPerUnit = 1;
    private ScreenFactory screenFactory;

    private Screen activeScreen;
    
    private boolean debugMode;

    private GameManager() {
        this.inputProcessor = new InputProcessor();
        Gdx.input.setInputProcessor(inputProcessor);
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
    
    public Rectangle getDisplayBoundsInPixels(){
        return new Rectangle(0, 0, getDisplayWidthInPixels(), getDisplayHeightInPixels());
    }
    
    public Rectangle getDisplayBoundsInUnits(){
        return new Rectangle(0, 0, getDisplayWidthInUnits(), getDisplayHeightInUnits());
    }

    public void loadScreen(String screenName) {
        if(activeScreen!=null){
            activeScreen.handle(new UnloadScreenEvent());
        }
        activeScreen = screenFactory.buildScreen(screenName);
        activeScreen.handle(new LoadScreenEvent());
    }

    public boolean isDebugMode() {
        return debugMode;
    }

    public void setDebugMode(boolean debugMode) {
        this.debugMode = debugMode;
    }

    public void update() {
        float deltaTime = Gdx.graphics.getDeltaTime();
        inputProcessor.update(deltaTime);
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
