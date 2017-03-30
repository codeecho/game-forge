package uk.co.codeecho.gdx.forge.mutable;

public class Mutable<M> {

    protected M value;

    public Mutable(M value) {
        this.value = value;
    }

    public M getValue() {
        return value;
    }

    public void setValue(M value) {
        this.value = value;
    }
    
}
