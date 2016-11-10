package uk.co.codeecho.gdx.forge.library.event.listener;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import uk.co.codeecho.gdx.forge.event.DelegatingEventListener;
import uk.co.codeecho.gdx.forge.event.Event;
import uk.co.codeecho.gdx.forge.event.EventHandler;
import uk.co.codeecho.gdx.forge.screen.event.PostRenderEvent;
import uk.co.codeecho.gdx.forge.screen.event.PreRenderEvent;

public class SpriteBatchEventListener extends DelegatingEventListener{
    
    public SpriteBatchEventListener(final SpriteBatch spriteBatch) {
        addEventListener(PreRenderEvent.class, new EventHandler() {

            @Override
            public void handle(Event event) {
                spriteBatch.begin();
            }
        });
        addEventListener(PostRenderEvent.class, new EventHandler() {

            @Override
            public void handle(Event event) {
                spriteBatch.end();
            }
        });
    }

}
