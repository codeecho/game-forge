package uk.co.codeecho.gdx.forge.input;

import java.util.List;
import uk.co.codeecho.gdx.forge.event.Event;
import uk.co.codeecho.gdx.forge.event.TypeFilteringEventListener;

public abstract class KeyDownEventListener extends KeyEventListener<KeyDownEvent>{

    public KeyDownEventListener() {
        super(KeyDownEvent.class);
    }

    public KeyDownEventListener(int... keys) {
        super(KeyDownEvent.class, keys);
    }

    public KeyDownEventListener(List<Integer> keys) {
        super(KeyDownEvent.class, keys);
    }

}
