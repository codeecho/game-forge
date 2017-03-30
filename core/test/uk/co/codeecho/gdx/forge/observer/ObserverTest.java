package uk.co.codeecho.gdx.forge.observer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import uk.co.codeecho.gdx.forge.input.key.KeyDownEvent;
import uk.co.codeecho.gdx.forge.mutable.MutableBoolean;

public class ObserverTest {

    @Test
    public void test(){
        final KeyDownEvent event = new KeyDownEvent(13);
        Observable<KeyDownEvent, Integer> observable = new Observable<KeyDownEvent, Integer>(event, new Identifier<KeyDownEvent, Integer>() {
            
            @Override
            public Integer identify(KeyDownEvent subject) {
                return subject.getKey();
            }
        });
        final MutableBoolean observed = new MutableBoolean(false);
        observable.subscribe(new Observer<KeyDownEvent, Integer>() {

            @Override
            public void onChange(KeyDownEvent subject, Integer oldIdentity, Integer newIdentity) {
                assertEquals(event, subject);
                assertEquals(13, oldIdentity, 0);
                assertEquals(1, newIdentity, 0);
                observed.setValue(true);
            }
        });
        event.setKey(1);
        observable.update(1f);
        assertTrue(observed.getValue());
    }
    
}
