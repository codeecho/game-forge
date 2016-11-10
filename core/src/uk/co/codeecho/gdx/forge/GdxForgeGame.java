package uk.co.codeecho.gdx.forge;

import com.badlogic.gdx.ApplicationListener;
import uk.co.codeecho.gdx.forge.screen.ScreenFactory;

public abstract class GdxForgeGame implements ApplicationListener {

    @Override
    public void create() {
        GameManager gameManager = GameManager.getInstance();
        gameManager.setPixelsPerUnit(getPixelsPerUnit());
        gameManager.setScreenFactory(createScreenFactory());
        gameManager.loadScreen(getFirstScreen());
    }
    
    protected abstract float getPixelsPerUnit();
    
    protected abstract ScreenFactory createScreenFactory();
    
    protected abstract String getFirstScreen();

    @Override
    public void render() {
        GameManager.getInstance().update();
    }

    @Override
    public void dispose() {
        
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

}
