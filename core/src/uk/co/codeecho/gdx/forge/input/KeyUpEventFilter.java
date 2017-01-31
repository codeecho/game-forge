package uk.co.codeecho.gdx.forge.input;

import java.util.List;

public class KeyUpEventFilter extends KeyEventFilter<KeyUpEvent> {
    
    public KeyUpEventFilter() {
        super(KeyUpEvent.class);
    }
    
    public KeyUpEventFilter(int key) {
        super(KeyUpEvent.class, key);
    }
    
    public KeyUpEventFilter(List<Integer> keys) {
        super(KeyUpEvent.class, keys);
    }
    
}
