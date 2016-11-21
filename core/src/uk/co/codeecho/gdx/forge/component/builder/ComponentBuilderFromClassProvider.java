package uk.co.codeecho.gdx.forge.component.builder;

import com.badlogic.gdx.utils.reflect.ClassReflection;
import com.badlogic.gdx.utils.reflect.ReflectionException;

public class ComponentBuilderFromClassProvider implements ComponentBuilderProvider{

    private final Class<? extends ComponentBuilder> type;

    public ComponentBuilderFromClassProvider(Class<? extends ComponentBuilder> type) {
        this.type = type;
    }

    @Override
    public ComponentBuilder getBuilder() {
        try {
            return ClassReflection.newInstance(type);
        } catch (ReflectionException ex) {
            throw new ComponentBuilderException(ex);
        }
    }
    
    
}
