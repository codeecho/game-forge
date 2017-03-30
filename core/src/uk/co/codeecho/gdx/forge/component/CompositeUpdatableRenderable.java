package uk.co.codeecho.gdx.forge.component;

public class CompositeUpdatableRenderable extends CompositeComponent<Component> implements UpdatableRenderable{

    private final CompositeUpdatable<Updatable> updatables = new CompositeUpdatable<Updatable>();
    private final CompositeRenderable<Renderable> renderables = new CompositeRenderable<Renderable>();

    @Override
    public void addComponent(Component component) {
        if(component instanceof Updatable){
            updatables.addComponent((Updatable)component);
        }
        if(component instanceof Renderable){
            renderables.addComponent((Renderable)component);
        }
        super.addComponent(component);
    }
    
    @Override
    public void update(float delta) {
        updatables.update(delta);
    }

    @Override
    public void render() {
        renderables.render();
    }

}
