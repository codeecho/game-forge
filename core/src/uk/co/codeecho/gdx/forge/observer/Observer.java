package uk.co.codeecho.gdx.forge.observer;

public interface Observer<S, K> {

    public void onChange(S subject, K oldIdentity, K newIdentity);
    
}
