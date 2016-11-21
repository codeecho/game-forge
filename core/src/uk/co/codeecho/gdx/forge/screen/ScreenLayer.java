package uk.co.codeecho.gdx.forge.screen;

import java.util.LinkedList;
import java.util.List;
import uk.co.codeecho.gdx.forge.Renderable;
import uk.co.codeecho.gdx.forge.Updatable;
import uk.co.codeecho.gdx.forge.component.Component;

public class ScreenLayer implements Updatable, Renderable {

    private final String id;
    private final LinkedList<Component> components;

    public ScreenLayer() {
        this(null);
    }

    public ScreenLayer(String id) {
        this.id = id;
        this.components = new LinkedList<Component>();
    }

    public String getId() {
        return id;
    }

    public void addComponent(Component component) {
        components.add(component);
    }

    public void addComponents(List<Component> components) {
        components.addAll(components);
    }

    @Override
    public void update(float delta) {
        for (Component component : components) {
            if (component instanceof Updatable) {
                Updatable updatable = (Updatable) component;
                updatable.update(delta);
            }
        }
    }

    @Override
    public void render() {
        for (Component component : components) {
            if (component instanceof Renderable) {
                Renderable renderable = (Renderable) component;
                renderable.render();
            }
        }
    }

}
