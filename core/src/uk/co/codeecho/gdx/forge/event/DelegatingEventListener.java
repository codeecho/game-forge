package uk.co.codeecho.gdx.forge.event;

import java.util.LinkedList;
import java.util.List;
import uk.co.codeecho.gdx.forge.action.Action;

public class DelegatingEventListener implements EventListener<Event> {

    private final List<EventListener> eventListeners = new LinkedList<EventListener>();

    public void addEventListener(EventListener eventListener) {
        eventListeners.add(eventListener);
    }

    public void addEventListener(final EventFilter filter, final EventHandler handler) {
        addEventListener(new FilteringEventListener<Event>() {

            @Override
            public boolean accepts(Event event) {
                return filter.accepts(event);
            }

            @Override
            public void doHandle(Event event) {
                handler.handle(event);
            }
        });
    }

    public void addEventListener(Class<? extends Event> type, EventHandler handler) {
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
