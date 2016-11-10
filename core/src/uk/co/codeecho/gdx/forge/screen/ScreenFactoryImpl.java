package uk.co.codeecho.gdx.forge.screen;

import java.util.HashMap;
import java.util.Map;

public class ScreenFactoryImpl implements ScreenFactory{

    private final Map<String, ScreenBuilder> builders;

    public ScreenFactoryImpl() {
        this.builders = new HashMap<String, ScreenBuilder>();
    }
    
    public void addBuilder(String name, ScreenBuilder builder){
        builders.put(name, builder);
    }
    
    @Override
    public Screen buildScreen(String name) {
        return builders.get(name).build();
    }

}
