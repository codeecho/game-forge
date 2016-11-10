package uk.co.codeecho.gdx.forge.playground.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import uk.co.codeecho.gdx.forge.playground.PlaygroundGame;

public class DesktopLauncher {

    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = 640;
        config.height = 512;
        new LwjglApplication(new PlaygroundGame(), config);
    }
}
