package uk.co.codeecho.gdx.forge.playground.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import uk.co.codeecho.gdx.forge.playground.PlaygroundGame;

public class DesktopLauncher {

    // TODO: Remove duplicate code from listeners and filters Use filters in listeners
    
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = 896;
        config.height = 512;
        new LwjglApplication(new PlaygroundGame(), config);
    }
}
