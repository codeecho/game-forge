package uk.co.codeecho.gdx.forge.playground;

import uk.co.codeecho.gdx.forge.screen.ScreenFactoryImpl;
import uk.co.codeecho.gdx.forge.screen.SimpleScreenBuilder;

public class PlaygroundScreenFactory extends ScreenFactoryImpl{

    public PlaygroundScreenFactory() {
        init();
    }
    
    private void init(){
        addBuilder(Screens.MAIN, new SimpleScreenBuilder(PlaygroundScreen.class));
    }

}
