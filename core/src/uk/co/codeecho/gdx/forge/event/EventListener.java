package uk.co.codeecho.gdx.forge.event;

public interface EventListener<E extends Event> {

    public boolean handle(E event);
    
}
