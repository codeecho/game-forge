package uk.co.codeecho.gdx.forge.observer;

public interface Identifier<S, K> {

    public K identify(S subject);
    
}
