package uk.co.codeecho.gdx.forge.input.key;

public abstract class KeyPressedEventListener extends KeyEventListener<KeyPressedEvent>{

    public KeyPressedEventListener() {
        super(KeyPressedEvent.class);
    }

    public KeyPressedEventListener(int keys) {
        super(KeyPressedEvent.class, keys);
    }

}
