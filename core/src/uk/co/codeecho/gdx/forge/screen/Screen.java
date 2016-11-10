package uk.co.codeecho.gdx.forge.screen;

import com.badlogic.gdx.graphics.Color;
import java.util.LinkedList;
import uk.co.codeecho.gdx.forge.Renderable;
import uk.co.codeecho.gdx.forge.Updatable;
import uk.co.codeecho.gdx.forge.event.DelegatingEventListener;
import uk.co.codeecho.gdx.forge.event.Event;
import uk.co.codeecho.gdx.forge.event.EventFilter;
import uk.co.codeecho.gdx.forge.event.EventHandler;
import uk.co.codeecho.gdx.forge.event.EventListener;
import uk.co.codeecho.gdx.forge.screen.event.PostRenderEvent;
import uk.co.codeecho.gdx.forge.screen.event.PostUpdateEvent;
import uk.co.codeecho.gdx.forge.screen.event.PreRenderEvent;
import uk.co.codeecho.gdx.forge.screen.event.PreUpdateEvent;

public abstract class Screen implements Updatable, Renderable, EventListener<Event> {

    private final LinkedList<ScreenLayer> layers;
    private final DelegatingEventListener eventHandler;

    public Screen() {
        this.layers = new LinkedList<ScreenLayer>();
        this.eventHandler = new DelegatingEventListener();
    }

    public void addLayer(ScreenLayer layer) {
        layers.add(layer);
    }

    public Color getClearColor() {
        return Color.BLACK;
    }

    @Override
    public void update(float delta) {
        handle(new PreUpdateEvent());
        for (ScreenLayer layer : layers) {
            layer.update(delta);
        }
        handle(new PostUpdateEvent());
    }

    @Override
    public void render() {
        handle(new PreRenderEvent());
        for (ScreenLayer layer : layers) {
            layer.render();
        }
        handle(new PostRenderEvent());
    }

    protected void addEventListener(EventListener eventListener) {
        eventHandler.addEventListener(eventListener);
    }

    protected void addEventListener(EventFilter filter, EventHandler handler) {
        eventHandler.addEventListener(filter, handler);
    }

    protected void addEventListener(Class<? extends Event> type, EventHandler handler) {
        eventHandler.addEventListener(type, handler);
    }

    public boolean handle(Event event) {
        return eventHandler.handle(event);
    }

}
