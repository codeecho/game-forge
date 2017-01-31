package uk.co.codeecho.gdx.forge.screen;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import uk.co.codeecho.gdx.forge.Renderable;
import uk.co.codeecho.gdx.forge.Updatable;
import uk.co.codeecho.gdx.forge.component.Component;
import uk.co.codeecho.gdx.forge.component.IdentifiedComponent;
import uk.co.codeecho.gdx.forge.event.DelegatingEventListener;
import uk.co.codeecho.gdx.forge.event.Event;
import uk.co.codeecho.gdx.forge.event.EventListener;

public class ScreenLayer implements Updatable, Renderable, EventListener<Event>{

    private final String id;
    private final LinkedList<Component> components;
    private final DelegatingEventListener eventHandler;

    public ScreenLayer() {
        this(null);
    }

    public ScreenLayer(String id) {
        this.id = id;
        this.components = new LinkedList<Component>();
        this.eventHandler = new DelegatingEventListener();
    }

    public String getId() {
        return id;
    }

    public void addComponent(Component component) {
        components.add(component);
        if(component instanceof EventListener){
            eventHandler.addEventListener((EventListener) component);
        }
    }

    public void addComponents(List<Component> components) {
        for(Component component: components){
            addComponent(component);
        }
    }

    public Component getComponent(String id){
        for(Component component: components){
            if(component instanceof IdentifiedComponent){
                IdentifiedComponent identifiedComponent = (IdentifiedComponent)component;
                if(id.equals(identifiedComponent.getId())){
                    return identifiedComponent;
                }
            }
        }
        return null;
    }
    
    @Override
    public boolean handle(Event event) {
        return eventHandler.handle(event);
    }

    @Override
    public void update(float delta) {
        for (Component component : components) {
            if (component instanceof Updatable) {
                Updatable updatable = (Updatable) component;
                updatable.update(delta);
            }
        }
    }

    @Override
    public void render() {
        for (Component component : components) {
            if (component instanceof Renderable) {
                Renderable renderable = (Renderable) component;
                renderable.render();
            }
        }
    }

}
