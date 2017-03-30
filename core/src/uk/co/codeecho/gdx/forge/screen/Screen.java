package uk.co.codeecho.gdx.forge.screen;

import com.badlogic.gdx.graphics.Color;
import java.util.LinkedList;
import java.util.List;
import uk.co.codeecho.gdx.forge.component.Renderable;
import uk.co.codeecho.gdx.forge.component.Updatable;
import uk.co.codeecho.gdx.forge.action.Action;
import uk.co.codeecho.gdx.forge.action.ActionManager;
import uk.co.codeecho.gdx.forge.action.ResettableAction;
import uk.co.codeecho.gdx.forge.component.Component;
import uk.co.codeecho.gdx.forge.event.DelegatingEventListener;
import uk.co.codeecho.gdx.forge.event.Event;
import uk.co.codeecho.gdx.forge.event.EventFilter;
import uk.co.codeecho.gdx.forge.event.EventHandler;
import uk.co.codeecho.gdx.forge.event.EventListener;
import uk.co.codeecho.gdx.forge.event.EventTypeFilter;
import uk.co.codeecho.gdx.forge.screen.event.PostRenderEvent;
import uk.co.codeecho.gdx.forge.screen.event.PostUpdateEvent;
import uk.co.codeecho.gdx.forge.screen.event.PreRenderEvent;
import uk.co.codeecho.gdx.forge.screen.event.PreUpdateEvent;

public abstract class Screen implements Updatable, Renderable, EventListener<Event> {

    private final LinkedList<ScreenLayer> layers;
    private final DelegatingEventListener eventHandler;
    private final ActionManager actionManager;
    private final ScreenLayer defaultLayer;

    public Screen() {
        this.layers = new LinkedList<ScreenLayer>();
        this.eventHandler = new DelegatingEventListener();
        this.actionManager = new ActionManager();
        this.defaultLayer = new ScreenLayer();
    }

    public void addLayer(ScreenLayer layer) {
        layers.add(layer);
    }
    
    public void addLayers(List<ScreenLayer> layers){
        for(ScreenLayer layer: layers){
            addLayer(layer);
        }
    }

    public void addComponent(Component component) {
        defaultLayer.addComponent(component);
    }

    public void addComponents(List<Component> components) {
        defaultLayer.addComponents(components);
    }
    
    public Component getComponent(String id){
        Component component = defaultLayer.getComponent(id);
        if(component != null){
            return component;
        }
        for(ScreenLayer layer: layers){
            component = layer.getComponent(id);
            if(component!=null){
                return component;
            }
        }
        throw new IllegalArgumentException("Component with id " + id + " does not exist");
    }

    public void addAction(Action action) {
        actionManager.addAction(action);
    }

    public Color getClearColor() {
        return Color.BLACK;
    }

    @Override
    public void update(float delta) {
        handle(new PreUpdateEvent(delta));
        actionManager.update(delta);
        for (ScreenLayer layer : layers) {
            layer.update(delta);
        }
        defaultLayer.update(delta);
        handle(new PostUpdateEvent());
    }

    @Override
    public void render() {
        handle(new PreRenderEvent());
        for (ScreenLayer layer : layers) {
            layer.render();
        }
        defaultLayer.render();
        handle(new PostRenderEvent());
    }

    protected void addEventListener(EventListener eventListener) {
        eventHandler.addEventListener(eventListener);
    }

    protected void addEventListener(EventFilter filter, EventHandler handler) {
        eventHandler.addEventListener(filter, handler);
    }
    
    protected void addEventListener(Class<? extends Event> type, final Action action){
        addEventListener(new EventTypeFilter(type), action);
    }
    
    protected void addEventListener(EventFilter filter, final Action action) {
        eventHandler.addEventListener(filter, new EventHandler() {

            @Override
            public void handle(Event event) {
                if(action instanceof ResettableAction){
                    ((ResettableAction)action).reset();
                }
                addAction(action);
            }
        });
    }

    public boolean handle(Event event) {
        if(eventHandler.handle(event)){
           return true; 
        }
        if(defaultLayer.handle(event)){
            return true;
        }
        for(ScreenLayer layer: layers){
            if(layer.handle(event)){
                return true;
            }
        }
        return false;
    }

}
