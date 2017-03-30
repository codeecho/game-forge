package uk.co.codeecho.gdx.forge.component;

public class CompositeUpdatable<U extends Updatable> extends CompositeComponent<U> implements Updatable {

    @Override
    public void update(float delta) {
        for (Updatable updatable : getComponents()) {
            updatable.update(delta);
        }
    }
}
