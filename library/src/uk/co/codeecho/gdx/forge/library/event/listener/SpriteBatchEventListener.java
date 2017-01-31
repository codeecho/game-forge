package uk.co.codeecho.gdx.forge.library.event.listener;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import uk.co.codeecho.gdx.forge.component.Component;
import uk.co.codeecho.gdx.forge.event.DelegatingEventListener;
import uk.co.codeecho.gdx.forge.event.Event;
import uk.co.codeecho.gdx.forge.event.EventHandler;
import uk.co.codeecho.gdx.forge.screen.event.PostRenderEvent;
import uk.co.codeecho.gdx.forge.screen.event.PreRenderEvent;

public class SpriteBatchEventListener extends DelegatingEventListener implements Component{

    public SpriteBatchEventListener(final SpriteBatch spriteBatch) {
        this(spriteBatch, null);
    }

    public SpriteBatchEventListener(final SpriteBatch spriteBatch, final OrthographicCamera camera) {
        addEventListener(PreRenderEvent.class, new EventHandler() {

            @Override
            public void handle(Event event) {
                if (camera != null) {
                    spriteBatch.setProjectionMatrix(camera.combined);
                }
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
