package uk.co.codeecho.gdx.forge.input.touch;

import uk.co.codeecho.gdx.forge.event.TypeFilteringEventListener;

public abstract class TouchUpEventListener extends TypeFilteringEventListener<TouchUpEvent>{

    public TouchUpEventListener() {
        super(TouchUpEvent.class);
    }

    @Override
    public boolean doAccepts(TouchUpEvent event) {
        return true;
    }

}
