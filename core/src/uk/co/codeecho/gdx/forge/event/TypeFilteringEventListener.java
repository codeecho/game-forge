package uk.co.codeecho.gdx.forge.event;

import com.badlogic.gdx.utils.reflect.ClassReflection;

public abstract class TypeFilteringEventListener<E extends Event> extends FilteringEventListener<E>{

    private final Class<? extends E> type;

    public TypeFilteringEventListener(Class<? extends E> type) {
        this.type = type;
    }
    
    @Override
    public boolean accepts(Event event) {
        if(!ClassReflection.isAssignableFrom(type, event.getClass())){
            return false;
        }
        return doAccepts((E)event);
    }
    
    public abstract boolean doAccepts(E event);
    
    public static void main(String[] args){
        System.out.println("test");
    }

}
