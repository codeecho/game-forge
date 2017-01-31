package uk.co.codeecho.gdx.forge.input;

import java.util.List;

public class KeyDownEventFilter extends KeyEventFilter<KeyDownEvent>{

    public KeyDownEventFilter() {
        super(KeyDownEvent.class);
    }
    
    public KeyDownEventFilter(int key) {
        super(KeyDownEvent.class, key);
    }
    
    public KeyDownEventFilter(List<Integer> keys) {
        super(KeyDownEvent.class, keys);
    }

}
