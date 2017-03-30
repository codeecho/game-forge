package uk.co.codeecho.gdx.forge.input.key;

import java.util.List;

public class KeyPressedEventFilter extends KeyEventFilter<KeyPressedEvent>{

    public KeyPressedEventFilter() {
        super(KeyPressedEvent.class);
    }
    
    public KeyPressedEventFilter(int key) {
        super(KeyPressedEvent.class, key);
    }
    
    public KeyPressedEventFilter(List<Integer> keys) {
        super(KeyPressedEvent.class, keys);
    }

}
