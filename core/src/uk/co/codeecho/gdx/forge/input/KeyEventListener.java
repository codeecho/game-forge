package uk.co.codeecho.gdx.forge.input;

import java.util.LinkedList;
import java.util.List;
import uk.co.codeecho.gdx.forge.event.TypeFilteringEventListener;

public abstract class KeyEventListener<E extends KeyEvent> extends TypeFilteringEventListener<E>{

    private List<Integer> keys;
    
    public KeyEventListener(Class<? extends E> type, int... keys) {
        super(type);
        this.keys = new LinkedList<Integer>();
        for(int key: keys){
            this.keys.add(key);
        }
    }

    public KeyEventListener(Class<? extends E> type, List<Integer> keys) {
        super(type);
        this.keys = keys;
    }

    @Override
    public boolean doAccepts(E event) {
        return keys == null || keys.isEmpty() || keys.contains(event.getKey());
    }
    
}
