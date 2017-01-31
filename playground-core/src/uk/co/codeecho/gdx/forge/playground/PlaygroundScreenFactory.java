package uk.co.codeecho.gdx.forge.playground;

import uk.co.codeecho.gdx.forge.library.screen.SplashTextScreen;
import uk.co.codeecho.gdx.forge.screen.ScreenFactoryImpl;
import uk.co.codeecho.gdx.forge.screen.SimpleScreenBuilder;
import uk.co.codeecho.gdx.forge.screen.SingleInstanceScreenBuilder;

public class PlaygroundScreenFactory extends ScreenFactoryImpl{

    public PlaygroundScreenFactory() {
        init();
    }
    
    private void init(){
        addBuilder(Screens.START, new SimpleScreenBuilder(StartScreen.class));
        addBuilder(Screens.LEVEL1, new SimpleScreenBuilder(PlaygroundScreen.class));
        addBuilder(Screens.GAME_OVER, new SingleInstanceScreenBuilder(new SplashTextScreen("Game Over!", 2, 3, Screens.START)));
        addBuilder(Screens.GAME_COMPLETE, new SingleInstanceScreenBuilder(new SplashTextScreen("Congratulations!", 2, 3, Screens.START)));
    }

}
