package uk.co.codeecho.gdx.forge.component.builder;

import uk.co.codeecho.gdx.forge.component.Component;

public interface ComponentBuilder<C extends Component> {

    public C build();
    
}
