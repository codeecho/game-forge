package uk.co.codeecho.gdx.forge.library.action;

import uk.co.codeecho.gdx.forge.GameManager;
import uk.co.codeecho.gdx.forge.action.Action;

public class ChangeScreenAction implements Action{

    private String screen;

    public ChangeScreenAction(String screen) {
        this.screen = screen;
    }

    @Override
    public boolean invoke(float delta) {
        GameManager.getInstance().loadScreen(screen);
        return true;
    }
    
}
