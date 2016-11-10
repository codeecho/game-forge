package uk.co.codeecho.gdx.forge.screen;

import com.badlogic.gdx.utils.reflect.ClassReflection;
import com.badlogic.gdx.utils.reflect.ReflectionException;

public class SimpleScreenBuilder implements ScreenBuilder{

    private final Class<? extends Screen> clazz;

    public SimpleScreenBuilder(Class<? extends Screen> clazz) {
        this.clazz = clazz;
    }

    @Override
    public Screen build() {
        try {
            return ClassReflection.newInstance(clazz);
        } catch (ReflectionException ex) {
            throw new ScreenBuilderException(ex);
        }
    }

}
