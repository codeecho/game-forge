package uk.co.codeecho.gdx.forge.screen;

public class SingleInstanceScreenBuilder implements ScreenBuilder{

    private final Screen screen;

    public SingleInstanceScreenBuilder(Screen screen) {
        this.screen = screen;
    }
    
    @Override
    public Screen build() {
        return screen;
    }

}
