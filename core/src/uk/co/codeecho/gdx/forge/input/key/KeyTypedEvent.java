package uk.co.codeecho.gdx.forge.input.key;

import uk.co.codeecho.gdx.forge.event.Event;

public class KeyTypedEvent implements Event{

    private final char character;

    public KeyTypedEvent(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }
    
}
