package uk.co.codeecho.gdx.forge.event;

import java.util.LinkedList;
import java.util.List;

public class DelegatingEventListener implements EventListener<Event>{

    private final List<EventListener> eventListeners = new LinkedList<EventListener>();

    public void addEventListener(EventListener eventListener) {
        eventListeners.add(eventListener);
    }

    public void addEventListener(EventFilter filter, EventHandler handler) {
        addEventListener(new FilteringEventListener(filter, handler));
    }
    
    public void addEventListener(Class<? extends Event> type, EventHandler handler){
        addEventListener(new EventTypeFilter(type), handler);
    }

    public boolean handle(Event event) {
        for (EventListener eventListener : eventListeners) {
            if (eventListener.handle(event)) {
                return true;
            }
        }
        return false;
    }
    
}
