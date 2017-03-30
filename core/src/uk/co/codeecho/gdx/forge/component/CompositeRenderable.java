package uk.co.codeecho.gdx.forge.component;

public class CompositeRenderable<R extends Renderable> extends CompositeComponent<R> implements Renderable {

    @Override
    public void render() {
        for (R renderable : getComponents()) {
            renderable.render();
        }
    }
}
