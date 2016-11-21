package uk.co.codeecho.gdx.forge.component.builder;

public class SingletonComponentBuilderProvider implements ComponentBuilderProvider {

    private final ComponentBuilder builder;

    public SingletonComponentBuilderProvider(ComponentBuilder builder) {
        this.builder = builder;
    }

    @Override
    public ComponentBuilder getBuilder() {
        return builder;
    }

}
