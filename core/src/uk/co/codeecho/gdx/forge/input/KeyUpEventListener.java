package uk.co.codeecho.gdx.forge.input;

import java.util.List;

public abstract class KeyUpEventListener extends KeyEventListener<KeyUpEvent>{

    public KeyUpEventListener() {
        super(KeyUpEvent.class);
    }

    public KeyUpEventListener(int... keys) {
        super(KeyUpEvent.class, keys);
    }

    public KeyUpEventListener(List<Integer> keys) {
        super(KeyUpEvent.class, keys);
    }

}
