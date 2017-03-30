package uk.co.codeecho.gdx.forge.playground;

import uk.co.codeecho.gdx.forge.GameManager;
import uk.co.codeecho.gdx.forge.GdxForgeGame;
import uk.co.codeecho.gdx.forge.screen.ScreenFactory;

public class PlaygroundGame extends GdxForgeGame {

    @Override
    protected float getPixelsPerUnit() {
        return 64f;
    }

    @Override
    protected ScreenFactory createScreenFactory() {
        GameManager.getInstance().setDebugMode(true);
        return new PlaygroundScreenFactory();
    }

    @Override
    protected String getFirstScreen() {
        return Screens.MAIN;
    }

}
