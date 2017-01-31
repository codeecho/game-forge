package uk.co.codeecho.gdx.forge.event;

public abstract class AbstractEventTypeFilter<E extends Event> extends EventTypeFilter{

    public AbstractEventTypeFilter(Class<E> type) {
        super(type);
    }

    @Override
    public boolean accepts(Event event) {
        if(super.accepts(event)){
            return doAccepts((E) event);
        }
        return false;
    }

    public abstract boolean doAccepts(E event);
}
