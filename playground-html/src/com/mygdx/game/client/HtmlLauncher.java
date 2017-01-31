package com.mygdx.game.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import uk.co.codeecho.gdx.forge.playground.PlaygroundGame;

public class HtmlLauncher extends GwtApplication {

        @Override
        public GwtApplicationConfiguration getConfig () {
                return new GwtApplicationConfiguration(896, 512);
        }

        @Override
        public ApplicationListener getApplicationListener () {
                return new PlaygroundGame();
        }
}