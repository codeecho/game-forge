package uk.co.codeecho.gdx.forge.component;

import uk.co.codeecho.gdx.forge.event.DelegatingEventListener;
import uk.co.codeecho.gdx.forge.event.Event;
import uk.co.codeecho.gdx.forge.event.EventListener;

public class CompositeUpdatableRenderableEventListener extends CompositeUpdatableRenderable implements EventListener{

    private final DelegatingEventListener eventHandler = new DelegatingEventListener();
    
    @Override
    public void addComponent(Component component) {
        if(component instanceof EventListener){
            eventHandler.addEventListener((EventListener)component);
        }
        super.addComponent(component);
    }

    @Override
    public boolean handle(Event event) {
        return eventHandler.handle(event);
    }

}
