package uk.co.codeecho.gdx.forge.event;

public abstract class FilteringEventListener<E extends Event> implements EventListener<E>{
    
    @Override
    public boolean handle(Event event) {
        if(accepts(event)){
            doHandle((E)event);
            return true;
        }
        return false;
    }
    
    public abstract boolean accepts(Event event);
    
    public abstract void doHandle(E event);

}
