package uk.co.codeecho.gdx.forge.component.builder;

import java.util.HashMap;
import java.util.Map;

public class ComponentBuilderFactoryImpl implements ComponentBuilderFactory{

    private final Map<String, ComponentBuilderProvider> providers;

    public ComponentBuilderFactoryImpl() {
        this.providers = new HashMap<String, ComponentBuilderProvider>();
    }

    @Override
    public ComponentBuilder getBuilder(String type) {
        return providers.get(type).getBuilder();
    }
    
}
