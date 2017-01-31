package uk.co.codeecho.gdx.forge.input;

import uk.co.codeecho.gdx.forge.event.Event;

public abstract class KeyEvent implements Event {

    private int key;

    public KeyEvent(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }
}
