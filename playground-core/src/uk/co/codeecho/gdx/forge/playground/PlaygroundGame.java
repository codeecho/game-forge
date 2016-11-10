package uk.co.codeecho.gdx.forge.playground;

import uk.co.codeecho.gdx.forge.GdxForgeGame;
import uk.co.codeecho.gdx.forge.screen.Screen;
import uk.co.codeecho.gdx.forge.screen.ScreenBuilder;
import uk.co.codeecho.gdx.forge.screen.ScreenFactory;
import uk.co.codeecho.gdx.forge.screen.ScreenFactoryImpl;
import uk.co.codeecho.gdx.forge.screen.SimpleScreenBuilder;

public class PlaygroundGame extends GdxForgeGame {

    @Override
    protected float getPixelsPerUnit() {
        return 1f;
    }

    @Override
    protected ScreenFactory createScreenFactory() {
        ScreenFactoryImpl screenFactory = new ScreenFactoryImpl();
        screenFactory.addBuilder(Screens.SCREEN1, new SimpleScreenBuilder(PlaygroundScreen.class));
        return screenFactory;
    }

    @Override
    protected String getFirstScreen() {
        return Screens.SCREEN1;
    }

}
