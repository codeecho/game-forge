package uk.co.codeecho.gdx.forge.event;

public class FilteringEventListener implements EventListener<Event>{

    private EventFilter filter;
    private EventHandler handler;

    public FilteringEventListener(EventFilter filter, EventHandler handler) {
        this.filter = filter;
        this.handler = handler;
    }
    
    @Override
    public boolean handle(Event event) {
        if(filter.accepts(event)){
            handler.handle(event);
            return true;
        }
        return false;
    }

}
