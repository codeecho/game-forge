package uk.co.codeecho.gdx.forge.screen;

import java.util.LinkedList;
import uk.co.codeecho.gdx.forge.Renderable;
import uk.co.codeecho.gdx.forge.Updatable;
import uk.co.codeecho.gdx.forge.component.Component;

public class ScreenLayer implements Updatable, Renderable{

    private final LinkedList<Component> components;

    public ScreenLayer() {
        this.components = new LinkedList<Component>();
    }
    
    public void addComponent(Component component){
        components.add(component);
    }
    
    @Override
    public void update(float delta) {
        for (Component component : components) {
            if(component instanceof Updatable){
                Updatable updatable = (Updatable)component;
                updatable.update(delta);
            }
        }
    }

    @Override
    public void render() {
        for (Component component : components) {
            if(component instanceof Renderable){
                Renderable renderable = (Renderable)component;
                renderable.render();
            }
        }
    }

}
