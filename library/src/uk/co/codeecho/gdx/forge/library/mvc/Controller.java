package uk.co.codeecho.gdx.forge.library.mvc;

import uk.co.codeecho.gdx.forge.component.Renderable;
import uk.co.codeecho.gdx.forge.component.Updatable;
import uk.co.codeecho.gdx.forge.component.Component;

public class Controller<V extends Renderable> implements Component, Updatable, Renderable{

    protected final V view;

    public Controller(V view) {
        this.view = view;
    }

    @Override
    public void update(float delta) {
        if(view instanceof Updatable){
            ((Updatable)view).update(delta);
        }
    }

    @Override
    public void render() {
        view.render();
    }
    
}
