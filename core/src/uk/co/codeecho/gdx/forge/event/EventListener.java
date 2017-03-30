package uk.co.codeecho.gdx.forge.event;

import uk.co.codeecho.gdx.forge.component.Component;

public interface EventListener<E extends Event> extends Component{

    public boolean handle(E event);
    
}
