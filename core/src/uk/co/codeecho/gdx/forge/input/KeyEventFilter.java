package uk.co.codeecho.gdx.forge.input;

import java.util.LinkedList;
import java.util.List;
import uk.co.codeecho.gdx.forge.event.AbstractEventTypeFilter;
import uk.co.codeecho.gdx.forge.event.Event;

public class KeyEventFilter<E extends KeyEvent> extends AbstractEventTypeFilter<E>{

    private List<Integer> keys;

    public KeyEventFilter(Class<E> type, int... keys) {
        super(type);
        this.keys = new LinkedList<Integer>();
        for(int key: keys){
            this.keys.add(key);
        }
    }

    public KeyEventFilter(Class<E> type, List<Integer> keys) {
        super(type);
        this.keys = keys;
    }

    @Override
    public boolean doAccepts(E event) {
        return keys == null || keys.isEmpty() || keys.contains(event.getKey());
    }
    
}
