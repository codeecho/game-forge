package uk.co.codeecho.gdx.forge.component.builder;

import java.util.HashMap;
import java.util.Map;

public class ComponentBuilderFactoryImpl implements ComponentBuilderFactory{

    private final Map<String, ComponentBuilderProvider> providers;

    public ComponentBuilderFactoryImpl() {
        this.providers = new HashMap<String, ComponentBuilderProvider>();
    }
    
    public void addProvider(String type, ComponentBuilderProvider provider){
        providers.put(type, provider);
    }

    @Override
    public ComponentBuilder getBuilder(String type) {
        if(!providers.containsKey(type)){
            throw new ComponentBuilderException("No builder found for " + type);
        }
        return providers.get(type).getBuilder();
    }
    
}
