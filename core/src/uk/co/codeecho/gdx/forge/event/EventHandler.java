package uk.co.codeecho.gdx.forge.event;

public interface EventHandler<E extends Event> {
    
    public void handle(E event);
    
}
