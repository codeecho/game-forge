package uk.co.codeecho.gdx.forge.event;

import com.badlogic.gdx.utils.reflect.ClassReflection;

public class EventTypeFilter implements EventFilter{

    public Class<? extends Event> type;

    public EventTypeFilter(Class<? extends Event> type) {
        this.type = type;
    }
    
    @Override
    public boolean accepts(Event event) {
        return ClassReflection.isAssignableFrom(type, event.getClass());
    }

}
